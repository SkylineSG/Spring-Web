package com.crud.tasks.domain;

public class TrelloList {
    private String id;
    private String name;
    private boolean isClosed;

    public TrelloList(String id, String name, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.isClosed = isClosed;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isClosed() {
        return isClosed;
    }
}
