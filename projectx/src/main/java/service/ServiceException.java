package service;

/**
 * Created by roski on 4/22/16.
 */
public class ServiceException extends Exception {

    public ServiceException(){
        super();
    }

    public ServiceException(Throwable cause){
        super(cause);
    }

    public ServiceException(String message, Throwable cause){
        super(message, cause);
    }

    public ServiceException(String s) {
        super(s);
    }
}
