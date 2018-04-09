package beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CalculatorBean {

    private double param1, param2;
    private String result;

    public CalculatorBean(){
        param1 = 0;
        param2 = 0;
        result = "0.0";
    }

    //setter
    public void setParam1(double p){
        param1 = p;
    }
    public void setParam2(double p){
        param2 = p;
    }

    //getter
    public double getParam1() {
        return param1;
    }
    public double getParam2() {
        return param2;
    }
    public String getResult() {
        return result;
    }

    public void add(){
        result = Double.toString(param1 + param2);
    }
}
