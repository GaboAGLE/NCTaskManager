package mx.edu.j2se.Aguilar.tasks;

public class ArrayTaskList {

    Task []arrayTask = new Task[0]; // crear el arreglo e iniciarlo en cero

    void add (Task task){

    }

    public boolean remove (Task task){
        for(int i = 0; i <= size(); ){
            if(arrayTask[i].equals(task)){

            }
        }

    }

    public int size(){
        return this.arrayTask.length;
    }

    public Task getTask(int index){

        return arrayTask[index];
    }

    public ArrayTaskList incoming(int from, int to){

    }
}
