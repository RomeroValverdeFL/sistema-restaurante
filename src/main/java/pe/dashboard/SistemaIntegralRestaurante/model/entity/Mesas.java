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
@Table(name="MESAS")
public class Mesas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_MESAS")
	private Integer codigoMesa;
	
	@Column(name = "NOM_MESA", length = 30, nullable = false )
	private String nombreMesa;
	
	@Column(name = "CAPACIDAD", nullable = false )
	private Integer capacidad;
	
	@Column(name = "USU_CREACION", length = 15, nullable = true )
	private String usuarioCreacion;
	
	@Column(name = "FEC_MODIFICACION", length = 15, nullable = true )
	private String fechaModificacion;
	
	@Column(name = "USU_MODIFICACION", length = 15, nullable = true )
	private String usuarioModificacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ESTADO")
	private Estados estados;

	public Integer getCodigoMesa() {
		return codigoMesa;
	}

	public void setCodigoMesa(Integer codigoMesa) {
		this.codigoMesa = codigoMesa;
	}

	public String getNombreMesa() {
		return nombreMesa;
	}

	public void setNombreMesa(String nombreMesa) {
		this.nombreMesa = nombreMesa;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Estados getEstados() {
		return estados;
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
	}
	
	
}
