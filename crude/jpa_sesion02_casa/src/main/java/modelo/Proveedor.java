package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name="tb_proveedor")
public class Proveedor {
	
	@Id
	@Column (name="idproveedor")
	private int idprov;
	private String nombre_rs;
	private String telefono;
	private String email;

}
