package com.softveri.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.softveri.entity.Dokument;

@Repository
public interface DokumentRepository extends CrudRepository<Dokument, Integer>{

}
