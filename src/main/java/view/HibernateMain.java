package view;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.sql.Date;

public class HibernateMain {
    static SessionFactory factory;
    public static void main(String[] args) {
        factory = new Configuration().configure().buildSessionFactory();
        writedownData();

    }

    public static void writedownData() {
        Session session = factory.openSession();

        Country country1 = new Country("Russia");
        Brand brand1 = new Brand("Ford", country1);
        Model model1 = new Model("Focus 2", brand1);
        Vehicle vehicle1 = new Vehicle("XX9FORDVIN", 2011, "Frozen White", model1);

        Country country2 = new Country("Germany");
        Brand brand2 = new Brand("BMW", country2);
        Model model2 = new Model("525i", brand2);
        Vehicle vehicle2 = new Vehicle("WAUZZBMWVIN", 2006, "Black", model2);

        Model model3 = new Model("X5", brand2);
        Vehicle vehicle3 = new Vehicle("WAUZZBMWX5VIN", 2009, "Gray", model3);

        IndividualClient individualClient1 = new IndividualClient("Петров", "Иван", "Вадимович", "Минск", "555-42-81", new Date(1000));
        CompanyClient companyClient1 = new CompanyClient("ZubrCompany", "Vitebsk, Belarus", "555-33-22");

        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(country1);
            session.save(country2);
            session.save(brand1);
            session.save(brand2);
            session.save(model1);
            session.save(model2);
            session.save(model3);
            session.save(vehicle1);
            session.save(vehicle2);
            session.save(vehicle3);
            session.save(individualClient1);
            session.save(companyClient1);
            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}
