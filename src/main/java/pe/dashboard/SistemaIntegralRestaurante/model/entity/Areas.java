package pe.dashboard.SistemaIntegralRestaurante.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Colaboradores;

@Entity
@Table(name="AREAS")
public class Areas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_AREA")
	private Integer codigoArea;
	
	@Column(name = "NOM_AREA", length = 30, nullable = false )
	private String nombreArea;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_SEDE")
	private Sedes sedes;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_COLABORADOR")
	private Colaboradores colaboradores;
	
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

	public Integer getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(Integer codigoArea) {
		this.codigoArea = codigoArea;
	}

	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public Sedes getSedes() {
		return sedes;
	}

	public void setSedes(Sedes sedes) {
		this.sedes = sedes;
	}

	public Colaboradores getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(Colaboradores colaboradores) {
		this.colaboradores = colaboradores;
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
