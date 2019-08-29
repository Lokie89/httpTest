import java.io.FileNotFoundException;

public class HttpStatus {

    private final int OK = 200;
    private final int BadRequest = 400;
    private final int NotFound = 404;
    private final int InternalServerError = 500;

    static HttpStatus httpStatus = null;

    public static HttpStatus getInstance(){
        if(httpStatus==null){
            httpStatus = new HttpStatus();
        }
        return httpStatus;
    }

    public int getStatus(Exception e) {

        //switch 같은형태로 만들방법?

        if (e == null) {
            return OK;
        } else if (e.getClass().equals(FileNotFoundException.class)) {
            return NotFound;
        } else {
            return InternalServerError;
        }
    }
}
