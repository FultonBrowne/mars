package com.andromeda.mars;

import com.andromeda.mars.brain.CLI;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class run {
    @Contract(pure = true)
    public static void main(@NotNull String[] args){
        new CLI().main();
    }
}
