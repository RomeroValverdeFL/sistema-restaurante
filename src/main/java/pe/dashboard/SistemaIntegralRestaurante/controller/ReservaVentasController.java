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
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Estados;
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Reserva;
import pe.dashboard.SistemaIntegralRestaurante.service.ContactoService;
import pe.dashboard.SistemaIntegralRestaurante.service.EstadoService;
import pe.dashboard.SistemaIntegralRestaurante.service.ReservaService;

@Controller
@RequestMapping("/reservaVentas")
@SessionAttributes( {"reservation","estados"} )
public class ReservaVentasController {
	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private EstadoService estadoService;
	@GetMapping
	public String inicio(Model model) {
		try {
			Reserva reservas = new Reserva();
			model.addAttribute("reservas", reservas);
			try {
				List<Estados> estados = 
						estadoService.findAll();
				model.addAttribute("estados", estados);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/reservation";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("reserva") Reserva reserva, 
			Model model, SessionStatus status) {
		try {
			reservaService.save(reserva);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/reservaVentas";
	}
}
