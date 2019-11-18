package pe.dashboard.SistemaIntegralRestaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Menu;
import pe.dashboard.SistemaIntegralRestaurante.service.MenuService;


@Controller
@RequestMapping("/menu")
@SessionAttributes( {"menu"} )
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Menu> menus = menuService.findAll();
			model.addAttribute("menus", menus);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/menu";
	}
	
	
}
