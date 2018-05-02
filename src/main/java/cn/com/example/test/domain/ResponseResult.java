package cn.com.example.test.domain;


public class ResponseResult<T> {
    private Integer state;
    private String message;
    private T data;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseResult(Integer state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }
    public ResponseResult(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseResult<T> that = (ResponseResult<T>) o;

        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        int result = state != null ? state.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    private class T {
    }
}
