package mx.edu.j2se.Aguilar.tasks;

public class Task {
    //Atributos
    String title;
    int time;
    int start;
    int end;
    int interval;
    boolean active;
    boolean repetido;



    //Constructores

    public Task(String title, int time){
        this.title = title;
        this.time = time;
        this.active = false; //inactive task
        this.repetido = false; // one repeat only
    }

    public Task(String title, int start, int end, int interval){
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
        if (this.repetido ==true){
            this.repetido = false;
        }
        else {
            this.time = time;
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
        int nextimeaf = this.time - current;

        if(nextimeaf <= 0 && interval == 0) {
            return -1;

        }
        else {
            return this.start;
        }


        }


}
