package Service;

import Entity.Part;
import Repository.PartRepository;
import Repository.SupplierRepository;
import Util.Helper;

import java.util.List;

public class PartService {
    private final PartRepository partRepository = new PartRepository();
    private final SupplierRepository supplierRepository = new SupplierRepository();

    public void addPart() {
        System.out.println("Adding a new part!");
        Part p = new Part();

        System.out.println("Write Name:");
        p.setName(Helper.getStringFromUser());

        System.out.println("Write Description:");
        p.setDescription(Helper.getStringFromUser());

        System.out.println("Enter Price:");
        p.setPrice(Helper.getDoubleFromUser());

        System.out.println("Enter Quantity:");
        p.setQuantity(Helper.getIntFromUser());

        System.out.println("Enter Supplier ID:");
        p.setSupplier(supplierRepository.getById(Helper.getIntFromUser()));

        partRepository.save(p);
        System.out.println("Part saved successfully!");
    }

    public void printAllParts() {
        List<Part> parts = partRepository.findAll();
        System.out.println("ID\tName\tDescription\tPrice\tQuantity\tSupplier ID");
        for (Part p : parts) {
            System.out.printf("%d\t%s\t%s\t%.2f\t%d\t%d\n",
                    p.getId(), p.getName(), p.getDescription(),
                    p.getPrice(), p.getQuantity(),
                    p.getSupplier() != null ? p.getSupplier().getId() : 0);
        }
    }

    public void deletePart() {
        System.out.println("Enter Part ID to delete:");
        int id = Helper.getIntFromUser();
        Part part = partRepository.getById(id);
        if (part != null) {
            partRepository.delete(part);
            System.out.println("Part deleted successfully!");
        } else {
            System.out.println("Part not found!");
        }
    }

    public void editPart() {
        System.out.println("Enter Part ID to edit:");
        int id = Helper.getIntFromUser();
        Part part = partRepository.getById(id);
        if (part == null) {
            System.out.println("Part not found!");
            return;
        }

        System.out.println("New Name (current: " + part.getName() + "):");
        part.setName(Helper.getStringFromUser());

        System.out.println("New Description (current: " + part.getDescription() + "):");
        part.setDescription(Helper.getStringFromUser());

        System.out.println("New Price (current: " + part.getPrice() + "):");
        part.setPrice(Helper.getDoubleFromUser());

        System.out.println("New Quantity (current: " + part.getQuantity() + "):");
        part.setQuantity(Helper.getIntFromUser());

        partRepository.save(part);
        System.out.println("Part updated successfully!");
    }
}
