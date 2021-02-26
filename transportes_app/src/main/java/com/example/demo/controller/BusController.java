package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Bus;
import com.example.demo.model.Fabricante;
import com.example.demo.service.IBusService;
import com.example.demo.service.IFabricanteService;


@Controller
public class BusController {
	
	@Autowired
	private IBusService iBusService;
	
	@Autowired
	private IFabricanteService iFabricanteService;
	
	@GetMapping("/lista")
	public String listarBuses(Model model, String filtro) {
//		List<Bus> listadoBuses = iBusService.listarBuses();
//		List<Bus> listadoFiltro = iBusService.buscarPorPlaca(placa);
//		if(placa != null) {
//			model.addAttribute("buses", listadoFiltro);
//		}else {
//			model.addAttribute("buses", listadoBuses);
//		}
		model.addAttribute("titulo","Lista de Buses");
//		model.addAttribute("buses", listadoBuses);
		verPagina(1,"fabricante","asc",model, filtro);
		return "lista";
	}
	
	@GetMapping("/agregar")
	public String agregarBus(Model model) {
		Bus bus = new Bus();
		List<Fabricante> listaFabricantes = iFabricanteService.listaFabricantes();
		model.addAttribute("titulo","Agregar Nuevo Bus");
		model.addAttribute("bus", bus);
		model.addAttribute("fabricantes", listaFabricantes);

		return "agregar";
	}
	
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Bus bus) {
		
		iBusService.guardar(bus);
		return "redirect:lista";
	}
	
	@GetMapping("/editar/{id_bus}")
	public String editarBus(@PathVariable("id_bus") Integer idBus, Model model) {
		
		Bus bus = iBusService.buscarBus(idBus);
		List<Fabricante> listaFabricantes = iFabricanteService.listaFabricantes();
		model.addAttribute("titulo","Editar Bus");
		model.addAttribute("bus", bus);
		model.addAttribute("fabricantes", listaFabricantes);

		return "agregar";
	}
	
	@GetMapping("/eliminar/{id_bus}")
	public String eliminarBus(@PathVariable("id_bus") Integer idBus) {
		
		iBusService.eliminar(idBus);

		return "redirect:/lista";
	}
	
	@GetMapping("/pagina/{pageNumber}")
	public String verPagina(@PathVariable(value = "pageNumber") int pageNumber, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model, String filtro) {
		
		int pageSize = 5;
		List<Bus> listadoFiltro = iBusService.buscarPorPlaca(filtro);
		Page<Bus> page = iBusService.paginacion(pageNumber, pageSize, sortField, sortDir);
		List<Bus> listaBuses = page.getContent();
		
		model.addAttribute("titulo","Lista de Buses");
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");		
		if(filtro != null) {
			model.addAttribute("buses", listadoFiltro);
		}else {
			model.addAttribute("buses", listaBuses);
		}
		
		return "lista";
	}
	
	@GetMapping("/regresar")
	public String regresar() {
		
		return "redirect:/lista";
	}
}
