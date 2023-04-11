package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo01 {

	/*permita utilizar el registro de un usuario utilizando valores fijos*/
	
	/*es el metodo que se va a ejecutar en el programa*/
	public static void main(String[] args) {
		/*fabricar el acceso de datos*/
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("AP001");
		/*crea el manejador de entidades*/
		EntityManager em = fabrica.createEntityManager();

		/*crear el nuevo usuario*/
		
		Usuario u = new Usuario();
		
		u.setCod_usua(1);
		u.setNom_usua("Dolly");
		u.setApe_usua("Sotelo");
		u.setCla_usua("dolly11");
		u.setEst_usua(1);
		u.setFna_usua("2003-10-02");
		u.setIdtipo(2);
		u.setUsuario("alx");
		
		/*empezar la transacción*/
		em.getTransaction().begin();
		
		/*para insertar*/
		em.persist(u);
		
		em.getTransaction().commit();
		
		System.out.println("Registró correctamente");
	}
	
}
