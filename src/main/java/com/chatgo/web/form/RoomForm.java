package com.chatgo.web.form;

import com.chatgo.business.entity.RoomUser;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;


public class RoomForm {
    @NotNull
    @Size(min = 1, max = 20)
    private String name;

    private List<Long> userIds;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

}