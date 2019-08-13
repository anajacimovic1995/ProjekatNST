package com.softveri.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softveri.entity.VrednostPoljaDokumenta;
import com.softveri.repository.VrednostPoljaDokumentaRepository;

@Service
public class VrednostPoljaDokumentaServiceImpl implements VrednostPoljaDokumentaService{

	VrednostPoljaDokumentaRepository repository;
	
	public VrednostPoljaDokumentaServiceImpl() {
		
	}	
	
	@Autowired
	public VrednostPoljaDokumentaServiceImpl(VrednostPoljaDokumentaRepository repository) {
		super();
		this.repository = repository;
	}



	@Override
	public List<VrednostPoljaDokumenta> getAllVrednosti() {
		List<VrednostPoljaDokumenta> list = new ArrayList<VrednostPoljaDokumenta>();
		repository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public VrednostPoljaDokumenta getVrednostById(int id) {
		VrednostPoljaDokumenta templejt = repository.findById(id).get();
		return templejt;
	}
	@Override
	public boolean saveVrednost(VrednostPoljaDokumenta vrednost) {
		try {
			repository.save(vrednost);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteVrednostById(int id) {
		try {
			repository.deleteById(id);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}


}
