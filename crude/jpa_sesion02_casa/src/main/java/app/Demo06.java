package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Usuario;

public class Demo06 {

	static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ejercicios");
	static EntityManager em = fabrica.createEntityManager();
	
	
	public static void main(String[] args) {
		
		
		List<Usuario> usuario = em.createQuery("Select u from Usuario u", Usuario.class).getResultList();
		
		for (Usuario u : usuario) {
			System.out.println("Listado de usuarios" + "\n");
			System.out.println("Código: " + u.getCod_usua() + "\n");
			System.out.println("Nombre: " + u.getNom_usua() + "\n");
			System.out.println("Tipo: " + u.getIdtipo() + " " + u.getObjTipo().getDescripcion() + "\n");
			System.out.println("-------------------------------"+"\n");
			
		}
		
		
		
		
	}
	
	
}
