package com.ram.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String username;
	private String pwd;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
}
