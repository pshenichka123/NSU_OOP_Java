package src.Calculus.Operators;

import src.Calculus.Context;

public class Push extends  Operators{
    public   void act(Context context, String[] parcedLine){
    context.numbers.push(Double.parseDouble(parcedLine[1]));
    }


}
