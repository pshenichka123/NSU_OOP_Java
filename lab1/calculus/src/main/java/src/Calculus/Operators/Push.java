package src.Calculus.Operators;

import src.Calculus.Context;

public class Push extends  Operators{
    public  int act(Context context, String[] parcedLine) {
        String param = parcedLine[1];
        try {
            Double number = Double.parseDouble(param);
            context.push(number);
            return  0;
        } catch (NumberFormatException e) {
            if (context.is_param_defined(param)) {
                context.push(context.get_param_value(param));
                return  0;
            } else {
                System.out.println("'" + param + "'" + "Not a number, define it ");
                return 0;
            }
        }

    }
}
