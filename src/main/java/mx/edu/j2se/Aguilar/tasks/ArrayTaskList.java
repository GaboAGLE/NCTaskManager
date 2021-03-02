package mx.edu.j2se.Aguilar.tasks;

import java.util.Arrays;

public class ArrayTaskList {
    private int countOfTasks = 0;
    Task []arrayTask = new Task[100]; // crear el arreglo

    void add (Task task) {
        if(task == null)
            throw new NullPointerException();

        arrayTask[countOfTasks] = task;
        countOfTasks++;
        if (countOfTasks == arrayTask.length) {
            arrayTask = Arrays.copyOf(arrayTask, arrayTask.length * 2);
        }
    }

    public boolean remove (Task task){
        for(int i = 0; i <= size(); ){
            if(arrayTask[i].equals(task)){
                arrayTask[i] = null;
                break;

            }
        }
        return true;

    }

    public int size(){
        return this.arrayTask.length;
    }

    public Task getTask(int index){
        if(index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        return arrayTask[index];
    }

    public ArrayTaskList incoming(int from, int to){

    }
}
