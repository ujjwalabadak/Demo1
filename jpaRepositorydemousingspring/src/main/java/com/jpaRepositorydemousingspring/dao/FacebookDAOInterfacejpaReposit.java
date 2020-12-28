package com.jpaRepositorydemousingspring.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpaRepositorydemousingspring.entity.FacebookUser;
@Repository
public interface FacebookDAOInterfacejpaReposit extends JpaRepository<FacebookUser, Long>{

	@Query("from com.jpaRepositorydemousingspring.entity.FacebookUser fu where fu.name=:uname")
	public List<FacebookUser> findByName(String uname);
	
}
