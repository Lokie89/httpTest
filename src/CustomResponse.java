public class CustomResponse {

    private static final String httpVersion = "HTTP/1.1";

    public String getHeader(int statusCode, int bodyLength) {
        StringBuilder sb = new StringBuilder();
        if (statusCode == 200) {
            sb.append(httpVersion + " 200 OK\r\n");
            sb.append("Content-Type: text/html;charset=utf-8\r\n");
            sb.append("Content-Length: " + bodyLength + "\r\n");
            sb.append("\r\n");

        } else if(statusCode == 404){
            sb.append(httpVersion + " 404 Not Found\r\n");
            sb.append("Content-Type: text/html;charset=utf-8\r\n");
            sb.append("Content-Length: " + bodyLength + "\r\n");
            sb.append("\r\n");
        }else{
            sb.append(httpVersion + " 500 Internal error\r\n");
            sb.append("Content-Type: text/html;charset=utf-8\r\n");
            sb.append("Content-Length: " + bodyLength + "\r\n");
            sb.append("\r\n");
        }
        return sb.toString();
    }


}
