import static spark.Spark.*;

/**
 * Starts server at http://localhost:4567
 */
public class Server {

    public static void main(final String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
