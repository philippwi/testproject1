package beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

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
}
