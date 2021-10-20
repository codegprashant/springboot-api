package org.zensar.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("message")
public class ResponseModel {


    @JsonProperty("message")
    private String messageString;


    public ResponseModel(String messageString){
        super();
        this.messageString=messageString;
    }

    public ResponseModel(){
        super();
    }


    public String getMessageString() {
        return messageString;
    }

    public void setMessageString(String messageString) {
        this.messageString = messageString;
    }
}
