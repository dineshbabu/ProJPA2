package persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class JPAUtil {
  private static EntityManagerFactory emf;
  static {
    try {
        emf = Persistence.createEntityManagerFactory("helloworld");
    } catch (Throwable ex) {
        throw new ExceptionInInitializerError(ex);
     }
   }
   public static EntityManagerFactory getEntityManagerFactory() {
       return emf;
   }
   public static void shutdown() {
       // Close caches and connection pools
	   emf.close();
   }
 }