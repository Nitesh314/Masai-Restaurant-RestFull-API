package com.masai.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemId;
	@NotBlank
	@NotEmpty
	@NotNull
	private String itemName;
	@NotBlank
	@NotEmpty
	@NotNull
	private String category;
	@NotBlank
	@NotEmpty
	@NotNull
	private Integer quantity;
	@NotBlank
	@NotEmpty
	@NotNull
	private Double cost;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "itemList")
	private List<Restaurant> restaurants=new ArrayList<>();
	

}
