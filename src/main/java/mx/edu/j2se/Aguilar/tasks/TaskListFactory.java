package mx.edu.j2se.Aguilar.tasks;

public class TaskListFactory {
    public static Object createTaskList(ListTypes.types type)
    {
        switch (type)
        {
            case ARRAY:
                return new ArrayTaskList();
            case LINKED:
                return new LinkedTaskList();
            default:
                return null;
        }

    }
}
