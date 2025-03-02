package src.Calculus.Operators;


import src.Calculus.Context;

public class Define extends  Operators
{
    public   int act(Context context, String[] parcedLine) throws Exception {
        try{
            Double.parseDouble(parcedLine[2]);
        }catch (Exception e)
        {
            throw new Exception("Second parameter is not a Double type");
        }

    context.put_parameter(parcedLine[1],Double.parseDouble(parcedLine[2]));
    return 0;
    }


}
