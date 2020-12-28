package com.jpaRepositorydemousingspring.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jpaRepositorydemousingspring.entity.FacebookUser;
import com.jpaRepositorydemousingspring.service.FacebookServiceInterface;
@RestController
//@CrossOrigin(origins= {"http://localhost:4200"},methods=RequestMethod.GET,maxAge = 3000)
public class FacebookController {

	@Autowired
	private FacebookServiceInterface fs;
	@PostMapping("createProfilefacebook")
	public String createProfile(@RequestBody FacebookUser fu) {
		String str="Registration Fail";
		FacebookUser i=fs.createProfileService(fu);
		if(i!=null) {
			str="Registration Success";
		}
		return str;
	}
	@DeleteMapping("deleteProfilefacebook")
	public String deleteProfile(@PathParam("id") Long  uid) {
		String str="profile not deleted";
		FacebookUser i=fs.deleteProfileService(uid);
		if(i==null) {
			str="profile deleted";
		}
		return str;
	}
	@PutMapping("editProfilefacebook")
	public String editProfile(@RequestBody FacebookUser fu,@PathParam("id") String uid) {
		String str="profile not updated";
		FacebookUser i=fs.editProfilefacebookService(fu,uid);
		if(i!=null) {
			str="profile updated";
		}
		return str+"of user"+uid;
	}
	@GetMapping("viewProfilefacebook")
	public FacebookUser viewProfile(@PathParam("id") Long uid) {
		FacebookUser i=fs.viewProfileService(uid);
		
		return i;
	}
	@GetMapping("searchProfilefacebook")
	public List<FacebookUser> searchProfile(@PathParam("name") String name) {
		List<FacebookUser> ll=new ArrayList<>();
		ll=fs.searchProfileFacebookService(name);
		return ll;
		}
	@GetMapping("viewAllProfilefacebook")
	public List<FacebookUser> viewAllProfile() {
	List<FacebookUser> ll=new ArrayList<FacebookUser>();
	ll=fs.viewAllProfilefacebookService();
	return ll;
	}
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Profile with this id not present")
	@ExceptionHandler({Exception.class})
	public void handleException() {
	  
	}
	@ExceptionHandler({SQLException.class,DataAccessException.class})
	  public String databaseError() {
	    return "Profile with this id not present in your database";
	  }

}
