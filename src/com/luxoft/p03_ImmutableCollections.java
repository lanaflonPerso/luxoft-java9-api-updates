package com.luxoft;


import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 *
 * http://openjdk.java.net/jeps/269
 *
 */
public class p03_ImmutableCollections
{

    public void list()
    {
        List<Number> empty = List.of();

        List<Number> one = List.of(1);
        List<Number> two = List.of(2);

        List<Number> listOfN = List.of(1, 2, 3, 4, 5, 6);

        Integer[] numbers = {1, 2, 3};
        List<Number> arr = List.of(numbers);
    }

    @Test
    public void set()
    {
        Set<Number> empty = Set.of();

        Set<Number> one = Set.of(1);
        Set<Number> two = Set.of(1, 2);

        Set<Number> setOfN = Set.of(1, 2, 3);

        Set<Number> first = Set.of(1, 2, 3);
        Set<Number> second = Set.of(4, 5, 6);

        Set<Number> tmp = new HashSet<>(first);
        tmp.addAll(second);

        Set<Number> union = Set.of(tmp.toArray(new Integer[tmp.size()]));
        System.out.println(first + " + " + second + " => " + union + "\n");

        tmp = new HashSet<>(union);
        Set<Number> toRetain = Set.of(3, 5, 8);
        tmp.retainAll(toRetain);

        Set<Number> intersection = Set.of(tmp.toArray(new Integer[tmp.size()]));
        System.out.println(union + " - " + toRetain + " => " + intersection);

    }

    public void map()
    {
        Map<Integer, String> empty = Map.of();

        Map<Integer, String> one = Map.of(1, "one");
        Map<Integer, String> two = Map.of(1, "one", 2, "two");

        Map<Integer, String> mapOfN = Map.of(1, "one", 2, "two", 3, "three");

        Map<Integer, String> maxLengthTen = Map.of(1, "one", 2, "two", 3, "three", 4, "four",
                5, "five", 6, "six", 7, "seven",
                8, "eight", 9, "nine", 10, "ten");

        Map<Integer, String> entriesUnlimited = Map.ofEntries(
                Map.entry(1, "one"),
                Map.entry(2, "two")
        );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void immutableListAdd()
    {
        List<Integer> numbers = List.of(1, 2, 3);
        numbers.add(23);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void immutableListSet()
    {
        List<Integer> numbers = List.of(1, 2, 3);
        numbers.set(0, 23);
    }

    @Test
    public void arrayAsList()
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        int newValue = 23;
        numbers.set(0, newValue);

        Assert.assertTrue(numbers.get(0) == newValue);
    }


    @Test(expected = UnsupportedOperationException.class)
    public void immutableSetAdd()
    {
        Set<Integer> numbers = Set.of(1, 2, 3);
        numbers.add(4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void immutableMapPut()
    {
        Map<Integer, String> names = Map.of(4, "Oleg", 5, "Alina");
        names.put(3, "Tom");
    }

}
