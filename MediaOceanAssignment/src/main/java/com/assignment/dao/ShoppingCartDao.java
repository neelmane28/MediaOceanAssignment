package com.assignment.dao;

import com.assignment.model.Category;
import com.assignment.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ShoppingCartDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Category getCategory(int categoryId) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Query query = session.createQuery("from Category c where c.categoryId = :id");
            query.setParameter("id", categoryId);

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (Category) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public Product getProduct(Integer item) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Query query = session.createQuery("from Product p where p.productId = :id");
            query.setParameter("id", item);

            List queryList = query.list();
            if (queryList != null && queryList.isEmpty()) {
                return null;
            } else {
                return (Product) queryList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }


}
