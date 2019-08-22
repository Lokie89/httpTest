public class HttpRequest {

    // example
    //
    //    GET /333 HTTP/1.1
    //    Host: localhost:9000
    //    Connection: keep-alive
    //    Cache-Control: max-age=0
    //    Upgrade-Insecure-Requests: 1
    //    User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36
    //    Sec-Fetch-Mode: navigate
    //    Sec-Fetch-User: ?1
    //    Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3
    //  Sec-Fetch-Site: none
    //  Accept-Encoding: gzip, deflate, br
    //  Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
    //  Cookie: _ga=GA1.1.600882356.1565150844; joinDRemember=traeuman@amoeba.co.kr; Idea-653c1248=87c2f8e7-d5d1-4f2a-8153-ef9e879f552c; wcs_bt=1740fed304a4b:1565251183

    private String method;
    private String uri;
    private String protocol = "HTTP/1.1";
    private String host;
    private String accept;
    private String cookie;


    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHost() {
        return host;
    }

    public String getAccept() {
        return accept;
    }

    public String getCookie() {
        return cookie;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    @Override
    public String toString() {
        return "method : " + getMethod() + " uri : " + getUri() + " protocol : " + getProtocol() + " host : " + getHost() + " accept : " + getAccept() + " cookie : " + getCookie();
    }

}
