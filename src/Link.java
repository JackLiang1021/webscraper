import java.net.MalformedURLException;
import java.net.URL;
import java.util.Stack;

public class Link {
    private String url;
    private Stack<String> endpoint = new Stack<>();
    private Stack<String> UsedEndpoints = new Stack<>();

    public Link(String url){
        this.url = url;
    }

    public Link(String url, Stack<String> endpoints){
        this.url = url;
        this.endpoint = endpoints;
    }

    public URL UrlEndNextEndpoint() throws MalformedURLException {
        UsedEndpoints.push(endpoint.peek());
        return new URL(this.url + endpoint.pop());
    }
    public URL getUrl() throws MalformedURLException {
        return new URL(this.url);
    }

    public void AddEndpoint(Stack<String> endpoint){

        for(String s : endpoint){
            if(UsedEndpoints.contains(s)) continue;
            this.endpoint.push(s);
        }
    }
}
