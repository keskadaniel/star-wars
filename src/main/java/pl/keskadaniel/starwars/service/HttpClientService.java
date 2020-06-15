package pl.keskadaniel.starwars.service;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.*;

@Service
public class HttpClientService {

    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .executor(executorService)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();


    public String doGet(String filePath) {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(filePath))
                .build();

        CompletableFuture<HttpResponse<String>> response =
                httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        return getBodyFromResponse(response);

    }

    private String getBodyFromResponse(CompletableFuture<HttpResponse<String>> response) {

        String result = "Something gone wrong!";

        try {
            result = response.thenApply(HttpResponse::body).get(10, TimeUnit.SECONDS);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        return result;
    }


}
