package com.ListForReact.ApiDbList;

import jakarta.persistence.*;

@Entity
@Table(name = "GOODTHINGLIST")
public class GoodThingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String name;

    private boolean eatable;
}
