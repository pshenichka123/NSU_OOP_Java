package src.Calculus.Operators;


import src.Calculus.Context;

public class Define extends  Operators
{
    public   int act(Context context, String[] parcedLine){
    context.put_parameter(parcedLine[1],Double.parseDouble(parcedLine[2]));
    return 0;
    }


}
