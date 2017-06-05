package com.luxoft;

import java.util.Iterator;

public class p4_DiamondOperator
{
    public void anonymousInnerClassDemo()
    {
        // Java 8 will not compile new Iterator<>
        new Iterator<>()
        {
            @Override
            public boolean hasNext()
            {
                return false;
            }

            @Override
            public String next()
            {
                return null;
            }
        };
    }
}
