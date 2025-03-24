package src;
import  java.util.logging.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

import src.Calculus.Calculus;
import src.Calculus.OperatorCreator.OperatorCreator;
import src.Calculus.Operators.Operators;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //TODO
    //1. Конфиг переделать
    //2. Обработка пустых строк
    //3. Обработка не найденных команд
    //4. Тесты
    public static void main(String[] args) throws Exception {
        InputStream inputStream;
        if(args.length==0)
        {
           inputStream=System.in;
        }
        else{
        String filePath = args[0];
        inputStream = new FileInputStream(filePath);
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        Calculus calculus=new Calculus();
        Logger logger = Logger.getLogger(("Calculus_logger"));
        OperatorCreator operatorCreator=new OperatorCreator();

        while( (line = bufferedReader.readLine())!=null)
        {
            String[] parsedTokens=Parcer.parce(line);
            if(parsedTokens.length==0 || parsedTokens[0].isEmpty())
            {continue;}

            calculus.operator= operatorCreator.create(parsedTokens[0]);
            if(calculus.operator!=null) {
                try {
                    logger.log(Level.INFO, "Doing " + parsedTokens[0]);
                    calculus.act(parsedTokens);
                } catch (Exception e) {
                    logger.log(Level.WARNING, e.getMessage());
                }
            }
        }




    }
}