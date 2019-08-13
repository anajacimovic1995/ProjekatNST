package com.softveri.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softveri.entity.VrednostPoljaDokumenta;

@Repository
public interface VrednostPoljaDokumentaRepository extends CrudRepository<VrednostPoljaDokumenta, Integer>{

}
