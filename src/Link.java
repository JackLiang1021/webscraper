import java.net.MalformedURLException;
import java.net.URL;
import java.util.Stack;

public class Link {
    private String StringUrl;
    private Stack<String> endpoint = new Stack<>();
    private Stack<String> UsedEndpoints = new Stack<>();
    private URL url;

    public Link(String url) throws MalformedURLException {
        this.StringUrl = url;
        this.url = new URL(url);
    }

    public Link(String url, Stack<String> endpoints) throws MalformedURLException {
        this.StringUrl = url;
        this.url = new URL(url);
        this.endpoint = endpoints;
    }

    public URL UrlEndNextEndpoint() throws MalformedURLException {
        String path = endpoint.pop();
        if (!path.startsWith("/")) path = "/" + path;
        UsedEndpoints.push(path);
        return new URL(this.url.getProtocol(), this.url.getHost(), this.url.getPort(), path);
    }

    public URL GetRobotTxtUrl() throws MalformedURLException {
        return new URL(this.url.getProtocol(), this.url.getHost(), this.url.getPort(), "/robots.txt");
    }

    public boolean HasNextEndpoint(){
        return !endpoint.isEmpty();
    }
    public URL getUrl() throws MalformedURLException {
        return this.url;
    }

    public void AddEndpoint(Stack<String> endpoint){

        for(String s : endpoint){
            if(UsedEndpoints.contains(s)) continue;
            this.endpoint.push(s);
        }
    }
}
