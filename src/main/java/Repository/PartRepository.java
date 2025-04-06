package Repository;

import Entity.Part;
import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PartRepository {
    public void save(Part part) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(part);
            transaction.commit();
        }
    }

    public void delete(Part part) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(part);
            transaction.commit();
        }
    }

    public Part getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Part.class, id);
        }
    }

    public List<Part> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Part> cq = cb.createQuery(Part.class);
            Root<Part> root = cq.from(Part.class);
            cq.select(root);
            return session.createQuery(cq).getResultList();
        }
    }
}

