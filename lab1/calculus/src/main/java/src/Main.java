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
    public static void main(String[] args) throws Exception {
        InputStream inputStream;
        if(args.length==0)
        {
           inputStream=System.in;
        }
        else{
        String filePath = args[0]; // Путь к вашему файлу
        inputStream = new FileInputStream(filePath);
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        Calculus calculus=new Calculus();
        Logger logger = Logger.getLogger(("Calculus_logger"));
        while( (line = bufferedReader.readLine())!=null)
        {
            String[] parcedTokens=Parcer.parce(line);
            calculus.operator= OperatorCreator.create(parcedTokens[0]);
            if(calculus.operator!=null) {
                try {
                    logger.log(Level.INFO, "Doing " + parcedTokens[0]);
                    calculus.act(parcedTokens);
                } catch (Exception e) {
                    logger.log(Level.WARNING, e.getMessage());
                }
            }
        }




    }
}