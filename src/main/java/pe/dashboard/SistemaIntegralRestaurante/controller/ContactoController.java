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

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Contactame;
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Estados;
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Menu;
import pe.dashboard.SistemaIntegralRestaurante.service.ContactoService;
import pe.dashboard.SistemaIntegralRestaurante.service.EstadoService;

@Controller
@RequestMapping("/contacto")
@SessionAttributes({ "contacto", "estados" })
public class ContactoController {
	@Autowired
	private ContactoService contactoService;

	@Autowired
	private EstadoService estadoService;

	@GetMapping
	public String inicio(Model model) {
		try {
			List<Contactame> contactos = contactoService.findAll();
			model.addAttribute("contactos", contactos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/dashboard/contacto/inicio";
	}
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Contactame> optional = contactoService.findById(id);
			if (optional.isPresent()) {
				
				List<Estados> estados 
					= estadoService.findAll(); 
				
				model.addAttribute("contacto", optional.get());
				model.addAttribute("estados", estados);
			} else {
				return "redirect:/contacto";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/dashboard/contacto/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("contacto") Contactame contacto, Model model, SessionStatus status) {
		try {
			contactoService.save(contacto);
			status.setComplete();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/contacto";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Contactame contacto = new Contactame();
		model.addAttribute("contacto", contacto);
		try {
			List<Estados> estados = 
					estadoService.findAll();
			model.addAttribute("estados", estados);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/dashboard/contacto/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Contactame> contacto = contactoService.findById(id);
			if(contacto.isPresent()) {
				contactoService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Contactame> contactos = contactoService.findAll();
				model.addAttribute("contactos", contactos);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/contacto";
		}
		return "redirect:/contacto";
	}
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Contactame> contacto = contactoService.findById(id);
			if(contacto.isPresent()) {
				model.addAttribute("contacto", contacto.get());
			} else {
				return "redirect:/contacto";
			}
		} catch (Exception e) {

		}	
		
		return "/dashboard/contacto/info";
	}

}
