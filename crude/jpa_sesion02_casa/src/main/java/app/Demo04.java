package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo04 {
	/*para eliminar un usuario*/
	public static void main(String[] args) {
		
		/*fabricar el acceso de datos*/
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("AP001");
		
		/*crear el manejador de entidades*/
		EntityManager em = fabrica.createEntityManager();
		
		Usuario u = em.find(Usuario.class,1);
		
		if(u!=null) {
			/*iniciar la transacción*/
			em.getTransaction().begin();
			
			/*para eliminar*/
			em.remove(u);
			
			/*finalizar la transacción*/
			em.getTransaction().commit();			
			
			System.out.println("Usuario " + u.getApe_usua() + " eliminado");
		}
		
		else {
			System.out.println("Usuario no encontrado");
		}

		
	}
}
