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
@Table(name="TIPO_USUARIOS")
public class TipoUsuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_TIPO_USUARIOS")
	private Integer codigoTipoUsuarios;
	
	@Column(name = "NOM_TIPO_USUARIO", length = 40, nullable = false )
	private String nombreTipoUsuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_MODULO")
	private Modulos modulos;

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

	public Integer getCodigoTipoUsuarios() {
		return codigoTipoUsuarios;
	}

	public void setCodigoTipoUsuarios(Integer codigoTipoUsuarios) {
		this.codigoTipoUsuarios = codigoTipoUsuarios;
	}

	public String getNombreTipoUsuario() {
		return nombreTipoUsuario;
	}

	public void setNombreTipoUsuario(String nombreTipoUsuario) {
		this.nombreTipoUsuario = nombreTipoUsuario;
	}

	public Modulos getModulos() {
		return modulos;
	}

	public void setModulos(Modulos modulos) {
		this.modulos = modulos;
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
