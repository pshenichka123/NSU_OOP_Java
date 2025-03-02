package src.Calculus;


import src.Calculus.Operators.Operators;

public class Calculus {
 public Context context;
 public Operators operator;
 public Calculus(){
     context= new Context();
 }


 public void act(String[] parcedline) throws Exception {
      operator.act(context,parcedline);

 }

}
