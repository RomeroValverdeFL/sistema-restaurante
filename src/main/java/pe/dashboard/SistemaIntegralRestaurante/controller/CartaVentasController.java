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
@RequestMapping("/menuVentas")
@SessionAttributes( {"menu","estados"} )
public class CartaVentasController {
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
		return "/menu";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Menu> optional = menuService.findById(id);
			if (optional.isPresent()) {
				
				List<Estados> estados 
					= estadoService.findAll(); 
				
				model.addAttribute("menu", optional.get());
				model.addAttribute("estados", estados);
			} else {
				return "redirect:/menu";
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
		return "redirect:/menu";
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
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Menu> menu = menuService.findById(id);
			if(menu.isPresent()) {
				menuService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Menu> menus = menuService.findAll();
				model.addAttribute("menus", menus);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/menu";
		}
		return "redirect:/menu";
	}
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Menu> menu = menuService.findById(id);
			if(menu.isPresent()) {
				model.addAttribute("menu", menu.get());
			} else {
				return "redirect:/menu";
			}
		} catch (Exception e) {

		}	
		
		return "/dashboard/carta/info";
	}
}
