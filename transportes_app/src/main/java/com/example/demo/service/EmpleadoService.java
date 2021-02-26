package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Empleado;
import com.example.demo.repository.EmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public Empleado verificar(String correo, String password) {

		
		Empleado empleado = empleadoRepository.findByCorreoAndPassword(correo, password);
		if (empleado != null) {
			return empleado;
		}
		return null;

	}

}
