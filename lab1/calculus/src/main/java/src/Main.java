package src;

import java.io.*;
import java.nio.charset.StandardCharsets;

import src.Calculus.Calculus;
import src.Calculus.OperatorCreator.OperatorCreator;
import src.Calculus.Operators.Operators;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        String filePath = args[0]; // Путь к вашему файлу

        InputStream inputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        Calculus calculus=new Calculus();
        while( (line = bufferedReader.readLine())!=null)
        {
            String[] parcedTokens=Parcer.parce(line);
            calculus.operator= OperatorCreator.create(parcedTokens[0]);
            assert calculus.operator != null;
            calculus.operator.act(calculus.context,parcedTokens);

        }




    }
}