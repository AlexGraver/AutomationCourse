package api.databaseTests;

import api.databaseActions.jdbc.DataBaseCreation;
import api.databaseActions.jdbc.JdbcConnection;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.ResultSet;


import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class JdbcTests {

    private static Connection connection;
    ResultSet resultSet;

    @BeforeAll
    static void init() {
        connection = JdbcConnection.createConnection();
    }

    @BeforeEach
    void createTable(){
        DataBaseCreation.createData();
    }

    @AfterAll
    static void tearDown() {
        JdbcConnection.closeConnection();
    }

    @Test
    void checkRowCountForAnimal() throws SQLException {
        ResultSet resultSet = JdbcConnection
                .createConnection()
                .createStatement()
                .executeQuery("SELECT count (*) from " + "animal");
        //Move cursor to the first result row
        resultSet.next();
        int count = resultSet.getInt("count(*)");
        System.out.printf("In table public.%s are %s records%n", "animal", count);

        assertEquals(10, count);
    }

    @Test
    public void testPlacesTableCreationAndData() throws SQLException {
        resultSet = connection
                .prepareStatement("SELECT COUNT(*) FROM public.places")
                .executeQuery();
        resultSet.next();
        assertEquals(5, resultSet.getInt(1));
    }

    @Test
    public void testAnimalForeignKeys() throws SQLException {
        resultSet = connection
                .prepareStatement("""
            SELECT COUNT(*) FROM public.animal
            WHERE place IN (SELECT id FROM public.places)
              AND sex IN (SELECT id FROM public.sex)
              AND "type" IN (SELECT id FROM public."types")""")
                .executeQuery();
        resultSet.next();
        assertEquals(10, resultSet.getInt(1));
    }

    @Test
    public void testWorkmanPositions() throws SQLException {
        resultSet = connection
                .prepareStatement("""
            SELECT w.id, w."position" FROM public.workman w
            LEFT JOIN public.positions p ON w."position" = p.id
            WHERE p.id IS NULL""")
                .executeQuery();
        assertFalse(resultSet.next()); //there is no workers with NULL position
    }

    @Test
    public void testZooAnimalRelation() throws SQLException {
        resultSet = connection
                .prepareStatement("""
            SELECT COUNT(*) FROM public.zoo_animal
            WHERE zoo_id IN (SELECT id FROM public.zoo)
              AND animal_id IN (SELECT id FROM public.animal)
              AND workman IN (SELECT id FROM public.workman)""")
                .executeQuery();
        resultSet.next();
        assertEquals(10, resultSet.getInt(1)); // count all relations of zoo_animal
    }
}
