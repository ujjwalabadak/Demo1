package com.jpaRepositorydemousingspring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaRepositorydemousingspring.dao.FacebookDAOInterfacejpaReposit;
import com.jpaRepositorydemousingspring.entity.FacebookUser;
@Service
public class FacebookService implements FacebookServiceInterface{
	@Autowired
	private FacebookDAOInterfacejpaReposit fd;
	@Override
	public FacebookUser createProfileService(FacebookUser fu) {
		return fd.save(fu);
	}
	@Override
	public FacebookUser deleteProfileService(Long uid) {
		fd.deleteById(uid);
		return null;
	}
	@Override
	public FacebookUser editProfilefacebookService(FacebookUser fu, String uid) {
		return fd.save(fu);
	}
	@Override
	public FacebookUser viewProfileService(Long uid) {
	return fd.findById(uid).get();
	
	}
	@Override
	public List<FacebookUser> searchProfileFacebookService(String name) {
	List<FacebookUser> list=new ArrayList<>();
	list=fd.findByName(name);
	return list;
	}
	@Override
	public List<FacebookUser> viewAllProfilefacebookService() {
	List<FacebookUser> list=new ArrayList<>();
	fd.findAll().forEach(list1->list.add(list1));
	return list;
	}
}
