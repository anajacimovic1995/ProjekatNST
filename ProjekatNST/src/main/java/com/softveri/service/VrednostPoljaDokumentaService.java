package com.softveri.service;

import java.util.List;

import com.softveri.entity.VrednostPoljaDokumenta;

public interface VrednostPoljaDokumentaService {

	public List<VrednostPoljaDokumenta> getAllVrednosti();
	public VrednostPoljaDokumenta getVrednostById(int id);
	public boolean saveVrednost(VrednostPoljaDokumenta vrednost);
	public boolean deleteVrednostById(int id);
}
