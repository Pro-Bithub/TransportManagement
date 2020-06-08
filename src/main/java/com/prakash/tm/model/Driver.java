package com.prakash.tm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "driver")
public class Driver {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "driver_id")
	private Long id;

	@Getter
	@Setter
	@Column(name = "first_name")
	@NotEmpty(message = "*Please provide driver first name")
	private String firstname;

	@Getter
	@Setter
	@Column(name = "last_name")
	@NotEmpty(message = "*Please provide driver last name")
	private String lastname;

	@Getter
	@Setter
	@Column(name = "telephone")
	@Length(min = 10, message = "*Driver telephone number must have at least 10 characters")
	@NotEmpty(message = "*Please provide driver telephone number")
	private String telephone;

	@Getter
	@Setter
	@JsonIgnore
	@OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
	private Set<Transport> transports;

	@Getter
	@Setter
	@Column(name = "active")
	private Boolean active;
}
