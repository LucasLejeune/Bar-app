package main.java.com.examen.ExamenLucasLejeune.model;

import org.springframework.stereotype.Entity;

@Entity
public class Cocktail {
    private Integer id;
    private String name;
    
    
    public int getId() {
        return id;
    }
    public string getName() {
        return name;
    }

    public void setName(string name) {
        this.name = name;
    }
    
}
