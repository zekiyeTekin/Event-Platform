package com.myProject.eventPlatform.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConnectionFilter {


    private String sender;

    private Integer receiver;

    private Boolean status;


}
