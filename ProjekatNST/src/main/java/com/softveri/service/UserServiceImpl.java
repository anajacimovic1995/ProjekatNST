package com.softveri.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softveri.entity.User;
import com.softveri.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

		// Implementing Constructor based DI
		private UserRepository repository;
		
//		private CompanyServiceImpl companyService;
		
		public UserServiceImpl() {
			
		}
		
		@Autowired
		public UserServiceImpl(UserRepository repository) {
			super();
			this.repository = repository;
		}
		
		@Override
		public List<User> getAllUsers() {
			List<User> list = new ArrayList<User>();
			repository.findAll().forEach(e -> list.add(e));
			return list;
//			List<UserSQL> listSQL = new ArrayList<UserSQL>();
//			List<Company> companyList = new ArrayList<Company>();			
//			companyList = companyService.getAllCompanies();
//			repository.findAll().forEach(e -> list.add(e));
//			System.out.println(companyList.get(0).getImeKompanije());
			
//			for (UserSQL user : listSQL) {
//				for (Company company : companyList) {
//					if(user.getKompanija()==company.getIdKompanije()) {
//						User u = new User(user.getId(), user.getIme(),user.getPrezime(),user.getUsername(),user.getPassword(),
//								user.getEmail(),company);
//					list.add(u);
//					}
						
//				}
//			}
			
//			return list;
		}
		
		@Override
		public boolean saveUser(User user) {
			try {
				repository.save(user);
				return true;
			}catch(Exception ex) {
				return false;
			}
		}


}
