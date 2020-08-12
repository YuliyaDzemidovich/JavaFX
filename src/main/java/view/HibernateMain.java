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

        ServiceAdvisor serviceAdvisor1 = new ServiceAdvisor("Прытько", "Игорь", "Степанович", Date.valueOf("1981-03-21"),
                Date.valueOf("1981-03-21"), Date.valueOf("1981-03-21"), 1500);
        Mechanic mechanic1 = new Mechanic("Умелец", "Александр", "Михайлович", Date.valueOf("1987-08-30"),
                Date.valueOf("1987-08-30"), Date.valueOf("1987-08-30"), "моторист", 5);

        VehiclePassport vehiclePassport1 = new VehiclePassport(vehicle1, "0965 AX-2", individualClient1, Date.valueOf("2015-09-11"), country1, true);

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
            session.save(serviceAdvisor1);
            session.save(mechanic1);
            session.save(vehiclePassport1);
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
