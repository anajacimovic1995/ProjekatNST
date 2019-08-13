package com.softveri.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softveri.entity.Templejt;
import com.softveri.repository.TemplejtRepository;
@Service
public class TemplejtServiceImpl implements TemplejtService{

	TemplejtRepository repository;
	
	public TemplejtServiceImpl() {
		
	}
	@Autowired
	public TemplejtServiceImpl(TemplejtRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Templejt> getAllTemplejts() {
		List<Templejt> list = new ArrayList<Templejt>();
		repository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Templejt getTemplejtById(int id) {
		Templejt templejt = repository.findById(id).get();
		return templejt;
	}

	@Override
	public boolean saveTemplejt(Templejt templejt) {
		try {
			repository.save(templejt);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteTemplejtById(int id) {
		try {
			repository.deleteById(id);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

}
