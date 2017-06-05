package com.luxoft;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class p02_TryWithResources
{
    public static void main(String[] args) throws Exception
    {
        List<String> names = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("names.txt"));

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
