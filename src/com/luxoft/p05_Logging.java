package com.luxoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * http://openjdk.java.net/jeps/158
 *
 * Use any tag from the list logging-tags.txt here.
 *
 * -Xlog:gc=debug
 *
 * Run java -Xlog in terminal to look what is going on.
 */
public class p05_Logging
{
    public static void main(String[] args) throws Exception
    {
        List<String> names = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("logging-tags.txt"));

        // works when reader is final or effectively final
        try (reader)
        {
            String currentLine;

            while ((currentLine = reader.readLine()) != null)
            {
                names.add(currentLine);
            }
        }

        names.stream().sorted().forEach(System.out::println);
    }
}
