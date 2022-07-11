package model;

import lombok.Data;

@Data
public class Character {
    private Integer id;
    private String name;
    private String description;

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
