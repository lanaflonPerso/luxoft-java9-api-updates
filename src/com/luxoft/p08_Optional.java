package com.luxoft;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class p08_Optional
{
    @Test
    public void ifPresentOrElseNoData()
    {
        getEmpty().ifPresentOrElse(
                (stream) -> System.out.println(Arrays.toString(stream.toArray())),
                () -> System.out.println("No data found.")
        );
    }

    @Test
    public void ifPresentOrElse()
    {
        getNumbers().ifPresentOrElse(
                (stream) -> System.out.println(Arrays.toString(stream.toArray())),
                () -> System.out.println("No data found.")
        );
    }

    @Test
    public void or()
    {
        int[] values = {1, 2, 3};

        Optional<IntStream> value = getEmpty().or(() -> Optional.of(IntStream.of(values)));

        assertArrayEquals(values, value.get().toArray());
    }

    @Test
    public void stream()
    {
        getListOfOptionals().stream()
                .flatMap(Optional::stream)
                .forEach(System.out::println);
    }

    private List<Optional> getListOfOptionals()
    {
        List<Optional> optionals = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            if (i % 3 == 0)
            {
                optionals.add(Optional.empty());
            }
            else
            {
                optionals.add(Optional.of(i));
            }
        }

        return optionals;
    }

    private Optional<IntStream> getEmpty()
    {
        return Optional.empty();
    }

    private Optional<IntStream> getNumbers()
    {
        return Optional.of(IntStream.of(1, 2, 3));
    }
}
