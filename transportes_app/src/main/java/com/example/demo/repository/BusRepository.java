package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer>{
	
	@Query(value = "select * from tb_bus b "
			+ "inner join tb_fabricante f on b.id_fabricante = f.id_fabricante "
			+ "where b.placa like %:filtro% or f.nombre like %:filtro%", nativeQuery = true)
	List<Bus> buscarPorPlaca(String filtro);
}
