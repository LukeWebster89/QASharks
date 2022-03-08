package com.example.sharks.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String species;
	
	@Column
	private String name;
	
	@Column
	private String habitat;

	public Shark() {
		super();
	}

	public Shark(long id, String species, String name, String habitat) {
		super();
		this.id = id;
		this.species = species;
		this.name = name;
		this.habitat = habitat;
	}

	public Shark(String species, String name, String habitat) {
		super();
		this.species = species;
		this.name = name;
		this.habitat = habitat;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	@Override
	public String toString() {
		return "Shark [id=" + id + ", species=" + species + ", name=" + name + ", habitat=" + habitat + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(habitat, id, name, species);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shark other = (Shark) obj;
		return Objects.equals(habitat, other.habitat) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(species, other.species);
	}
	
	

}
