package com.sunlife.status.model;

import lombok.Data;

@Data
public class StatusBean {

	String url;
    int statusCode;
    Long duration;
    Long date;
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    
    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
    
    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
