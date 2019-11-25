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
import pe.dashboard.SistemaIntegralRestaurante.model.entity.Estados;

@Entity
@Table(name="SEDES")
public class Sedes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_SEDE")
	private Integer codigoSede;
	
	@Column(name = "NOM_SEDE", length = 30, nullable = false )
	private String nombreSede;
	
	@Column(name = "DIR_SEDE", length = 60, nullable = false )
	private String direccionSede;
	
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

	public Integer getCodigoSede() {
		return codigoSede;
	}

	public void setCodigoSede(Integer codigoSede) {
		this.codigoSede = codigoSede;
	}

	public String getNombreSede() {
		return nombreSede;
	}

	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}

	public String getDireccionSede() {
		return direccionSede;
	}

	public void setDireccionSede(String direccionSede) {
		this.direccionSede = direccionSede;
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
