package src.Calculus.Operators;


import src.Calculus.Context;

public class Define extends  Operators
{
    public   void act(Context context, String[] parcedLine){
    context.parameters.put(parcedLine[1],Double.parseDouble(parcedLine[2]));
    }


}
