package api.databaseActions.hibernate.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "types")
@Data
public class Types {

    @Id
    int id;
    @Column
    String name;
}
