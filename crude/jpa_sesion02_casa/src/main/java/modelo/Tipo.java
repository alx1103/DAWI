package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name="tb_tipos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tipo {

	@Id
	private int idtipo;
	private String descripcion;
	
}
