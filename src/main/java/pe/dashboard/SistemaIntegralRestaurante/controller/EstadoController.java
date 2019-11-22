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

import pe.dashboard.SistemaIntegralRestaurante.service.EstadoService;

@Controller
@RequestMapping("/estado")
@SessionAttributes( {"estado"} )
public class EstadoController {
	@Autowired 
	private EstadoService estadoService;
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Estados> estados = estadoService.findAll();
			model.addAttribute("estados", estados);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/dashboard/estado/inicio";
	}
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Estados> optional = estadoService.findById(id);
			if (optional.isPresent()) {			
				model.addAttribute("estado", optional.get());		
			} else {
				return "redirect:/estado";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/dashboard/estado/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("estado") Estados estados, 
			Model model, SessionStatus status) {
		try {
			estadoService.save(estados);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/estado";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Estados estado = new Estados();
		model.addAttribute("estado", estado);
		
		return "/dashboard/estado/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Estados> estado = estadoService.findById(id);
			if(estado.isPresent()) {
				estadoService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Estados> estados = estadoService.findAll();
				model.addAttribute("estados", estados);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/estado";
		}
		return "redirect:/estado";
	}
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Estados> estado = estadoService.findById(id);
			if(estado.isPresent()) {
				model.addAttribute("estado", estado.get());
			} else {
				return "redirect:/estado";
			}
		} catch (Exception e) {

		}	
		
		return "/dashboard/estado/info";
	}
}
