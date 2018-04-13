package logon;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LogonTest {


  public static void main(String[] args) {
    UserEntity user = new UserEntity();
    user.setName("Teste Mich");
    user.setLogin("testuser");
    user.setPassword("test");

   EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataPU");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(user);
    em.getTransaction().commit();
    em.close();
  }
}