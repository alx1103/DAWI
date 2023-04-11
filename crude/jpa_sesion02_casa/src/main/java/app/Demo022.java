package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo022 {

	public static void main(String[] args) {
		/*establecer la conexión*/
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("AP001");
		
		/*crear el manejador de entidades*/
		EntityManager em = fabrica.createEntityManager();
	
		/*si no encuentra el metodo devolverá null*/
		/*si lo encuentra devuelve un objeto*/
		Usuario u = em.find(Usuario.class, 1);
		
		if(u!=null) {
			u.setCod_usua(1);
			u.setNom_usua("Dolly");
			u.setApe_usua("Sotelo");
			u.setCla_usua("dolly11");
			u.setEst_usua(1);
			u.setFna_usua("2001-10-02");
			u.setIdtipo(2);
			u.setUsuario("alx");
			
			/*empieza la transacción*/
			em.getTransaction().begin();
			
			/*busca, y después actualiza*/
			em.merge(u);
			
			/*finaliza la transacción*/
			em.getTransaction().commit();
			
			/*Usuario actualizado*/
			System.out.println("Usuario " +  u.getApe_usua() + " Actualizado");
		}
		
		else {
			/*Este usuario no existe*/
			System.out.println("Este usuario no existe");
		}
		
	}
	
}
