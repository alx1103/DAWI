package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo05 {

	/*este codigo utiliza una sintaxis con jpql*/
	
	public static void main(String[] args) {
		
		/*fabricar acceso de datos*/
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ejercicios");
		
		/*crear el manejador de entidades*/
		EntityManager em = fabrica.createEntityManager();
		
		/*ejecuta una sintaxis basada en jpql*/
		/*Select a (significa todos los campos de la entidad)
		 * from Usuario a que se van a seleccionar los datos de la tabla*/
		List<Usuario> lstUsuario = em.createQuery("Select a from Usuario a", Usuario.class).getResultList();
		System.out.println("Nro de usuarios: " + lstUsuario.size());
		
		/*en cada vuelta obtendrá un objeto*/
		for(Usuario u: lstUsuario) {
			System.out.println("Siguiente empleado: " + u.getApe_usua());
		}
		
		
	}
}
