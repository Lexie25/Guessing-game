package com.br.zup.Models;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Winner implements Serializable{
	private static long serialVercionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name cannot be blank")
	private String name;
	
	@Min(value = 1,message = "Kick a valid number!")
	@NotNull
	private int kick;

	public Winner() {
		
	}

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

	public int getKick() {
		return kick;
	}

	public void setKick(int kick) {
		this.kick = kick;
	}
	
	
	
}
