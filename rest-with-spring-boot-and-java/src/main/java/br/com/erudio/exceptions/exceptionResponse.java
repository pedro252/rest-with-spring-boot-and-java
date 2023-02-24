package br.com.erudio.exceptions;

import java.io.Serializable;
import java.util.Date;

public class exceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String Menssage;
    private String details;

    public exceptionResponse(Date timestamp, String menssage, String details) {
        this.timestamp = timestamp;
        this.Menssage = menssage;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMenssage() {
        return Menssage;
    }

    public String getDetails() {
        return details;
    }
}
