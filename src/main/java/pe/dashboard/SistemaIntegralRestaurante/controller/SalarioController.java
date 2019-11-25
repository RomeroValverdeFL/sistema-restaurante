package pe.dashboard.SistemaIntegralRestaurante.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Estados;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Salarios;
import pe.dashboard.SistemaIntegralRestaurante.service.EstadoService;

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
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Salarios> optional = salarioService.findById(id);
			if (optional.isPresent()) {
				
				List<Estados> estados 
					= estadoService.findAll(); 
				
				model.addAttribute("salario", optional.get());
				model.addAttribute("estados", estados);
			} else {
				return "redirect:/salario";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/dashboard/salario/edit";
	}	
	@PostMapping("/save")
	public String save(@ModelAttribute("salario") Salarios salarios, 
			Model model, SessionStatus status) {
		try {
			salarioService.save(salarios);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/salario";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Salarios salario = new Salarios();
		model.addAttribute("salario", salario);
		try {
			List<Estados> estados = 
					estadoService.findAll();
			model.addAttribute("estados", estados);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/dashboard/salario/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Salarios> salario = salarioService.findById(id);
			if(salario.isPresent()) {
				salarioService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Salarios> salarios = salarioService.findAll();
				model.addAttribute("salarios", salarios);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/salario";
		}
		return "redirect:/salario";
	} 
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Salarios> salario = salarioService.findById(id);
			if(salario.isPresent()) {
				model.addAttribute("salario", salario.get());
			} else {
				return "redirect:/salario";
			}
		} catch (Exception e) {

		}	
		
		return "/dashboard/salario/info";
	}
	
}
