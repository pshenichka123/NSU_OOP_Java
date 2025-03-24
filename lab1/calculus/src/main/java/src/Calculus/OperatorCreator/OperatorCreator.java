package src.Calculus.OperatorCreator;

import src.Calculus.Operators.Operators;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class OperatorCreator {

    public static Operators create(String operatorName) throws IOException {

        String line;
        String className=operatorName;

        try {
            Class<?> clazz = Class.forName("src.Calculus.Operators."+ className);

            Object command = clazz.getDeclaredConstructor().newInstance();

            if (command instanceof Operators) {
                return   (Operators) command;
            } else {
                System.out.println("Объект не является типом Operators.");
                return   null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("введена некорректна комманда");
        return null;



    }

}
