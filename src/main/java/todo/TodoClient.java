package todo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 Class where we are going to be talking to the JSONplaceholder API
 */
public class TodoClient {

    private final String BASE_API_URL = "https://jsonplaceholder.typicode.com/todos";
    private final HttpClient client;

    public TodoClient() {
        client = HttpClient.newHttpClient();
    }


    public String getAll() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_API_URL))
                .GET()
                .build();

        HttpResponse<String> response  = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
