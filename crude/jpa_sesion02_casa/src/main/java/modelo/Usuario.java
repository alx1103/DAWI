package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*convierte la clase a entidad*/
/*y en una tabla para que asi se puedan insertar los valores*/
@Entity
@Table(name="tb_usuarios")

@NoArgsConstructor
@Data
@AllArgsConstructor

public class Usuario {
	/*la entidad necesita una llave primaria por eso me salía error*/
	@Id
	public int cod_usua;
	private String nom_usua;
	private String ape_usua;

	/*si quiero ponerle otro nombre al atributo, y la columna tiene otro nombre*/
	@Column (name ="usr_usua")
	private String usuario;
	private String cla_usua;
	private String fna_usua; 
	private int idtipo;
	private int est_usua;
	
	/*ese idtipo es de la clase Usuario*/
	@ManyToOne
	@JoinColumn(name="idtipo", insertable=false, updatable=false)
	private Tipo objTipo;
	
	
}
