package com.softveri.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softveri.entity.Company;
import com.softveri.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	private CompanyRepository repository;
	public CompanyServiceImpl() {
	
	}
	@Autowired
	public CompanyServiceImpl(CompanyRepository repository) {
		super();
		this.repository = repository;
	}
		
	@Override
	public List<Company> getAllCompanies() {
		List<Company> list = new ArrayList<Company>();
		repository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Company getCompanyById(int id) {
		Company company = repository.findById(id).get();
		return company;
	}

	@Override
	public boolean saveCompany(Company company) {
		try {
			repository.save(company);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteCompanyById(int id) {
		try {
			repository.deleteById(id);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

}
