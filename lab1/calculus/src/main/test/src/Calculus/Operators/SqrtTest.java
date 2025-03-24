package src.Calculus.Operators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.Calculus.Context;

public class SqrtTest {

    @Test
    void  test1() throws Exception {
        Sqrt sqrt=new Sqrt();
        Context context=new Context();
        context.push(9.0);
        String[] string ={"Sqrt"};

        sqrt.act(context,string);
        Assertions.assertEquals(3,context.pop());
    }


    @Test
    void  test2() throws Exception {
        Sqrt sqrt=new Sqrt();
        Context context=new Context();
        context.push(-9.0);
        String[] string ={"Sqrt"};

        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            sqrt.act(context, string);
        });
        Assertions.assertEquals(-9, context.pop());
    }



}
