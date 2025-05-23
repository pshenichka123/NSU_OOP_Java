package src.Calculus.Operators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.Calculus.Context;

public class DivideTest {

    @Test
    void test1() throws Exception {
        Context context=new Context();
        context.push(4.0);
        context.push(2.0);
        String[] string ={"Divide"};
        Divide divide=new Divide();
        divide.act(context,string);
        Assertions.assertEquals(2,context.pop());
    }
    @Test
    void test2() throws Exception {
        Context context=new Context();
        context.push(4.0);
        context.push(0.0);
        String[] string ={"Divide"};
        Divide divide=new Divide();
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            divide.act(context, string);
        });
    }

}
