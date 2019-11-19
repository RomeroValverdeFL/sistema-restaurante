package pe.dashboard.SistemaIntegralRestaurante.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Estados;
import pe.dashboard.SistemaIntegralRestaurante.model.repository.EstadoRepository;
import pe.dashboard.SistemaIntegralRestaurante.service.EstadoService;
@Service
public class EstadoServiceImple implements EstadoService{
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Estados> findAll() throws Exception {
		// TODO Auto-generated method stub
		return estadoRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Estados> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return estadoRepository.findById(id);
	}
	@Transactional
	@Override
	public Estados save(Estados entity) throws Exception {
		// TODO Auto-generated method stub
		return estadoRepository.save(entity);
	}
	@Transactional
	@Override
	public Estados update(Estados entity) throws Exception {
		// TODO Auto-generated method stub
		return estadoRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		estadoRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		estadoRepository.deleteAll();
	}

}
