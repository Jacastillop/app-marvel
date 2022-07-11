package model;

import lombok.Data;

@Data
public class Character {
    private Integer id;
    private String name;
    private String description;

    public Character(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
