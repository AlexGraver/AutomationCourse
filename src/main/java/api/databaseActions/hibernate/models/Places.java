package api.databaseActions.hibernate.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "places")
@Data
public class Places {

    @Id
    int id;
    @Column(name = "row")
    int row;
    @Column(name = "place_num")
    int place_num;
    @Column(name = "name")
    String name;
}
