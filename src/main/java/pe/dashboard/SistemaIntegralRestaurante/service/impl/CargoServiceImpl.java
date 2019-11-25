package pe.dashboard.SistemaIntegralRestaurante.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Cargos;
import pe.dashboard.SistemaIntegralRestaurante.model.repository.CargoRepository;

import pe.dashboard.SistemaIntegralRestaurante.service.CargoService;
@Service
public class CargoServiceImpl implements CargoService{
	@Autowired
	private CargoRepository cargoRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Cargos> findAll() throws Exception {
		// TODO Auto-generated method stub
		return cargoRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Cargos> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return cargoRepository.findById(id);
	}
	@Transactional
	@Override
	public Cargos save(Cargos entity) throws Exception {
		// TODO Auto-generated method stub
		return cargoRepository.save(entity);
	}
	@Transactional
	@Override
	public Cargos update(Cargos entity) throws Exception {
		// TODO Auto-generated method stub
		return cargoRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		cargoRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		cargoRepository.deleteAll();
	} 
	
}
