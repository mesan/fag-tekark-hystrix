import java.io.IOException;

public class Client {

    public static void main(final String[] args) throws IOException {
        System.out.println(new RestCommand().execute());
    }
}
