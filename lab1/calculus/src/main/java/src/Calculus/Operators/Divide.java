package src.Calculus.Operators;

import src.Calculus.Context;

public class Divide extends Operators{
    public   int act(Context context, String[] parcedLine) throws Exception {
        if(context.is_numbers_empty())
        {
            throw new Exception("No enough numbers:2");
        }
    Double num1=context.pop();
        if(context.is_numbers_empty())
        {
            throw new Exception("Stack is empty");
        }
    Double num2=context.pop();
    context.push(num2/num1);        //наоборот??
    return 0;
    }

}
