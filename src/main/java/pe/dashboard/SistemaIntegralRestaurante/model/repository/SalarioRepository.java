package pe.dashboard.SistemaIntegralRestaurante.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Menu;
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Salarios;

@Repository
public interface SalarioRepository extends JpaRepository<Salarios, Integer>{

}
