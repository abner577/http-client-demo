package todo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

/**
 Class where we are going to be talking to the JSONplaceholder API
 */
public class TodoClient {

    private final String BASE_API_URL = "https://jsonplaceholder.typicode.com/todos";
    private final HttpClient client;
    private final ObjectMapper objectMapper;

    public TodoClient() {
        client = HttpClient.newHttpClient();
        objectMapper = new ObjectMapper();
    }

    public List<Todo> getAll() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_API_URL))
                .GET()
                .build();

        HttpResponse<String> response  = client.send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response.body(), new TypeReference<List<Todo>>() {});
    }

    public Todo getById(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_API_URL + "/" + id))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(response. body(), new TypeReference<Todo>() {});
    }
}
