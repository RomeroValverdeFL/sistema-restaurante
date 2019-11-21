package pe.dashboard.SistemaIntegralRestaurante.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Mesas;

@Repository
public interface MesaRepository extends JpaRepository<Mesas, Integer> {

}
