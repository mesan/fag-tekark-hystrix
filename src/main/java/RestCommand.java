import java.io.IOException;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestCommand extends HystrixCommand<String> {

    public RestCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    }

    @Override
    protected String run() throws IOException {
        final Request request = new Request.Builder()
                .url("http://localhost:4567/hello")
                .build();

        final OkHttpClient client = new OkHttpClient();
        final Response response = client.newCall(request).execute();

        return response.body().string();
    }

    @Override
    protected String getFallback() {
        return "Noooooo";
    }
}
