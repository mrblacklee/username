package cn.com.example.test.service.ex;

public class ClassNameAlreadyExistException extends RuntimeException {
    public ClassNameAlreadyExistException() {
    }

    public ClassNameAlreadyExistException(String message) {
        super(message);
    }
}
