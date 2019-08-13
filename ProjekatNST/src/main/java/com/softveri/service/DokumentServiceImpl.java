package com.softveri.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softveri.entity.Dokument;
import com.softveri.repository.DokumentRepository;

@Service
public class DokumentServiceImpl implements DokumentService{

	private DokumentRepository repository;
	
	
	public DokumentServiceImpl() {
		
	}	
	@Autowired
	public DokumentServiceImpl(DokumentRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public List<Dokument> getAllDocuments() {
		List<Dokument> list = new ArrayList<Dokument>();
		repository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Dokument getDokumentById(int id) {
		Dokument dokument = repository.findById(id).get();
		return dokument;
	}

	@Override
	public boolean saveDokument(Dokument dokument) {
		try {
			repository.save(dokument);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteDokumentById(int id) {
		try {
			repository.deleteById(id);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

}
