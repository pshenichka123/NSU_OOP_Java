package src.Calculus.Operators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.Calculus.Context;

public class MinusTest {
    @Test
    void test1() throws Exception {
        Context context=new Context();
        context.push(4.0);
        context.push(2.0);
        String[] string ={"Minus"};
        Minus minus=new Minus();
        minus.act(context,string);
        Assertions.assertEquals(2,context.pop());
    }
    @Test
    void test2() throws Exception {
        Context context=new Context();
        context.push(4.0);
        String[] string ={"Minus"};
        Minus minus=new Minus();
       Exception exception = Assertions.assertThrows(Exception.class, () -> {
            minus.act(context, string);
        });
        Assertions.assertEquals(4, context.pop());
    }

}
