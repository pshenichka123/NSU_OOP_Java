package src.Calculus.Operators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.Calculus.Context;

public class PopTest {


    @Test
    void test1() throws Exception {
        Context context=new Context();
        context.push(4.0);
        String[] string ={"Pop"};
        Pop pop=new Pop();

        Assertions.assertEquals(4,context.pop());
    }

    @Test
    void test2() {
        Context context=new Context();
        String[] string ={"Pop"};
        Pop pop=new Pop();
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            pop.act(context, string);
        });

    }
}
