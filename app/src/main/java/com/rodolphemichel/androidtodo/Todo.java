package com.rodolphemichel.androidtodo;

import java.io.Serializable;

public class Todo implements Serializable {

    public int id;
    public String urgency;
    public String toDo;

    public Todo(int id, String urgency, String toDo) {
        this.urgency = urgency;
        this.toDo = toDo;
        this.id = id;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public String getUrgency() {
        return urgency;
    }

    public String getToDo() {
        return toDo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
