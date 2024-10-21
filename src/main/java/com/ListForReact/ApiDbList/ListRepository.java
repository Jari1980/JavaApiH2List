package com.ListForReact.ApiDbList;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ListRepository {
    private final JdbcClient jdbcClient;

    public ListRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<GoodThingList> findAll(){
        return jdbcClient.sql("select * from goodthinglist")
                .query(GoodThingList.class)
                .list();
    }

    public void create(String name, boolean eatable){
        var item = jdbcClient.sql("INSERT INTO GoodThingList(name, eatable) values(:name, :eatable)")
                .param("name", name)
                .param("eatable", eatable)
                .update();
    }

    public void delete(Integer id){
        var updated = jdbcClient.sql("DELETE FROM GoodThingList WHERE ID = :ID")
                .param("ID", id)
                .update();
    }

    public void seed(){
        var updated1 = jdbcClient.sql("INSERT INTO GoodThingList(name, eatable) values('Snus', true)")
                .update();
        var updated2 = jdbcClient.sql("INSERT INTO GoodThingList(name, eatable) values('Boccoli', true)")
                .update();
        var updated3 = jdbcClient.sql("INSERT INTO GoodThingList(name, eatable) values('Pepsi Max', true)")
                .update();
        var updated4 = jdbcClient.sql("INSERT INTO GoodThingList(name, eatable) values('Java', false)")
                .update();
        var updated5 = jdbcClient.sql("INSERT INTO GoodThingList(name, eatable) values('C#', false)")
                .update();
    }
}
