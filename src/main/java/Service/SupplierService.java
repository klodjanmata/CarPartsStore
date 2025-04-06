
package Service;

import Entity.Supplier;
import Repository.SupplierRepository;
import Util.Helper;

import java.util.List;

public class SupplierService {
    private final SupplierRepository supplierRepository = new SupplierRepository();

    public void addSupplier() {
        System.out.println("Adding a new supplier!");
        Supplier s = new Supplier();

        System.out.println("Supplier Name:");
        s.setName(Helper.getStringFromUser());

        System.out.println("Supplier Email:");
        s.setEmail(Helper.getStringFromUser());

        System.out.println("Supplier Phone:");
        s.setPhone(Helper.getStringFromUser());

        supplierRepository.save(s);
        System.out.println("Supplier added!");
    }

    public void viewSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();
        System.out.println("ID\tName\tEmail\tPhone");
        for (Supplier s : suppliers) {
            System.out.printf("%d\t%s\t%s\t%s\n", s.getId(), s.getName(), s.getEmail(), s.getPhone());
        }
    }

    public void deleteSupplier() {
        System.out.println("Enter Supplier ID to delete:");
        int id = Helper.getIntFromUser();
        Supplier s = supplierRepository.getById(id);
        if (s != null) {
            supplierRepository.delete(s);
            System.out.println("Supplier deleted!");
        } else {
            System.out.println("Supplier not found.");
        }
    }

    public void editSupplier() {
        System.out.println("Enter Supplier ID to edit:");
        int id = Helper.getIntFromUser();
        Supplier s = supplierRepository.getById(id);

        if (s == null) {
            System.out.println("Supplier not found.");
            return;
        }

        System.out.println("New Name (current: " + s.getName() + "):");
        s.setName(Helper.getStringFromUser());

        System.out.println("New Email (current: " + s.getEmail() + "):");
        s.setEmail(Helper.getStringFromUser());

        System.out.println("New Phone (current: " + s.getPhone() + "):");
        s.setPhone(Helper.getStringFromUser());

        supplierRepository.save(s);
        System.out.println("Supplier updated.");
    }
}
