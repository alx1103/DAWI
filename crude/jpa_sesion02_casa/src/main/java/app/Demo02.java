package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo02 {
	/*Permite actualizar los datos de un usuario existente en la tabla*/

	public static void main(String[] args) {
		
		/*primero hace un select, como no lo encuentra lo crea, me refiero a el caso en que 
		 * quiera actualizar un id que no exista lo creará*/
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("AP001");
		EntityManager em = fabrica.createEntityManager();
		
		Usuario u = new Usuario();
		u.setCod_usua(4);
		u.setNom_usua("Alexandra");
		u.setApe_usua("Sotelo");
		u.setCla_usua("dolly11");
		u.setEst_usua(1);
		u.setFna_usua("2003-10-02");
		u.setIdtipo(2);
		u.setUsuario("alx");
		
		/*empieza la transaccion*/
		em.getTransaction().begin();
		
		/*actualiza*/
		em.merge(u);
		
		/*termina la transacción*/
		em.getTransaction().commit();
		
		System.out.println("Se actualizó correctamente");
	}
	
}
