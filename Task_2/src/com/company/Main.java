package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main {

public static void main(String[] args) throws ParserException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parser myParser = new Parser();

        for(;;)
        {
            try
            {
                System.out.print("Введите выражение для вычисления\n-> ");
                String str = reader.readLine();
                if (str.equals("Close")) break;
                double result = myParser.evaluate(str);

                DecimalFormatSymbols s = new DecimalFormatSymbols();
                s.setDecimalSeparator('.');
                DecimalFormat f = new DecimalFormat("#,###.00", s);


                System.out.printf("%s = %s%n", str, f.format(result));

            }
            catch(ParserException e)
            {
                System.out.println(e);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }

    }


