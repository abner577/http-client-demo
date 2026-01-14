
import todo.Todo;
import todo.TodoClient;
import todo.TodoNotFoundException;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws Exception, TodoNotFoundException {
        System.out.println("Check out the tests!");

        var todoClient = new TodoClient();
        var todo = new Todo(101, 101, "Java HTTPClient Tutorial", false);

        System.out.println(todoClient.deleteTodo(4));
    }
}
