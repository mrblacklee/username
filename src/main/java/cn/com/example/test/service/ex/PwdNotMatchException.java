package cn.com.example.test.service.ex;

public class PwdNotMatchException extends RuntimeException{
    public PwdNotMatchException() {
    }

    public PwdNotMatchException(String message) {
        super(message);
    }
}
