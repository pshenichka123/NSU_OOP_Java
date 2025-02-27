package src.Calculus.Operators;

import src.Calculus.Context;

public class Multiply extends  Operators   {
    public   void act(Context context, String[] parcedLine){
        Double num1=context.numbers.pop();
        Double num2=context.numbers.pop();
        context.numbers.push(num2*num1);
    }
}
