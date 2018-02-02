package com.chatgo.web.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;


public class RoomForm {
    @NotNull
    @Size(min = 1, max = 20)
    private String name;

    @NotNull
    private Map<Long, Boolean> users;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public Map<Long, Boolean> getUsers() {
        return users;
    }

    public void setUsers(Map<Long, Boolean> users) {
        this.users = users;
    }
}
