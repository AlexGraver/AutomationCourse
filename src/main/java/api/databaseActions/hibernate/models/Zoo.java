package api.databaseActions.hibernate.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "animal")
@Data
public class Zoo {

        @Id
        private int id;
        @Column(name = "name")
        private String name;
}
