public class HttpResponse {
//    HTTP/1.1 200OK
//    Date:Mon,23May 2005 22:38:34GMT
//    Content-Type:text/html;charset=UTF-8
//    Content-Encoding:UTF-8
//    Content-Length:138
//    Last-Modified:Wed,08Jan 2003 23:11:55GMT
//    Server:Apache/1.3.3.7(Unix)(Red-Hat/Linux)
//    ETag:"3f80f-1b6-3e1cb03b"
//    Accept-Ranges:bytes
//    Connection:close
//
//  <html>
//  <head>
//    <title> An Example
//    Page</title>
//  </head>
//  <body>
//    Hello World, this
//    is a
//    very simple
//    HTML document.
//  </body>
//  </html>

    private String protocol = "HTTP/1.1";
    private String status;
    private String date;
    private String content_Type;
    private String content_Encoding;
    private String content_Length;
    private String last_Modified;
    private String server;
    private String eTag;
    private String accept_Ranges;
    private String connection;
    private String responseData;
}
