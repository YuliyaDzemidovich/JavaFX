import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HibernateConnectionTest {
    private SessionFactory factory;
    private Session session;

    @BeforeAll
    public void init(){
        factory = new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void connectionTest() {
        session = factory.openSession();
        Query query = session.createSQLQuery("SELECT * FROM vehicle");
        List res = query.list();
        session.close();
        assertTrue(res.size() > 0, "is passed if table 'vehicle' contains " +
                "at least one row and it can be selected from database");
    }

}
