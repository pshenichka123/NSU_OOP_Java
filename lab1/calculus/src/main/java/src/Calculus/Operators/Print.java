package src.Calculus.Operators;

import src.Calculus.Context;

public class Print extends  Operators {
    public   int act(Context context, String[] parcedLine){
        if(context.is_numbers_empty()) {
            System.out.println("Can't" + parcedLine[0] + "No numbers");
            return -1;
        }
        System.out.println(context.get_last());
        return 0;
    }

}
