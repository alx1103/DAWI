package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo03 {
	
	public static void main(String[] args) {
		/*fabricar el acceso de datos*/
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("AP001");
		
		/*crear el manejador de entidades*/
		EntityManager em = fabrica.createEntityManager();
		
		/*esto es una búsqueda, no una transación*/
		
		Usuario u = null;
		
		/*entidad.class, y el id del usuario a buscar*/
		u = em.find(Usuario.class, 1);
		
		if(u!=null) {
			System.out.println("Usuario encontrado " + u.getNom_usua() );
		}
		else {
			System.out.println("Usuario no encontrado");			
		}
		
	}
	
}
