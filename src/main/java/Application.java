import todo.TodoClient;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException, InterruptedException {

        var todoClient = new TodoClient();
        var response = todoClient.getAll();
        System.out.println(response);
    }
}
