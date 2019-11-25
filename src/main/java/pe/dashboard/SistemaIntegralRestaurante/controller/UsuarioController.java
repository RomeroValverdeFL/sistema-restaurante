package pe.dashboard.SistemaIntegralRestaurante.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Cargos;
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Salarios;
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Usuario;
import pe.dashboard.SistemaIntegralRestaurante.service.CargoService;
import pe.dashboard.SistemaIntegralRestaurante.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
@SessionAttributes({"usuario","cargos"})
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private CargoService cargoService;
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@GetMapping("/register")
	public String register(Model model) {
		Usuario usuario = new Usuario();
		try {
			List<Cargos> cargos = cargoService.findAll();
			model.addAttribute("cargos", cargos);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		model.addAttribute("usuario", usuario);
		return "/dashboard/usuario/register";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("usuario") Usuario usuario, 
			Model model, SessionStatus status) {
		
		try {
			// Verificar que el username ya exista.
			Optional<Usuario> optional 
				= usuarioService.findByUsername(usuario.getUsername());
			if(optional.isPresent()) {
				model.addAttribute("dangerRegister"
						, "ERROR - El username " 
							+ usuario.getUsername() 
							+ " ya existe ");
				return "/usuario/register";
			} else {
				usuario.setPassword(passwordEncoder
						.encode( usuario.getPassword() ));
				usuario.addAuthority("ROLE_CLIENTE");
				usuarioService.save(usuario);
				status.setComplete();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/login";
	}
}








