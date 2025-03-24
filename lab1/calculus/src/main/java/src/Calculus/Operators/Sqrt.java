package src.Calculus.Operators;

import src.Calculus.Context;

public class Sqrt extends Operators{

    public int act(Context context, String[] parcedLine) throws Exception {
        if(context.is_numbers_empty())
        {
            throw new Exception("Stack is empty");
        }
        double top_num  = context.pop();
        if(top_num<0)
        {
            context.push(top_num);

            throw new Exception(":"+Double.toString(top_num)+"is less than 0");
        }
        context.push(Math.sqrt(top_num));
        return  0;
    }
}
