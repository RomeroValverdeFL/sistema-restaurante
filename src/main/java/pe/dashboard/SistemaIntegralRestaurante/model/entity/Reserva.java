package pe.dashboard.SistemaIntegralRestaurante.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_RESERVA")
	private Integer codigoReserva;
	
	
	@Column(name = "NOM_RESERVANTE", length = 100, nullable = false )
	private String nombreReservante;
	
	@Column(name = "TELEFONO", length = 100, nullable = false )
	private String telefono;
	
	@Column(name = "EMAIL", length = 100, nullable = true )
	private String email;
	
	@Column(name = "CANT_PERSONAS", length = 250, nullable = true )
	private Integer cantidadPersonas;
	

	@Column(name = "fec_reserva", length = 30, nullable = true )
	private String fechaReserva;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ESTADO")
	private Estados estados;

	
	public String getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Integer getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(Integer codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public String getNombreReservante() {
		return nombreReservante;
	}

	public void setNombreReservante(String nombreReservante) {
		this.nombreReservante = nombreReservante;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(Integer cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}


	public Estados getEstados() {
		return estados;
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
	}
	
	
}
