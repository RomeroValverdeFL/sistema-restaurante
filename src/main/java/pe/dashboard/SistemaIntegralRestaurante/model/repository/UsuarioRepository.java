package pe.dashboard.SistemaIntegralRestaurante.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByUsername(String username);
}
