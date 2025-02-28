package src.Calculus;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {
     private Stack<Double> numbers;
     private Map<String, Double> parameters;
    public  Context() {
         numbers = new Stack<>();
        parameters = new HashMap<>();
    }

    public boolean is_param_defined(String a)
{
    return parameters.containsKey(a);
}
    public Double get_param_value(String a)
    {
        return  parameters.get(a);
    }
    public void push(Double d)
    {
        numbers.push(d);
    }
    public  double pop()
    {
        return numbers.pop();
    }
    public boolean is_numbers_empty(){
        return numbers.isEmpty();
    };
    public Double get_last(){
        return numbers.getLast();
    }
    public void put_parameter(String key, Double value)
    {
        parameters.put(key,value);
    }



}
