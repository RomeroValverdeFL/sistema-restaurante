package pe.dashboard.SistemaIntegralRestaurante.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Salarios;
import pe.dashboard.SistemaIntegralRestaurante.model.repository.MenuRepository;
import pe.dashboard.SistemaIntegralRestaurante.model.repository.SalarioRepository;
import pe.dashboard.SistemaIntegralRestaurante.service.SalarioService;

@Service
public class SalarioServiceImpl implements SalarioService {
	
	@Autowired
	private SalarioRepository salarioRepository; 
	
	@Transactional(readOnly = true)
	@Override
	public List<Salarios> findAll() throws Exception {
		// TODO Auto-generated method stub
		return salarioRepository.findAll();
	}

	@Override
	public Optional<Salarios> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return salarioRepository.findById(id);
	}
	@Transactional
	@Override
	public Salarios save(Salarios entity) throws Exception {
		// TODO Auto-generated method stub
		return salarioRepository.save(entity);
	}
	@Transactional
	@Override
	public Salarios update(Salarios entity) throws Exception {
		// TODO Auto-generated method stub
		return salarioRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		salarioRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		salarioRepository.deleteAll();
	}

}
