package todo;

import org.junit.jupiter.api.Test;
import todo.exception.TodoNotFoundException;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 More of integration tests, since we are calling the actual TodoClient methods which have an external dependency (API we are calling)
 */
class TodoClientTest {

    // System under Test
    TodoClient client = new TodoClient();
    Todo todo = new Todo(101, 101, "Java HTTPClient Tutorial", false);

    int validId = 1;
    int invalidId = 999;

    String successfulRequestMessage = "Response status returned: ";
    String failedRequestMessage = "Todo with id of: " + invalidId + " not found";

    /**
     * GET requests tests
     */
    @Test
    void getAll() throws IOException, InterruptedException {
        List<Todo> todos = client.getAll();

        assertTrue(!todos.isEmpty());
        assertEquals(200, todos.size());
    }


    @Test
    void shouldReturnTodoGivenValidId() throws Exception, TodoNotFoundException {
        var todo = client.getById(validId);

        assertEquals(validId, todo.userId());
        assertEquals(validId, todo.id());
        assertFalse(todo.completed());
    }


    @Test
    void shouldThrowNotFoundExceptionGivenInvalidId() {
        var todoNotFoundException = assertThrows(TodoNotFoundException.class, () -> client.getById(invalidId));
        assertEquals(failedRequestMessage, todoNotFoundException.getMessage());
        assertFalse(successfulRequestMessage.equals(todoNotFoundException.getMessage()));
    }


    /**
     * POST request test
     */
    @Test
    void shouldReturnResponse201GivenValidTodo() throws Exception {
        var response = client.createTodo(todo);

        assertFalse(response.isEmpty());
        assertEquals(successfulRequestMessage + 201, response);
    }


    /**
     * PUT request tests
     */
    @Test
    void shouldReturnResponse200GivenValidTodo() throws Exception, TodoNotFoundException {
        var response = client.updateTodo(todo, validId);

        assertFalse(response.isEmpty());
        assertEquals(successfulRequestMessage + 200, response);
    }


    @Test
    void shouldThrowNotFoundExceptionGivenInvalidIdToUpdate() {
        var response = assertThrows(TodoNotFoundException.class, () -> client.updateTodo(todo, invalidId));
        assertEquals(failedRequestMessage, response.getMessage());
        assertFalse(successfulRequestMessage.equals(response));
    }


    /**
     * DELETE request tests
     */
    @Test
    void shouldReturnResponse200GivenValidId() throws Exception, TodoNotFoundException {
        var response = client.deleteTodo(validId);
        assertEquals(successfulRequestMessage + 200, response);
    }


    /**
     Would be the correct test for this scenario but for some reason the JSON placeholder API.
     Returns 200 even if you pass in an invalidId.
     */
//    @Test
//    void shouldThrowNotFoundExceptionGivenInvalidIdToDelete() throws Exception, TodoNotFoundException {
//        var response = assertThrows(TodoNotFoundException.class, () -> client.deleteTodo(invalidId));
//        assertEquals(failedRequestMessage, response.getMessage());
//        assertFalse(successfulRequestMessage.equals(response));
//    }
}