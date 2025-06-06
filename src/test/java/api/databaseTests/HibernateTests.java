package api.databaseTests;

import api.databaseActions.hibernate.HibernateConnection;
import api.databaseActions.hibernate.models.Animal;
import api.databaseActions.jdbc.DataBaseCreation;
import api.databaseActions.jdbc.JdbcConnection;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HibernateTests {

    @BeforeAll
    static void init() {
        DataBaseCreation.createData();
    }

    @AfterAll
    static void tearDown() {
        JdbcConnection.closeConnection();
        HibernateConnection.createSessionFactory().close();
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

    @Test
    public void testPlacesTableCreationAndData(){
        long count = HibernateConnection
                .createSessionFactory()
                .openSession()
                .createQuery("SELECT COUNT(p) FROM Places p", Long.class)
                .getSingleResult();

        assertEquals(5L, count);
    }

    @Test
    public void testAnimalForeignKeys() {
        Object object = HibernateConnection
                .createSessionFactory()
                .openSession()
                .createNativeQuery("""
            SELECT COUNT(*) FROM public.animal a
            WHERE a.place IN (SELECT p.id FROM public.places p)
              AND a.sex IN (SELECT s.id FROM public.sex s)
              AND a."type" IN (SELECT t.id FROM public."types" t)
            """)
                .getSingleResult();

        assertEquals(10L, ((Number) object).longValue());
    }

    @Test
    public void testWorkmanPositions() {
        Object result = HibernateConnection
                .createSessionFactory()
                .openSession()
                .createNativeQuery("""
                        SELECT w.id, w."position" FROM public.workman w
                        LEFT JOIN public.positions p ON w."position" = p.id
                        WHERE p.id IS NULL
                """).getFirstResult();

        assertEquals(0, result); //there is no workers with NULL position
    }

    @Test
    public void testZooAnimalRelation() {
        Object result = HibernateConnection
                .createSessionFactory()
                .openSession()
                .createNativeQuery("""
                        SELECT COUNT(*) FROM public.zoo_animal
                        WHERE zoo_id IN (SELECT id FROM public.zoo)
                        AND animal_id IN (SELECT id FROM public.animal)
                        AND workman IN (SELECT id FROM public.workman)
                """).getSingleResult();

        assertEquals(10, ((Number) result).intValue()); // count all relations of zoo_animal
    }

}
