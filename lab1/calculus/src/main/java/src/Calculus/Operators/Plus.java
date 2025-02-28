package src.Calculus.Operators;

import src.Calculus.Context;

public class Plus extends Operators {
    public  int act(Context context, String[] parcedLine){
        if(context.is_numbers_empty())
        {
            System.out.println("Not enough numbers to do:"+ parcedLine[0]);
            return -1;
        }
        Double num1=context.pop();
        if(context.is_numbers_empty())
        {
            System.out.println("Not enough numbers to do:"+ parcedLine[0]);
            return -1;
        }
        Double num2=context.pop();
        context.push(num2+num1);
        return  0;
    }
}
