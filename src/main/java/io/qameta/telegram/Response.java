package io.qameta.telegram;

public class Response<T> extends BaseResponse {

    private T result;

    T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
