package com.bosymm.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bosymm.boot.model.UserProfile;

@RestController
public class UserProfileController {
	private Map<String, UserProfile> userMap;
	
	@PostConstruct
	public void init() {
		userMap = new HashMap<String, UserProfile>();
		
		userMap.put("1", new UserProfile("1", "김무무1", 18, "010-1234-2345", "서울시 강서구"));
		userMap.put("2", new UserProfile("2", "김무무2", 28, "010-1234-2345", "서울시 강남구"));
		userMap.put("3", new UserProfile("3", "김무무3", 38, "010-1234-2345", "성남시 수정구"));
	}
	
	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		return userMap.get(id);
	}
	
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList() {
		return new ArrayList<UserProfile>(userMap.values());
	}
	
	@PutMapping("/user/{id}")
	public void putUserProfile(@PathVariable("id") String id, @RequestParam String name, int age, String phone, String address) {
		UserProfile userProfile = new UserProfile(id, name, age, phone, address);
		userMap.put(id, userProfile);
	}
	
	@PostMapping("/user/{id}")
	public void postUserProfile(@PathVariable("id") String id, @RequestParam String name, int age, String phone, String address) {
		UserProfile userProfile = userMap.get(id);
		//userProfile.setName(name);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		userMap.remove(id);
	}
}
