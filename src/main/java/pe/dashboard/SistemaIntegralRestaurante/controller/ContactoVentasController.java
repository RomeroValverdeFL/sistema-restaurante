package pe.dashboard.SistemaIntegralRestaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Contactame;
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Menu;
import pe.dashboard.SistemaIntegralRestaurante.service.ContactoService;
import pe.dashboard.SistemaIntegralRestaurante.service.EstadoService;


@Controller
@RequestMapping("/contactoVentas")
@SessionAttributes( {"contacto","estados"} )
public class ContactoVentasController {
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
		return "/contact";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("contacto") Contactame contacto, 
			Model model, SessionStatus status) {
		try {
			contactoService.save(contacto);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/contact";
	}

}
