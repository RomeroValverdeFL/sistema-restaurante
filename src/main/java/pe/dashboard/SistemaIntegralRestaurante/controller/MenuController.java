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
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Menu;
import pe.dashboard.SistemaIntegralRestaurante.service.EstadoService;
import pe.dashboard.SistemaIntegralRestaurante.service.MenuService;


@Controller
@RequestMapping("/menu")
@SessionAttributes( {"menu"} )
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Menu> menus = menuService.findAll();
			model.addAttribute("menus", menus);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/dashboard/carta/inicio";
	}
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Menu> optional = menuService.findById(id);
			if (optional.isPresent()) {
				
				List<Estados> estados 
					= estadoService.findAll(); 
				
				model.addAttribute("menus", optional.get());
				model.addAttribute("estados", estados);
			} else {
				return "redirect:/dashboard/carta/inicio";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/dashboard/carta/edit";
	}	
	@PostMapping("/save")
	public String save(@ModelAttribute("menu") Menu menu, 
			Model model, SessionStatus status) {
		try {
			menuService.save(menu);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/dashboard/carta/inicio";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Menu menu = new Menu();
		model.addAttribute("menu", menu);
		try {
			List<Estados> estados = 
					estadoService.findAll();
			model.addAttribute("estados", estados);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/dashboard/carta/nuevo";
	}
}
