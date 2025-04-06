package Repository;

import Entity.Supplier;
import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SupplierRepository {
    public void save(Supplier supplier) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(supplier);
            transaction.commit();
        }
    }

    public void delete(Supplier supplier) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(supplier);
            transaction.commit();
        }
    }

    public Supplier getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Supplier.class, id);
        }
    }

    public List<Supplier> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Supplier> cq = cb.createQuery(Supplier.class);
            Root<Supplier> root = cq.from(Supplier.class);
            cq.select(root);
            return session.createQuery(cq).getResultList();
        }
    }
}
