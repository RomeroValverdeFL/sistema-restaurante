package pe.dashboard.SistemaIntegralRestaurante.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/dashboard")
public class DashboardController {

	@GetMapping
	public String inicio(Model model) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/dashboard";
	}
	
	@GetMapping("login")
	public String login() {
		return "/login";
	}
}
