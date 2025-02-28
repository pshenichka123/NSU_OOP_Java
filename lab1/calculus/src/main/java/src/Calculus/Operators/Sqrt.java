package src.Calculus.Operators;

import src.Calculus.Context;

public class Sqrt extends Operators{

    public int act(Context context, String[] parcedLine){
        if(context.is_numbers_empty())
        {
            System.out.println("Not enough numbers to do:"+ parcedLine[0]);
            return -1;
        }
        double top_num  = context.pop();
        context.push(Math.sqrt(top_num));
        return  0;
    }
}
