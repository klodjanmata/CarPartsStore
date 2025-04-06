package Repository;

import Entity.Part;
import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transaction;
import org.hibernate.Session;

import java.util.List;

public class PartRepository {
    public void save(Part parts) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = (Transaction) session.beginTransaction();
            session.merge(parts);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void delete(Part parts) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction = (Transaction) session.beginTransaction();
            session.remove(parts);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Part getById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
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
