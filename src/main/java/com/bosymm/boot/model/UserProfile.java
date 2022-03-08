package com.bosymm.boot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserProfile {
	
	@JsonProperty
	private String id;
	@JsonProperty
	private String name;
	@JsonProperty
	private int age;
	@JsonProperty
	private String phone;
	@JsonProperty
	private String address;
	
	public UserProfile(String id, String name, int age, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}
}
