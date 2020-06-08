package com.prakash.tm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "truck")
public class Truck {

	@Getter
	@Setter
	@Id
	@Column(name = "plate_number")
	@Length(min = 5,max = 50, message = "*Truck plate number must have at least 5 characters")
	@NotEmpty(message = "*Please provide a truck plate number")
	private String plateNumber;

	@Getter
	@Setter
	@Column(name = "mark")
	@NotEmpty(message = "*Please provide a truck mark")
	private String mark;

	@Getter
	@Setter
	@Column(name = "empty_weight")
	@Min(0)
	private Double emptyWeight;

	@Getter
	@Setter
	@Column(name = "loaded_weight")
	@Min(0)
	private Double loadedWeight;

	@Getter
	@Setter
	@JsonIgnore
	@OneToMany(mappedBy = "truck", fetch = FetchType.LAZY)
	private Set<Transport> transports;

	@Getter
	@Setter
	@Column(name = "active")
	private Boolean active;
}
