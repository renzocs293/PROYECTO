package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bus;
import com.example.demo.repository.BusRepository;

@Service
public class BusService implements IBusService {
	
	@Autowired
	private BusRepository busRepository;

	@Override
	public List<Bus> listarBuses() {
		return busRepository.findAll();
	}

	@Override
	public void guardar(Bus b) {
		busRepository.save(b);
	}

	@Override
	public Bus buscarBus(Integer id) {
		return busRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		busRepository.deleteById(id);
	}

	@Override
	public Page<Bus> paginacion(int pageNumber, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		Pageable pagina = PageRequest.of(pageNumber -1, pageSize, sort);
		return busRepository.findAll(pagina);
	}

	@Override
	public List<Bus> buscarPorPlaca(String filtro) {
		return busRepository.buscarPorPlaca(filtro);
	}

}
