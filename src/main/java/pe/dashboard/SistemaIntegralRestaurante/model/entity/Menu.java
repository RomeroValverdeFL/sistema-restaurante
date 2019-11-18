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
@Table(name="MENU")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_MENU")
	private Integer codigoMenu;
	
	@Column(name = "NOM_MENU", length = 80, nullable = false )
	private String nombrePlatoMenu;
	
	@Column(name = "PRECIO", length = 80, nullable = false )
	private Integer precio;
	
	@Column(name = "DESCCRIPCION", length = 250, nullable = false )
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COD_ESTADO")
	private Estados estados;

	public Integer getCodigoMenu() {
		return codigoMenu;
	}

	public void setCodigoMenu(Integer codigoMenu) {
		this.codigoMenu = codigoMenu;
	}

	public String getNombrePlatoMenu() {
		return nombrePlatoMenu;
	}

	public void setNombrePlatoMenu(String nombrePlatoMenu) {
		this.nombrePlatoMenu = nombrePlatoMenu;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estados getEstados() {
		return estados;
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
	}
	
}
