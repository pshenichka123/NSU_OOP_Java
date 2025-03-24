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
            context.push(num1);

            throw new Exception("Stack is empty");
        }

        Double num2=context.pop();
        if(num1==0){
            context.push(num1);
            context.push(num2);
            throw new Exception("Division by zero, numbers returned on stack");
        }

        context.push(num2/num1);        //наоборот??
        return 0;
    }

}
