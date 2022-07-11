package service;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class ConsumerApi {

    private ConsumerApi() {
        throw new IllegalStateException("Utility class");
    }

    static final OkHttpClient client = new OkHttpClient();

    public static String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

    public static String response(String name) throws IOException {
        final Gson gson = new Gson();
        String url = String.format("https://gateway.marvel.com/v1/public/characters?nameStartsWith=%s&ts=52&apikey=c7e6ddb5f4e5204134fd8933c5ade103&hash=441d24ff33fa8b27c3442396a9987430", name);
        String response = run(url);
        return response;
    }

}
