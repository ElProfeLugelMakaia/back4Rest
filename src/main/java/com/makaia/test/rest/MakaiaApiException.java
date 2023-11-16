package com.makaia.test.rest;

import java.time.ZonedDateTime;

public class MakaiaApiException extends RuntimeException {

    public MakaiaApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public MakaiaApiException(String message) {
        super(message);
    }

}
