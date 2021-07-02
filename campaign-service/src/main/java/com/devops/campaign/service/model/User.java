package com.devops.campaign.service.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Integer userId;
	public String username;

	public String name;
	public String surname;
	public String phoneNumber;
	public String sex;
}