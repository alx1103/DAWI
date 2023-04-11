package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name="tb_productos")
public class Producto {

	@Id
	private String id_prod;
	private String des_prod;
	private int stk_prod;
	private double pre_prod;
	private int idcategoria;
	private int est_prod;
	private int idproveedor;
	
	
	@ManyToOne
	@JoinColumn (name="idproveedor", insertable = false, updatable = false)
	Proveedor objProveedor;
	
	@ManyToOne
	@JoinColumn (name="idcategoria", insertable = false, updatable = false)
	Categoria objCategoria;
	
}
