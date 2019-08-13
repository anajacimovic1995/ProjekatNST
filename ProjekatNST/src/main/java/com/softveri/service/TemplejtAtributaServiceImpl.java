package com.softveri.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softveri.entity.TemplejtAtributa;
import com.softveri.repository.TemplejtAtributaRepository;


@Service
public class TemplejtAtributaServiceImpl implements TemplejtAtributaService{

	
	private TemplejtAtributaRepository repository;
	
	public TemplejtAtributaServiceImpl() {
		
	}
	@Autowired
	public TemplejtAtributaServiceImpl(TemplejtAtributaRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	public List<TemplejtAtributa> getAllTemplejtAtributa() {		
		List<TemplejtAtributa> list = new ArrayList<TemplejtAtributa>();
		repository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public TemplejtAtributa getTemplejtAtributaById(int id) {
		TemplejtAtributa templejt = repository.findById(id).get();
		return templejt;
	}

	@Override
	public boolean saveTemplejtAtributa(TemplejtAtributa templejt) {
		try {
			repository.save(templejt);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteTemplejtAtributaById(int id) {
		try {
			repository.deleteById(id);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

}
