package src.Calculus.Operators;

import src.Calculus.Context;

public class Pop extends Operators {
    public   int act(Context context, String[] parcedLine) throws Exception {
        if(context.is_numbers_empty())
        {
            throw new Exception("Stack is empty");
        }
        context.pop();
        return 0;
    }
}
