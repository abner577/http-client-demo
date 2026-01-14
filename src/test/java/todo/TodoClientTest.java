package todo;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoClientTest {

    // System under Test
    TodoClient client = new TodoClient();

    /**
    More of an integration test, since we are actually calling the .getAll() method which has an external dependency (API we are calling)
     */
    @Test
    void getAll() throws IOException, InterruptedException {
        List<Todo> todos = client.getAll();

        assertTrue(!todos.isEmpty());
        assertEquals(200, todos.size());

    }

    @Test
    void shouldReturnTodoGivenValidId() throws Exception {
        var todo = client.getById(1);

        assertEquals(1, todo.userId());
        assertEquals(1, todo.id());
        assertFalse(todo.completed());
    }
}