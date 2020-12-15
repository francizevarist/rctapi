package com.rct.app.commondto;

public class ResponseDto<T> {
    private T data;

    public ResponseDto(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }
}
