package com.king.examplecrUD4.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class ListPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private List<String> name;

    public ListPerson() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }
}
