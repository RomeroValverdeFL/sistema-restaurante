package pe.dashboard.SistemaIntegralRestaurante.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pe.dashboard.SistemaIntegralRestaurante.model.entity.Cargos;

@Entity
@Table(name = "COLABORADORES")
public class Colaboradores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_SOLABORADOR")
	private Integer codigoColaborador;
	
	@Column(name = "NOM_COLABORADOR", length = 42, nullable = false )
	private String nombreColaborador;
	
	@Column(name = "APE_PAT_COLABORADOR", length = 42, nullable = false )
	private String apellidoPaternoColaborador;
	
	@Column(name = "APE_MAT_COLABORADOR", length = 42, nullable = false )
	private String apellidoMaternoColaborador;
	
	@Column(name = "NUM_DOCUMENTO_IDENTIDAD", length = 20, nullable = false )
	private String numeroDocumentoIdentidad;
	
	@Column(name = "GENERO", length = 20, nullable = false )
	private String genero;
	
	@OneToMany(mappedBy = "colaboradores", fetch = FetchType.LAZY)
	private List<Cargos> cargos;

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

	public Integer getCodigoColaborador() {
		return codigoColaborador;
	}

	public void setCodigoColaborador(Integer codigoColaborador) {
		this.codigoColaborador = codigoColaborador;
	}

	public String getNombreColaborador() {
		return nombreColaborador;
	}

	public void setNombreColaborador(String nombreColaborador) {
		this.nombreColaborador = nombreColaborador;
	}

	public String getApellidoPaternoColaborador() {
		return apellidoPaternoColaborador;
	}

	public void setApellidoPaternoColaborador(String apellidoPaternoColaborador) {
		this.apellidoPaternoColaborador = apellidoPaternoColaborador;
	}

	public String getApellidoMaternoColaborador() {
		return apellidoMaternoColaborador;
	}

	public void setApellidoMaternoColaborador(String apellidoMaternoColaborador) {
		this.apellidoMaternoColaborador = apellidoMaternoColaborador;
	}

	public String getNumeroDocumentoIdentidad() {
		return numeroDocumentoIdentidad;
	}

	public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
		this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Cargos> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargos> cargos) {
		this.cargos = cargos;
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
