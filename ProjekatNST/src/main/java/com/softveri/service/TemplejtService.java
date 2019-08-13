package com.softveri.service;

import java.util.List;

import com.softveri.entity.Templejt;

public interface TemplejtService {

	public List<Templejt> getAllTemplejts();
	public Templejt getTemplejtById(int id);
	public boolean saveTemplejt(Templejt templejt);
	public boolean deleteTemplejtById(int id);
}
