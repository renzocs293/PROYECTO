package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Fabricante;
import com.example.demo.repository.FabricanteRepository;

@Service
public class FabricanteService implements IFabricanteService {

	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	@Override
	public List<Fabricante> listaFabricantes() {
		return (List<Fabricante>) fabricanteRepository.findAll();
	}

}
