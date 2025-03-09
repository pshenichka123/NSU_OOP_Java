package src.Calculus.Operators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.Calculus.Context;

public class PlusTest {

    @Test
    void test1() throws Exception {
        Context context=new Context();
        context.push(4.0);
        context.push(2.0);
        String[] string ={"Plus"};
        Plus plus=new Plus();
        plus.act(context,string);
        Assertions.assertEquals(6,context.pop());
    }
}
