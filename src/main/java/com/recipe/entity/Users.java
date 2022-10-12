package com.recipe.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "USER_RECIPES_TABLE",
	joinColumns = {@JoinColumn(name ="Usere_id",referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name ="Recipe_id",referencedColumnName = "id")})
	private List<Recipes> recipes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Recipes> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipes> recipes) {
		this.recipes = recipes;
	}

	public Users(Integer id, String name, List<Recipes> recipes) {
		super();
		this.id = id;
		this.name = name;
		this.recipes = recipes;
	}

	public Users(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Users() {
		super();
	}
	
	
	
	
	
	

}
