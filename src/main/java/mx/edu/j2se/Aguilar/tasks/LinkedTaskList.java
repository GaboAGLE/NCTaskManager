package mx.edu.j2se.Aguilar.tasks;

public class LinkedTaskList {

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

    void add (Task task){
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
}
