package pe.dashboard.SistemaIntegralRestaurante.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Contactame;
import pe.dashboard.SistemaIntegralRestaurante.model.repository.ContactoRepository;
import pe.dashboard.SistemaIntegralRestaurante.model.repository.MenuRepository;
import pe.dashboard.SistemaIntegralRestaurante.service.ContactoService;

@Service
public class ContactoServiceImpl implements ContactoService{
	@Autowired
	private ContactoRepository contactoRepository; 
	
	@Transactional(readOnly = true)
	@Override
	public List<Contactame> findAll() throws Exception {
		// TODO Auto-generated method stub
		return contactoRepository.findAll();
	}

	@Override
	public Optional<Contactame> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return contactoRepository.findById(id);
	}

	@Override
	public Contactame save(Contactame entity) throws Exception {
		// TODO Auto-generated method stub
		return contactoRepository.save(entity);
	}

	@Override
	public Contactame update(Contactame entity) throws Exception {
		// TODO Auto-generated method stub
		return contactoRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		contactoRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		contactoRepository.deleteAll();
	}

}
