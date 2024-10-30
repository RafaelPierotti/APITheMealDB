import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira em ingles o nome de uma receita: ");
        var prato = scanner.nextLine();

        String url = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + prato;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}