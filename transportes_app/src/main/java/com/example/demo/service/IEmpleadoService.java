package com.example.demo.service;

import com.example.demo.model.Empleado;

public interface IEmpleadoService {

	Empleado verificar(String correo, String password);

}
