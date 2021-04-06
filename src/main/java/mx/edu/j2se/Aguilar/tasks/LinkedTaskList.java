package mx.edu.j2se.Aguilar.tasks;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;


public class LinkedTaskList extends AbstractTaskList implements Iterable<Task> {

    class Node{
        Node next;
        Task task;

        public Node(Task task, Node next) {
            this.task = task;
            this.next = next;
        }
    }
    private Node first;
    private Node last;
    private int countofTasks;

    public void add(Task task){
        if(task == null){
            throw new NullPointerException();}


        Node linkedTasksList = new Node(task, null);
        if (first == null) {
            first = linkedTasksList;
            last = first;
        } else {
            last.next = linkedTasksList;
            last = last.next;
        }
        countofTasks++;
    }

    public boolean remove (Task task){
        Node prev = null;
        if (task == null) {
            return false;
        }
        Node position = first;
        for (; position != null; position = position.next) {
            if (task.equals(position.task)) {
                if (position == first) {
                    first = position.next;
                } else if (position != last) {
                    prev.next = position.next;
                } else {
                    prev.next = null;
                    last = prev;
                }
                countofTasks--;
                return true;
            }
            prev = position;
        }
        return false;
    }

    public int size(){

        return this.countofTasks;
    }

    public Task getTask(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node returnTask = first;
        for (int i = 0; i < index; i++) {
            returnTask = returnTask.next;
        }
        return returnTask.task;

    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof LinkedTaskList) {
            LinkedTaskList listOther = (LinkedTaskList) o;
            if (this.size() == listOther.size()) {
                Iterator list1 = this.iterator();
                Iterator list2 = listOther.iterator();

                while (list1.hasNext()) {
                    Object e1 = list1.next();
                    Object e2 = list2.next();

                    if (!(e1 == null ? e2 == null : e1.equals(e2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for (Task task : this) {
            hashCode = 31 * hashCode + (task == null ? 0 : task.hashCode());
        }
        return hashCode;
    }

    public LinkedTaskList clone() throws CloneNotSupportedException {
        LinkedTaskList link = (LinkedTaskList) super.clone();
        link.countofTasks = 0;
        for (int i = 0; i < countofTasks; i++) {
            link.add(getTask(i));
        }
        return link;

    }
    @Override
    public Stream<Task> getStream() {
        ArrayTaskList list = new ArrayTaskList();
        for (int i = 0; i < size(); i++) {
            list.add(getTask(i));
        }
        return list.getStream();
    }

    @Override
    public String toString() {
        return "LinkedTaskList{" +
                "start=" + first +
                ", end=" + last +
                ", countofTasks=" + countofTasks +
                '}';
    }
}
