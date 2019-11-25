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
@Table(name = "CARGOS")
public class Cargos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_CARGO")
	private Integer codigoCargo;
	
	@Column(name = "NOM_CARGO", length = 60, nullable = false )
	private String nombreCargo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_SALARIO")
	private Salarios salarios;

	@Column(name = "FEC_CREACION", length = 15, nullable = true )
	private String fechaCreacion;
	
	@Column(name = "USU_CREACION", length = 15, nullable = true )
	private String usuarioCreacion;
	
	@Column(name = "FEC_MODIFICACION", length = 15, nullable = true )
	private String fechaModificacion;
	
	@Column(name = "USU_MODIFICACION", length = 15, nullable = true )
	private String usuarioModificacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ESTADO")
	private Estados estados;

	public Integer getCodigoCargo() {
		return codigoCargo;
	}

	public void setCodigoCargo(Integer codigoCargo) {
		this.codigoCargo = codigoCargo;
	}

	public String getNombreCargo() {
		return nombreCargo;
	}

	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}

	public Salarios getSalarios() {
		return salarios;
	}

	public void setSalarios(Salarios salarios) {
		this.salarios = salarios;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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
