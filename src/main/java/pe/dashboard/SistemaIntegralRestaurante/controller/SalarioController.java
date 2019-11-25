package pe.dashboard.SistemaIntegralRestaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Menu;
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Salarios;
import pe.dashboard.SistemaIntegralRestaurante.service.EstadoService;
import pe.dashboard.SistemaIntegralRestaurante.service.MenuService;
import pe.dashboard.SistemaIntegralRestaurante.service.SalarioService;

@Controller
@RequestMapping("/salario")
@SessionAttributes( {"salario","estados"} )
public class SalarioController {
	@Autowired
	private SalarioService salarioService;
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Salarios> salarios = salarioService.findAll();
			model.addAttribute("salarios", salarios);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/dashboard/salario/inicio";
	}
}
