package com.cineslate.CineSlate.apiThings;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ApiResponse{
    private Data data;
    
    public class Data{
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    }

}
