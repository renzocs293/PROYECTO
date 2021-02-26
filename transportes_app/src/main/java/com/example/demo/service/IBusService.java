package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.Bus;

public interface IBusService {

	public List<Bus> listarBuses();
	public void guardar(Bus b);
	public Bus buscarBus(Integer id);
	public void eliminar(Integer id);
	Page<Bus> paginacion(int pageNumber, int pageSize, String sortField, String sortDirection);
	public List<Bus> buscarPorPlaca(String filtro);
}
