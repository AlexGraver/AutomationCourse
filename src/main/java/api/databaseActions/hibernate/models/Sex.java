package api.databaseActions.hibernate.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sex")
@Data
public class Sex {

    @Id
    int id;
    @Column
    String name;
}
