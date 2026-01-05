import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import java.net.URL;
import java.net.URLConnection;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {


        Stack<String> urls = new Stack<>();
        urls.push("https://www.google.com");

        while(!urls.isEmpty()){
            Link link = new Link(urls.pop());
            Stack<String> endpoints = new Stack<>();
            link.AddEndpoint(endpoints);
            URLConnection con;
            if(link.HasNextEndpoint()){
                con = link.getUrl().openConnection();
            }else{
                con = link.GetRobotTxtUrl().openConnection();
            }

            InputStream is = con.getInputStream();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String line = null;

                while ((line = br.readLine()) != null) {
                    if(line.contains("Allow: ")) {
                        System.out.println(line);
                    }
                }


            }


        }


    }
}