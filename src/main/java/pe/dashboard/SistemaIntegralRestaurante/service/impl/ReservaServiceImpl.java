package pe.dashboard.SistemaIntegralRestaurante.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Reserva;

import pe.dashboard.SistemaIntegralRestaurante.model.repository.ReservaRepository;
import pe.dashboard.SistemaIntegralRestaurante.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService{
	@Autowired
	private ReservaRepository reservaRepository;
	@Transactional(readOnly = true)
	@Override
	public List<Reserva> findAll() throws Exception {
		// TODO Auto-generated method stub
		return reservaRepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Reserva> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return reservaRepository.findById(id);
	}
	@Transactional
	@Override
	public Reserva save(Reserva entity) throws Exception {
		// TODO Auto-generated method stub
		return reservaRepository.save(entity);
	}
	@Transactional
	@Override
	public Reserva update(Reserva entity) throws Exception {
		// TODO Auto-generated method stub
		return reservaRepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		reservaRepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		reservaRepository.deleteAll();
	} 
}
