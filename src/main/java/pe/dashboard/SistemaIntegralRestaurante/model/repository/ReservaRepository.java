package pe.dashboard.SistemaIntegralRestaurante.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Menu;
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Reserva;
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

}
