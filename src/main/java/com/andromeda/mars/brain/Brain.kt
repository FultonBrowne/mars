package com.andromeda.mars.brain

class Brain {
    fun main(){
        val i = 1
        val threads = arrayListOf<Thread>()
        threads.add(Thread{inputCell(0)})
        while (i < 800){
            threads.add((Thread{brainTransistor(i)}))
        }

    }
    private fun brainTransistor(index:Int){
    }
    private fun inputCell(index: Int){

    }
}