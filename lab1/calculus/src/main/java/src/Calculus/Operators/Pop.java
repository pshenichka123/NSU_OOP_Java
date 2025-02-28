package src.Calculus.Operators;

import src.Calculus.Context;

public class Pop extends Operators {
    public   int act(Context context, String[] parcedLine){
        if(context.is_numbers_empty())
        {
            System.out.println("Not enough numbers to do:"+ parcedLine[0]);
            return  -1;
        }
        context.pop();
        return 0;
    }
}
