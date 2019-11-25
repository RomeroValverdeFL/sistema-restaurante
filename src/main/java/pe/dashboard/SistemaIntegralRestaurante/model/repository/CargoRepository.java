package pe.dashboard.SistemaIntegralRestaurante.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Cargos;


@Repository
public interface CargoRepository extends JpaRepository<Cargos, Integer>{

}
