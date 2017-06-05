package com.luxoft;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * http://openjdk.java.net/jeps/259
 *
 */
public class p09_StackWalker
{
    public static void main(String[] args)
    {
        p09_StackWalker stackWalker = new p09_StackWalker();

        stackWalker.getCaller();

        stackWalker.run(0);
    }

    public void getCaller()
    {
        StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);

        System.out.println(walker.getCallerClass());
        System.out.println();
    }

    public void run(int counter)
    {
        System.out.print(counter + " ");
        while (counter < 15)
        {
            run(++counter);
        }
        printLast10StackFrames();
    }

    private void printLast10StackFrames()
    {
        System.out.println("\n---------------------------------------");
        List<StackWalker.StackFrame> stack = StackWalker.getInstance()
                .walk(s -> s.limit(10).collect(Collectors.toList()));

        stack.stream().forEach(System.out::println);
        System.exit(0);
    }
}
