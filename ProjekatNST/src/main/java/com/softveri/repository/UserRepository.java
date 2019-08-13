package com.softveri.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.softveri.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
}