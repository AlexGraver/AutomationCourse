package api.databaseActions.hibernate.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "workman")
@Data
public class Workman {

    @Id
    int id;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "age")
    int age;
    @Column(name = "position")
    int position;

    @Override
    public String toString() {
        return "Workman{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position=" + position +
                '}';
    }
}
