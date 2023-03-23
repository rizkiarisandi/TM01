import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ConnectURL {
    private final String USER_AGENT = "Mozilla/5.0";
    public static URL TM1_MuhamadRizkiAriSandi_2D(String urlquery){
        URL url = null;
        try {
            url = new URL(urlquery.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
    public static String getResponseFromHttpurl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("//A");
            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            }
        } finally {
            urlConnection.disconnect();
        }
        return null;
    }
}
