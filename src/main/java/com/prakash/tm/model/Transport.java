package com.prakash.tm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transport")
public class Transport {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transport_id")
	private Long id;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "plate_number",columnDefinition="varchar(50)")
	private Truck truck;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Driver driver;

	@Getter
	@Setter
	@Column(name = "date_time")
	@NotNull(message = "*Please provide date and time when truck exits")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dateTime;

	@Getter
	@Setter
	@Column(name = "destination")
	@NotEmpty(message = "*Please provide truck destination")
	private String destination;

	@Getter
	@Setter
	@Column(name = "initial_weight")
	@Min(0)
	private Double initialWeight;

	@Getter
	@Setter
	@Column(name = "final_weight")
	@Min(0)
	private Double finalWeight;

	@Getter
	@Setter
	@Column(name = "active")
	private Boolean active;
}
