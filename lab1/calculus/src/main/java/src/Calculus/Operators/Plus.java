package src.Calculus.Operators;

import src.Calculus.Context;

public class Plus extends Operators {
    public  int act(Context context, String[] parcedLine) throws Exception {
        if(context.is_numbers_empty())
        {
            throw new Exception("No enough numbers:2");
        }
        Double num1=context.pop();
        if(context.is_numbers_empty())
        {
            context.push(num1);

            throw new Exception("Stack is empty");
        }
        Double num2=context.pop();
        context.push(num2+num1);
        return  0;
    }
}
