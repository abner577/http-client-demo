package todo.exception;

public class TodoNotFoundException extends Throwable{

    public TodoNotFoundException(String message) {
        super(message);
    }
}
