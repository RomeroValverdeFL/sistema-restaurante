package pe.dashboard.SistemaIntegralRestaurante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.dashboard.SistemaIntegralRestaurante.service.ContactoService;

@Controller
@RequestMapping("/reserva")
@SessionAttributes({ "reserva", "estados" })
public class ReservaController {
	@Autowired
	private ReservaController reservaController;
}
