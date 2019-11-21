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
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Mesas;
import pe.dashboard.SistemaIntegralRestaurante.service.EstadoService;
import pe.dashboard.SistemaIntegralRestaurante.service.MesaService;

@Controller
@RequestMapping("/mesa")
@SessionAttributes( {"mesa","estados"} )
public class MesaController {

	@Autowired
	private MesaService mesaService;
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Mesas> mesas = mesaService.findAll();
			model.addAttribute("mesas", mesas);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/dashboard/mesa/inicio";
	}
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Mesas> optional = mesaService.findById(id);
			if (optional.isPresent()) {
				
				List<Estados> estados 
					= estadoService.findAll(); 
				
				model.addAttribute("mesa", optional.get());
				model.addAttribute("estados", estados);
			} else {
				return "redirect:/mesa";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/dashboard/mesa/edit";
	}	
	@PostMapping("/save")
	public String save(@ModelAttribute("mesa") Mesas mesa, 
			Model model, SessionStatus status) {
		try {
			mesaService.save(mesa);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/mesa";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Mesas mesa = new Mesas();
		model.addAttribute("mesa", mesa);
		try {
			List<Estados> estados = 
					estadoService.findAll();
			model.addAttribute("estados", estados);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/dashboard/mesa/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Mesas> mesa = mesaService.findById(id);
			if(mesa.isPresent()) {
				mesaService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Mesas> mesas = mesaService.findAll();
				model.addAttribute("mesas", mesas);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/mesa";
		}
		return "redirect:/mesa";
	}
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Mesas> mesa = mesaService.findById(id);
			if(mesa.isPresent()) {
				model.addAttribute("mesa", mesa.get());
			} else {
				return "redirect:/mesa";
			}
		} catch (Exception e) {

		}	
		
		return "/dashboard/mesa/info";
	}
}
