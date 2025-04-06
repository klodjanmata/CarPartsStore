package Repository;

import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SaleTransactionRepository {
    public void save(SaleTransactionRepository sale) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(sale);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(SaleTransactionRepository sale) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.remove(sale);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public SaleTransactionRepository getById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.find(SaleTransactionRepository.class, id);
        }
    }

    public List<SaleTransactionRepository> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<SaleTransactionRepository> cq = cb.createQuery(SaleTransactionRepository.class);
            Root<SaleTransactionRepository> root = cq.from(SaleTransactionRepository.class);
            cq.select(root);
            return session.createQuery(cq).getResultList();
        }
    }
}
