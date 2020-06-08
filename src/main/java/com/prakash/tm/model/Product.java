package com.prakash.tm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Long id;

	@Getter
	@Setter
	@Column(name = "name")
	@NotEmpty(message = "*Please provide product name")
	private String name;

	@Getter
	@Setter
	@Column(name = "price")
	@Min(0)
	private Double price;

	@Getter
	@Setter
	@Column(name = "active")
	private Boolean active;
}
