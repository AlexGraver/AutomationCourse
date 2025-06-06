package api.databaseTests;

import api.databaseActions.hibernate.HibernateConnection;
import api.databaseActions.hibernate.models.Animal;
import api.databaseActions.jdbc.DataBaseCreation;
import api.databaseActions.jdbc.JdbcConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HibernateTests {

    @BeforeAll
    static void init() {
        DataBaseCreation.createData();
    }

    @AfterAll
    static void tearDown() {
        JdbcConnection.closeConnection();
    }

    @Test
    void countRowAnimal() {
        int count = HibernateConnection
                .createSessionFactory()
                .openSession()
                .createNativeQuery("SELECT * from animal ", Animal.class)
                .getResultList().size();
        System.out.printf("Table public.animal has exact %s rows%n", count);

        Assertions.assertEquals(10, count);
    }

}
