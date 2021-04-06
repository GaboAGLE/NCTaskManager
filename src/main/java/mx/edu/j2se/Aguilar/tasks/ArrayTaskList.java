package mx.edu.j2se.Aguilar.tasks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class ArrayTaskList extends AbstractTaskList implements Iterable<Task>, Cloneable{
    private int countOfTasks = 0;
    Task[] arrayTask = new Task[100]; // crear el arreglo
    private Task[] arrayTaskList;

    void add (Task task) {
        if(task == null){
            throw new NullPointerException();}

        arrayTask[countOfTasks] = task;
        countOfTasks++;

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
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException();}

        return arrayTask[index];
    }

    public ArrayTaskList incoming(int from, int to){
        ArrayTaskList arrayTaskList = new ArrayTaskList();
        for (int i = 0; i < arrayTask.length; i++) {
            if (arrayTask[i].nextTimeAfter(from) != -1 && arrayTask[i].getEndTime() <= to) {
                if (arrayTask[i].isActive()) {
                    arrayTaskList.add(arrayTask[i]);
                }
            }
        }
        return arrayTaskList;
    }

    public ArrayTaskList clone() throws CloneNotSupportedException{
        return (ArrayTaskList) super.clone();
    }

    
    @Override
    public Stream<Task> getStreams() {
        return Stream.of(this.arrayTaskList);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arrayTaskList);
    }

    @Override
    public String toString() {
        return "ArrayTaskList{" +
                "arrayTaskList=" + Arrays.toString(arrayTaskList) +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayTaskList)) return false;
        ArrayTaskList tasks = (ArrayTaskList) o;

        return Arrays.equals(arrayTaskList, tasks.arrayTaskList);
    }

}
