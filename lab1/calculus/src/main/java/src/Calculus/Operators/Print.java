package src.Calculus.Operators;

import src.Calculus.Context;

public class Print extends  Operators {
    public   void act(Context context, String[] parcedLine){
        System.out.println(context.numbers.getLast());
    }

}
