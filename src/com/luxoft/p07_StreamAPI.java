package com.luxoft;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.stream.IntStream;

public class p07_StreamAPI
{
    @Test
    public void takeWhileOrdered()
    {
        IntStream ordered = IntStream.of(1, 2, 3, 4, 5, 6, 7);

        int[] result = ordered.takeWhile(this::lessThen4).toArray();

        assertArrayEquals(new int[] {1, 2, 3}, result);
    }

    @Test
    public void takeWhileUnordered()
    {
        IntStream ordered = IntStream.of(1, 4, 7, 3, 5, 10);

        int[] result = ordered.takeWhile(this::lessThen4).toArray();

        assertArrayEquals(new int[] {1}, result);
    }

    @Test
    public void dropWhileOrdered()
    {
        IntStream ordered = IntStream.of(1, 2, 3, 4, 5, 6, 7);

        int[] result = ordered.dropWhile(this::lessThen4).toArray();

        assertArrayEquals(new int[] {4, 5, 6, 7}, result);
    }

    @Test
    public void dropWhileUnordered()
    {
        IntStream unordered = IntStream.of(1, 4, 7, 3, 5);

        int[] result = unordered.dropWhile(this::lessThen4).toArray();

        assertArrayEquals(new int[] {4, 7, 3, 5}, result);
    }

    private boolean lessThen4(Integer n)
    {
        return n < 4;
    }
}
