package mx.edu.j2se.Aguilar.tasks;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.stream.Stream;
public abstract class AbstractTaskList implements Iterable<Task>, Cloneable{
    public abstract void add(Task task);

    public abstract boolean remove(Task task);

    public abstract int size();

    public abstract Task getTask(int index);

    public abstract ArrayTaskList incoming(int from, int to);

    public abstract Stream<Task> getStream();


}