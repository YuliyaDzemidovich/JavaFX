package controller;

import model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Controller {
    static SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public List<Order> getAllOrders() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Order");
        List<Order> res = query.getResultList();
//        System.out.print("RES LIST SIZE: ");
//        System.out.println(res.size());
        session.close();
        return res;
    }
}
