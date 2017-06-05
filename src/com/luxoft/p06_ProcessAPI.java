package com.luxoft;

import java.util.Arrays;

/**
 * http://openjdk.java.net/jeps/102
 */
public class p06_ProcessAPI
{
    public static void main(String[] args) throws Exception
    {
        Thread.sleep(500);

        ProcessHandle cp = ProcessHandle.current();

        System.out.println("PID:              " + cp.pid());

        System.out.println("\nstartInstant:     " + cp.info().startInstant().get());
        System.out.println("totalCpuDuration: " + cp.info().totalCpuDuration().get());
        System.out.println("user:             " + cp.info().user().get());

        System.out.println("\nArguments:        " + Arrays.toString(cp.info().arguments().get()));
        System.out.println("commandLine:      " + cp.info().commandLine().get());
        System.out.println("command:          " + cp.info().command().get());

        cp.onExit().thenAccept(handle -> System.out.println("Good By from " + handle.pid()));
    }
}
