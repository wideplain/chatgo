package com.chatgo.web.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MessageForm {

    @NotNull
    @Size(min = 1, max = 300)
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
