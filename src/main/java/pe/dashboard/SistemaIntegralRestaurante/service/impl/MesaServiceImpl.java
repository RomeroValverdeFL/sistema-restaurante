package pe.dashboard.SistemaIntegralRestaurante.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Mesas;
import pe.dashboard.SistemaIntegralRestaurante.model.repository.MesaRepository;
import pe.dashboard.SistemaIntegralRestaurante.service.MesaService;

@Service
public class MesaServiceImpl implements MesaService{
	@Autowired 
	private MesaRepository mesaRepository;
	@Transactional(readOnly = true)
	@Override
	public List<Mesas> findAll() throws Exception {
		// TODO Auto-generated method stub
		return mesaRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Mesas> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return mesaRepository.findById(id);
	}
	@Transactional
	@Override
	public Mesas save(Mesas entity) throws Exception {
		// TODO Auto-generated method stub
		return mesaRepository.save(entity);
	}
	@Transactional
	@Override
	public Mesas update(Mesas entity) throws Exception {
		// TODO Auto-generated method stub
		return mesaRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		mesaRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
		mesaRepository.deleteAll();
		
	}
	

}
