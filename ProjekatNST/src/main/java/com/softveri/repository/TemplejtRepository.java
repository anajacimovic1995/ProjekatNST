package com.softveri.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softveri.entity.Templejt;

@Repository
public interface TemplejtRepository extends CrudRepository<Templejt, Integer>{

}
