package src.Calculus.Operators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.Calculus.Context;

public class PushTest {
    @Test
    void test1() throws Exception {
        Push push=new Push();
        Context context=new Context();
        String[] string ={"Push","10"};
        push.act(context,string);
        Assertions.assertFalse(context.is_numbers_empty());
        Assertions.assertEquals(10,context.pop());
    }


    @Test
    void test2() throws Exception {
        Push push=new Push();
        Context context=new Context();
        String[] string ={"Push","a"};
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            push.act(context, string);
        });
        Assertions.assertTrue(context.is_numbers_empty());
    }

}
