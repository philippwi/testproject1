package logon;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LogonTest {


  public static void main(String[] args) {
    UserEntity user = new UserEntity();
    user.setName("Dumm Kopf");
    user.setLogin("dummkopf");
    user.setPassword("test");

   EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataPU");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(user);
    em.getTransaction().commit();
    em.close();
  }
}