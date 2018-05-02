package cn.com.example.test.service.ex;

public class PasswordNotMatchException extends RuntimeException {
    public PasswordNotMatchException() {
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }
}
