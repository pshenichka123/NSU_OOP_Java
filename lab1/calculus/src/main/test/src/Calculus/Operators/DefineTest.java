package src.Calculus.Operators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.Calculus.Calculus;
import src.Calculus.Context;

public class DefineTest {

    @Test
    void test1() throws Exception {
        Define define=new Define();
        Context context=new Context();
        String[] string ={"Define","a","10"};
        define.act(context,string);
        Assertions.assertTrue(context.is_param_defined("a"));
        Assertions.assertEquals(10,context.get_param_value("a"));
    }
    @Test
    void test2() {
        Define define = new Define();
        Context context = new Context();
        String[] string = {"Define", "a", "b"};
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            define.act(context, string);
        });
        Assertions.assertFalse(context.is_param_defined("a"));
        Assertions.assertNotNull(exception.getMessage());
    }

}
