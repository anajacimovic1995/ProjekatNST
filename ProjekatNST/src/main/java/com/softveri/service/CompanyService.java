package com.softveri.service;

import java.util.List;
import com.softveri.entity.Company;

public interface CompanyService {

	public List<Company> getAllCompanies();
	public Company getCompanyById(int id);
	public boolean saveCompany(Company company);
	public boolean deleteCompanyById(int id);
}
