package com.andromeda.mars.util

import com.aparapi.Kernel

class RunOnGpu(runnable: Runnable) {
    init {
        val kernel: Kernel = object : Kernel() {
            override fun run() {
                runnable.run()
            }
        }
        kernel.run()
    }
}