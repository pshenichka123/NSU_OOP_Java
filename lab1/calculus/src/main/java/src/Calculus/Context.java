package src.Calculus;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {
     Stack<Double> numbers;
     Map<String, Double> parameters;
    public  Context() {
         numbers = new Stack<>();
        parameters = new HashMap<>();
    }
}
