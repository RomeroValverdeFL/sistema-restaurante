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

@Entity
@Table(name="USUARIOS")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_USUARIO")
	private Integer codigoUsuario;
	
	@Column(name = "CLAVE_USUARIO", length = 42, nullable = false )
	private String nombreColaborador;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_COLABORADOR")
	private Colaboradores colaboradores;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_TIPO_USUARIOS")
	private TipoUsuarios tipoUsuarios;
	
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

	public Integer getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Integer codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getNombreColaborador() {
		return nombreColaborador;
	}

	public void setNombreColaborador(String nombreColaborador) {
		this.nombreColaborador = nombreColaborador;
	}

	public Colaboradores getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(Colaboradores colaboradores) {
		this.colaboradores = colaboradores;
	}

	public TipoUsuarios getTipoUsuarios() {
		return tipoUsuarios;
	}

	public void setTipoUsuarios(TipoUsuarios tipoUsuarios) {
		this.tipoUsuarios = tipoUsuarios;
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
