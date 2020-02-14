package com.andromeda.mars;

import com.andromeda.mars.brain.CLI;
import com.andromeda.mars.scripts.BasicDemo;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class run {
    @Contract(pure = true)
    public static void main(@NotNull String[] args) throws IOException {
        System.out.println("run basic test 1 y or n");
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        String readLine = obj.readLine();
        if(readLine.equals("y")) new BasicDemo().main();
        else new CLI().main();
    }
}
