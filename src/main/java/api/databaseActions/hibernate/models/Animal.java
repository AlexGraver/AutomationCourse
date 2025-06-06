package api.databaseActions.hibernate.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "animal")
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "type")
    private int type;
    @Column(name = "sex")
    private int sex;
    @Column(name = "place")
    private int place;


    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", type=" + type +
                ", sex=" + sex +
                ", place=" + place +
                '}';
    }
}
