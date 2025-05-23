package Repository;

import Entity.SaleTransaction;
import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SaleTransactionRepository {

    public void save(SaleTransaction sale) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(sale);
            transaction.commit();
        }
    }

    public void delete(SaleTransaction sale) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(sale);
            transaction.commit();
        }
    }

    public SaleTransaction getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(SaleTransaction.class, id);
        }
    }

    public List<SaleTransaction> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<SaleTransaction> cq = cb.createQuery(SaleTransaction.class);
            Root<SaleTransaction> root = cq.from(SaleTransaction.class);
            cq.select(root);
            return session.createQuery(cq).getResultList();
        }
    }
}
