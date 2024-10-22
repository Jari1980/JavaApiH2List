package com.ListForReact.ApiDbList;

import jakarta.persistence.*;

@Entity
@Table(name = "GOODTHINGLIST")
public class GoodThing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;

    private boolean eatable;

    public GoodThing(String name, boolean eatable) {
        this.name = name;
        this.eatable = eatable;
    }

    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEatable() {
        return eatable;
    }

    public void setEatable(boolean eatable) {
        this.eatable = eatable;
    }
}
