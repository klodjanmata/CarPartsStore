package Repository;

import Entity.Part;
import Util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.SimpleFormatter;

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

    public void importPartToCSV(List<Part> parts, String filePath){
        try (FileReader reader = new FileReader(filePath)){
            reader.read()
        }
    }

    public void exportPartToCSV(List<Part> parts, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Name,Description,Price,Quantity,Supplier\n");
            //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            SimpleFormatter formatter =new SimpleFormatter();

            for (Part part :parts) {
                String line = String.format(
                        "%d,%s,%s,%d,%d,%s\n",
                        part.getId(),
                        part.getName(),
                        part.getDescription(),
                        part.getPrice(),
                        part.getQuantity(),
                        part.getSupplier().getName(),
                        formatter.format(part.getId())
                );
                writer.write(line);
            }

            System.out.println("Part exported sucesfully to  " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

