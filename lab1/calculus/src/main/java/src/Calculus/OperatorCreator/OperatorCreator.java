package src.Calculus.OperatorCreator;

import src.Calculus.Operators.Operators;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.util.Map;
import java.util.Objects;

public class OperatorCreator {



    public Operators create(String operatorName) throws IOException {

        String line;
        boolean foundOperatorName=false;
        String class_absolute_path = null;
        String config_name="/config.txt";
        InputStream inputStream = getClass().getResourceAsStream(config_name);
        assert inputStream != null;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String config_line;
        while ((config_line=bufferedReader.readLine())!=null) {

            String[] pair=config_line.split(" ");
            if(pair[0].equalsIgnoreCase(operatorName)) {
            class_absolute_path=pair[1];
            foundOperatorName=true;
            break;
            }

        }
    if(!foundOperatorName) {
        System.out.println("введена некорректна комманда");
        return null;
    }

        try {
            Class<?> clazz = Class.forName(class_absolute_path);

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
