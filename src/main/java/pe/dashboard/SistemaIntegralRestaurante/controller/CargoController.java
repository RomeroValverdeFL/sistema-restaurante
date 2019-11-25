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

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Cargos;
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Estados;
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Salarios;
import pe.dashboard.SistemaIntegralRestaurante.service.CargoService;
import pe.dashboard.SistemaIntegralRestaurante.service.EstadoService;
import pe.dashboard.SistemaIntegralRestaurante.service.SalarioService;


@Controller
@RequestMapping("/cargo")
@SessionAttributes( {"cargo","estados"} )
public class CargoController {
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private EstadoService estadoService;
	@Autowired
	private SalarioService salarioService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Cargos> cargos = cargoService.findAll();
			model.addAttribute("cargos", cargos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/dashboard/cargo/inicio";
	}
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cargos> optional = cargoService.findById(id);
			if (optional.isPresent()) {
				
				List<Estados> estados 
					= estadoService.findAll(); 
				List<Salarios> salarios = 
						salarioService.findAll();
				model.addAttribute("cargo", optional.get());
				model.addAttribute("estados", estados);
				model.addAttribute("salarios", salarios);
			} else {
				return "redirect:/cargo";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/dashboard/cargo/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("cargo") Cargos cargo, 
			Model model, SessionStatus status) {
		try {
			cargoService.save(cargo);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/cargo";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Cargos cargo = new Cargos();
		model.addAttribute("cargo", cargo);
		try {
			List<Estados> estados = 
					estadoService.findAll();
			List<Salarios> salarios = 
					salarioService.findAll();
			model.addAttribute("estados", estados);
			model.addAttribute("salarios", salarios);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/dashboard/cargo/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cargos> cargo = cargoService.findById(id);
			if(cargo.isPresent()) {
				cargoService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Cargos> cargos = cargoService.findAll();
				model.addAttribute("cargos", cargos);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/cargo";
		}
		return "redirect:/cargo";
	}

}
