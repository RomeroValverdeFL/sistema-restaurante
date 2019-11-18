package pe.dashboard.SistemaIntegralRestaurante.service;

import java.util.Optional;



import pe.dashboard.SistemaIntegralRestaurante.model.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario, Long> {
	Optional<Usuario> findByUsername(String username) throws Exception;
}
