package com.mitocode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.repository.IPersonaRepo;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private IPersonaRepo repo;	
	
	@Override
	public void registrar(String nombre) {
		// TODO Auto-generated method stub

		repo.registrar(nombre);
	}
	
	

}
