package com.chatgo.web.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class RoomForm {
    @NotNull
    @Size(min = 1, max = 20)
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
