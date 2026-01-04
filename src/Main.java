import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import java.net.URL;
import java.net.URLConnection;


public class Main {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://www.google.com/robots.txt");


        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line = null;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }


        }
    }
}