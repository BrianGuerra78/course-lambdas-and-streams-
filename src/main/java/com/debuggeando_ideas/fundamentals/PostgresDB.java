package com.debuggeando_ideas.fundamentals;

import java.util.List;

public class PostgresDB implements DatabaseService {
    @Override
    public Object getById(Long id) {
        return "Getting data from Postgres with id: " + id;
    }

    @Override
    public List getAllRecords() {
        return List.of("Getting all records from Postgres");
    }
}
