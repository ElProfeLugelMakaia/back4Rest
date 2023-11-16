package com.makaia.test.rest;

import java.time.ZonedDateTime;

public class MakaiaErrorResponse {

    protected String mensaje;
    protected Integer code;
    protected ZonedDateTime hora;

    public MakaiaErrorResponse(String mensaje, Integer code, ZonedDateTime hora) {
        this.mensaje = mensaje;
        this.code = code;
        this.hora = hora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ZonedDateTime getHora() {
        return hora;
    }

    public void setHora(ZonedDateTime hora) {
        this.hora = hora;
    }
}
