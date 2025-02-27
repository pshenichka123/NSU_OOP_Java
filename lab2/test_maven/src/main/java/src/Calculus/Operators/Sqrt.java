package src.Calculus.Operators;

import src.Calculus.Context;

public class Sqrt extends Operators{

    public   void act(Context context, String[] parcedLine){
        Double top_num  = context.numbers.pop();
        context.numbers.push(Math.sqrt(top_num));

    }
}
