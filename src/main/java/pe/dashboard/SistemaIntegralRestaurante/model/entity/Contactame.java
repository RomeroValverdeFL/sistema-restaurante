package pe.dashboard.SistemaIntegralRestaurante.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="contactame")
public class Contactame {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_CONTACTO")
	private Integer codigoContacto;
	
	
	@Column(name = "NOM_ASUNTO", length = 100, nullable = false )
	private String nombreAsunto;
	
	@Column(name = "NOM_CONTACTO", length = 100, nullable = false )
	private String nombreContacto;
	
	@Column(name = "EMAIL", length = 100, nullable = true )
	private String email;
	
	@Column(name = "MENSAJE", length = 250, nullable = true )
	private String mensaje;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ESTADO")
	private Estados estados;

	public Integer getCodigoContacto() {
		return codigoContacto;
	}

	public void setCodigoContacto(Integer codigoContacto) {
		this.codigoContacto = codigoContacto;
	}

	public String getNombreAsunto() {
		return nombreAsunto;
	}

	public void setNombreAsunto(String nombreAsunto) {
		this.nombreAsunto = nombreAsunto;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Estados getEstados() {
		return estados;
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
	}
	
	
	
}
