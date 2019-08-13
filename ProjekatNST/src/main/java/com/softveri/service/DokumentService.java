package com.softveri.service;

import java.util.List;

import com.softveri.entity.Dokument;

public interface DokumentService {

	public List<Dokument> getAllDocuments();
	public Dokument getDokumentById(int id);
	public boolean saveDokument(Dokument dokument);
	public boolean deleteDokumentById(int id);
}
