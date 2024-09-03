package com.debuggeando_ideas.fundamentals;

import java.util.List;

public class MongoDB implements DatabaseService {
    @Override
    public Object getById(Long id) {
        return "Gettig data from Mongo with id: " + id;
    }

    @Override
    public List getAllRecords() {
        return List.of("Getting all records from Mongo");
    }
}
