package cucumber.stepdefs.support;

public class Url {
    private static final String ROOT = "http://localhost:8080/EmersonsGame";

    public static String url(String path) {
        return ROOT + path;
    }

    public static String url() {
        return url("");
    }
}
