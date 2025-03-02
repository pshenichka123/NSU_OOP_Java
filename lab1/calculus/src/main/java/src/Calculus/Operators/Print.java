package src.Calculus.Operators;

import src.Calculus.Context;

public class Print extends  Operators {
    public   int act(Context context, String[] parcedLine) throws Exception {
        if(context.is_numbers_empty())
        {
            throw new Exception("Stack is empty");
        }
        System.out.println(context.get_last());
        return 0;
    }

}
