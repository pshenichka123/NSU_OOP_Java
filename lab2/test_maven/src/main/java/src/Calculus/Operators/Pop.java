package src.Calculus.Operators;

import src.Calculus.Context;

public class Pop extends Operators {
    public   void act(Context context, String[] parcedLine){
        context.numbers.pop();
    }
}
