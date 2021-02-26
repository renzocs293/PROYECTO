package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Empleado;
import com.example.demo.service.IEmpleadoService;

@Controller
public class EmpleadoController {

	@Autowired
	private IEmpleadoService iEmpleadoService;

	@PostMapping("/validate")
	public String verificarForm(String correo, String password, RedirectAttributes attribute) {

		Empleado empl;

		empl = iEmpleadoService.verificar(correo, password);

		if (empl == null) {
			attribute.addFlashAttribute("warning", "Datos incorrectos");
			return "redirect:/";
		}
		return "redirect:/lista";
	}

	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}

}





/*
 * @PostMapping("/validate") public String verificarForm(Empleado empleado) {
 * 
	 * Empleado empl;
	 * 
	 * empl = iEmpleadoService.verificar(empleado.getCorreo(),
	 * empleado.getPassword());
	 * 
	 * if (empl == null) { return "login"; }
	 * 
	 * return "redirect:/menu"; 
 * 
 * }
 */

/*
 * @GetMapping("/validate") public String verificarForm(String correo, String
 * password) {
 * 
	 * Empleado empl;
	 * 
	 * empl = iEmpleadoService.verificar(correo, password);
	 * 
	 * if (empl == null) { return "login"; }
	 * 
	 * return "redirect:/menu"; 
 * 
 * }
 */
