package kz.halykacademy;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;



public class Homework29 {
    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Enter name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        JSONObject file = new JSONObject();
        file.put("name", name);
        file.put("salary", "123");
        file.put("age", "23");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://dummy.restapiexample.com/create"))
                .headers("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(file)))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
