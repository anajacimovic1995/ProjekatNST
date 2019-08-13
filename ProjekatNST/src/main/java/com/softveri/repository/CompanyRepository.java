package com.softveri.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.softveri.entity.Company;


@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer>{

}
