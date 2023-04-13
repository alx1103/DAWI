package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_usuarios")
/*para que agrege los getters y tambien desargo el jar de lombok, instalarlo
 * para que reconozca getter y setter*/
/*dile a winrar que no reconozca el jar como comprimido*/
/*@Getter
@Setter*/

/*si quieres poner todo*/
@Data
public class Usuario{
	// atributos --> nombre de las columnas
	@Id
	private int cod_usua;
	private String nom_usua;
	private String ape_usua;
	@Column(name = "usr_usua")
	private String correo;
	@Column(name = "cla_usua")
	private String clave;
	private String fna_usua;
	private int idtipo;
	private int est_usua;
	
	/*cuando pones outline sale todo los get and set tostring*/
	
	/*para la llave foranea*/
	/*para una relacion de muchos a uno*/
	@ManyToOne
	/*para decirle que este campo es para mostrar*/
	@JoinColumn(name="idtipo", insertable = false, updatable = false)
	private Tipo objTipo;
}
