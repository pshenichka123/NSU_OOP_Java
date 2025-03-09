package src.Calculus.Operators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.Calculus.Context;

public class MultiplyTest {

    @Test
    void test1() throws Exception {
        Context context=new Context();
        context.push(4.0);
        context.push(2.0);
        String[] string ={"Multiply"};
        Multiply multiply=new Multiply();
        multiply.act(context,string);
        Assertions.assertEquals(8,context.pop());


    }

}
