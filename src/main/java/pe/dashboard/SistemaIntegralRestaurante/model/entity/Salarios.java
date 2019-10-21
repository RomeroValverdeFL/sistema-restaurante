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
@Table(name="SALARIOS")
public class Salarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_SALARIO")
	private Integer codigoSalario;
	
	@Column(name = "MONTO_SALARIO", nullable = false )
	private Double montoSalario;

	@Column(name = "FEC_CREACION", length = 15, nullable = false )
	private String fechaCreacion;
	
	@Column(name = "USU_CREACION", length = 15, nullable = false )
	private String usuarioCreacion;
	
	@Column(name = "FEC_MODIFICACION", length = 15, nullable = false )
	private String fechaModificacion;
	
	@Column(name = "USU_MODIFICACION", length = 15, nullable = false )
	private String usuarioModificacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ESTADO")
	private Estados estados;

	public Integer getCodigoSalario() {
		return codigoSalario;
	}

	public void setCodigoSalario(Integer codigoSalario) {
		this.codigoSalario = codigoSalario;
	}

	public Double getMontoSalario() {
		return montoSalario;
	}

	public void setMontoSalario(Double montoSalario) {
		this.montoSalario = montoSalario;
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
