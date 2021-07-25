package com.webflux.api.exception;

public class PlanetException extends RuntimeException {

    private int httpStatus;
    private String error;


    public PlanetException(int httpStatus, String error, String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.error = error;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlanetNotFoundException{");
        sb.append("httpStatus=").append(httpStatus);
        sb.append(", error='").append(error).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
