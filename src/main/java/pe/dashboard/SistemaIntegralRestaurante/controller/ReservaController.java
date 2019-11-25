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
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Reserva;

import pe.dashboard.SistemaIntegralRestaurante.service.EstadoService;
import pe.dashboard.SistemaIntegralRestaurante.service.ReservaService;

@Controller
@RequestMapping("/reserva")
@SessionAttributes({ "reserva", "estados" })
public class ReservaController {
	@Autowired
	private ReservaService reservaService;

	@Autowired
	private EstadoService estadoService;

	@GetMapping
	public String inicio(Model model) {
		try {
			List<Reserva> reservas = reservaService.findAll();
			model.addAttribute("reservas", reservas);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/dashboard/reserva/inicio";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Reserva> optional = reservaService.findById(id);
			if (optional.isPresent()) {

				List<Estados> estados = estadoService.findAll();

				model.addAttribute("reserva", optional.get());
				model.addAttribute("estados", estados);
			} else {
				return "redirect:/reserva";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "/dashboard/reserva/edit";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("reserva") Reserva reserva, Model model, SessionStatus status) {
		try {
			reservaService.save(reserva);
			status.setComplete();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/reserva";
	}


	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Reserva> reserva = reservaService.findById(id);
			if (reserva.isPresent()) {
				reservaService.deleteById(id);
			}
		} catch (Exception e) {

			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Reserva> reserva = reservaService.findAll();
				model.addAttribute("reserva", reserva);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			return "/reserva";
		}
		return "redirect:/reserva";
	}

}
