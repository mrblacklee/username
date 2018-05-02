package cn.com.example.test.service.ex;

public class UserNameAlreadyExsitException extends RuntimeException {
    public UserNameAlreadyExsitException() {
    }

    public UserNameAlreadyExsitException(String message) {
        super(message);
    }
}
