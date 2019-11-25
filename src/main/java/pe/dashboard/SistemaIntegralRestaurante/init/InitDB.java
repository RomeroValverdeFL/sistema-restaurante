package pe.dashboard.SistemaIntegralRestaurante.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Usuario;
import pe.dashboard.SistemaIntegralRestaurante.model.repository.AuthorityRepository;
import pe.dashboard.SistemaIntegralRestaurante.model.repository.UsuarioRepository;

@Service
public class InitDB implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		
		this.usuarioRepository.deleteAll();
		this.authorityRepository.deleteAll();
		
		Usuario luiz = new Usuario();
		luiz.setUsername("luiz");
		luiz.setPassword(passwordEncoder.encode("luiz"));
		luiz.setApellidos("Romero");
		luiz.setNombres("luiz");
		luiz.setCargo("MESERO");
		luiz.setEnable(true);
		
		Usuario admin = new Usuario();
		admin.setUsername("admin");
		admin.setPassword(passwordEncoder.encode("admin"));
		admin.setApellidos("Romero");
		admin.setNombres("Noe");
		admin.setCargo("cargo");
		admin.setEnable(true);
		
        Usuario gabriel = new Usuario();
        gabriel.setUsername("gabriel");
        gabriel.setPassword(passwordEncoder.encode("gabriel"));
        gabriel.setApellidos("Quispe");
        gabriel.setNombres("Gabriel");
        gabriel.setCargo("COCINERO");
        gabriel.setEnable(true);
        
        luiz.addAuthority("ROLE_USER");
        luiz.addAuthority("ACCESS_SUPERVISOR_READ");
        admin.addAuthority("ROLE_ADMIN");
        admin.addAuthority("ACCESS_EMPLEADO");
        admin.addAuthority("ACCESS_MESERO1");
        gabriel.addAuthority("ROLE_MANAGER");
        gabriel.addAuthority("ACCESS_MESERO2");
        
        List<Usuario> usuarios = Arrays.asList(luiz, admin, gabriel);        
        this.usuarioRepository.saveAll(usuarios);
	}
}
