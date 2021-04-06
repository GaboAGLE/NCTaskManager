package mx.edu.j2se.Aguilar.tasks;

import java.util.Objects;

public class Task implements Cloneable {
    //Atributos
   private String title;
   private int time;
   private int start;
   private int end;
   private int interval;
   private boolean active;
   private boolean repetido;



    //Constructores

    public Task(String title, int time){
        if ( time < 0)
            throw new IllegalArgumentException();
        this.title = title;
        this.time = time;
        this.active = false; //inactive task
        this.repetido = false; // one repeat only
    }

    public Task(String title, int start, int end, int interval){
        if (time < 0)
            throw new IllegalArgumentException();
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.active = false; //inactive task
        this.repetido = true;

    }
    //Metodos
    //Methods for reading and setting the task name:
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
    // Methods for reading and setting the task status:

    public boolean isActive(){
        return this.active;

    }

    public void setActive(boolean active){
        this.active = active;

    }

    //Methods for reading and changing execution time for non-repetitive tasks:
    public int getTime(){
        if (this.repetido == false){
            return this.time;
        }
        else {
            return this.start;
        }

    }
    public void setTime(int time){  //?

        if (!this.repetido){
            this.time = time;
        }else
            {
            this.repetido = false;
            this.time = time;
            this.end = 0;
            this.interval = 0;
            this.start = 0;

        }
    }

    // Methods for reading and changing execution time for repetitive tasks:
    public int getStartTime(){
        if (this.repetido == true){
            return this.start;
        }
        else {
            return  this.time;
        }
    }
    public int getEndTime(){
        if(this.repetido == true){
            return this.end;
        }
        else{
            return this.time;
        }
    }
    public int getRepeatInterval(){
        if (this.repetido == false){
            return 0;
        }
        else{
            return this.interval;
        }
    }
    public void setTime(int start, int end, int interval){
        if (this.repetido == false){
            this.repetido = true;
            this.end = end;
            this.interval = interval;
            this.time = 0;
        }
        else {
            this.start = start;
            this.end = end;
            this.interval = interval;
        }
    }
    public boolean isRepetido(){

        return this.repetido;
    }

    // TASK 2. CHECKING THE NEXT TASK EXECUTION

     int nextTimeAfter (int current){
        if (this.repetido == false)
        {
            return this.time;
        }
        else{
            if(current >= this.start && interval == 0){
                return -1;
            }else{
                return this.start;
            }
        }




        }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), isActive(), getTime(), getRepeatInterval(),
                isRepetido(), getStartTime(), getEndTime());
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", time=" + time +
                ", start=" + start +
                ", end=" + end +
                ", interval=" + interval +
                ", active=" + active +
                ", repeat=" + repetido +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return time == task.time &&
                start == task.start &&
                end == task.end &&
                interval == task.interval &&
                active == task.active &&
                repetido == task.repetido
                && Objects.equals(title, task.title);

    }
    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", time=" + time +
                ", start=" + start +
                ", end=" + end +
                ", interval=" + interval +
                ", active=" + active +
                ", repeat=" + repetido +
                '}';
    }


    @Override
    public Task clone() throws CloneNotSupportedException {
        //Returns an object Task
        return (Task) super.clone();
    }

}
