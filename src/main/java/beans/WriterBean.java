package beans;

import logon.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Named
@ApplicationScoped
public class WriterBean {
  private String paramText;
  public WriterBean(){
    paramText="";
  }
  public void setParamText(String text){
    paramText = text;
  }
  public String getParamText(){
    return paramText;
  }

  public void save(){
      UserEntity user = new UserEntity();
      user.setName("Dumm Kopf");
      user.setLogin(paramText);
      user.setPassword("test");

      EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataPU");
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      em.persist(user);
      em.getTransaction().commit();
      em.close();
  }
}
