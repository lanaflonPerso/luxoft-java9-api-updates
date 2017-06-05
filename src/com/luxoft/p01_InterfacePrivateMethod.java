package com.luxoft;

import java.util.Arrays;
import java.util.List;

public interface p01_InterfacePrivateMethod
{
    default void printNames()
    {
        List<String> names = Arrays.asList("Oleg", "Irina", "Igor");
        someHelperMethod(names);
    }

    private void someHelperMethod(List<String> data)
    {
        data.stream().forEach(String::toUpperCase);
    }
}
