package com.recipe.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Recipes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String type;
	private String name;
	private String numberofServings;
	private Boolean ingredients;
	private String ingredients_name;
	private String search;
	
//	@ManyToMany(mappedBy = "recipes",fetch = FetchType.LAZY)
//	private List<Users> users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumberofServings() {
		return numberofServings;
	}

	public void setNumberofServings(String numberofServings) {
		this.numberofServings = numberofServings;
	}

	public Boolean getIngredients() {
		return ingredients;
	}

	public void setIngredients(Boolean ingredients) {
		this.ingredients = ingredients;
	}

	public String getIngredients_name() {
		return ingredients_name;
	}

	public void setIngredients_name(String ingredients_name) {
		this.ingredients_name = ingredients_name;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

//	public List<Users> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<Users> users) {
//		this.users = users;
//	}

//	public Recipes(Integer id, String type, String name, String numberofServings, Boolean ingredients,
//			String ingredients_name, String search, List<Users> users) {
//		super();
//		this.id = id;
//		this.type = type;
//		this.name = name;
//		this.numberofServings = numberofServings;
//		this.ingredients = ingredients;
//		this.ingredients_name = ingredients_name;
//		this.search = search;
//		this.users = users;
//	}

	public Recipes(Integer id, String type, String name, String numberofServings, Boolean ingredients,
			String ingredients_name, String search) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.numberofServings = numberofServings;
		this.ingredients = ingredients;
		this.ingredients_name = ingredients_name;
		this.search = search;
	}

	public Recipes() {
		super();
	}

	

	
}