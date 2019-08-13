package com.softveri.service;

import java.util.List;

import com.softveri.entity.TemplejtAtributa;

public interface TemplejtAtributaService {
	public List<TemplejtAtributa> getAllTemplejtAtributa();
	public TemplejtAtributa getTemplejtAtributaById(int id);
	public boolean saveTemplejtAtributa(TemplejtAtributa templejt);
	public boolean deleteTemplejtAtributaById(int id);
}
