package Service;

import Entity.Part;
import Repository.PartRepository;
import Repository.SupplierRepository;
import Util.Helper;

import java.util.HashMap;
import java.util.List;

public class PartService {
    private final PartRepository partRepository = new PartRepository();
    private final SupplierRepository supplierRepository = new SupplierRepository();

    public void addPart() {
        HashMap<String, Part> lecturers = new HashMap<>();
        Part p = new Part();
        System.out.print("Name: ");
        p.setName(Helper.getStringFromUser());

        System.out.print("Description:");
        p.setDescription(Helper.getStringFromUser());

        System.out.print("Price:");
        p.setPrice(Helper.getDoubleFromUser());

        System.out.print("Quantity ");
        p.setQuantity(Helper.getIntFromUser());
        System.out.print("Supplier ID: ");
        p.setSupplier(supplierRepository.getById(Helper.getIntFromUser()));
        partRepository.save(p);
    }

    public void deletePart(){
        System.out.print("Part ID: ");
        Part p = partRepository.getById(Helper.getIntFromUser());
        partRepository.delete(p);
        System.out.println("Part Deleted!");
    }

    public void editPart(){
        System.out.print("Part ID: ");
        Part p = partRepository.getById(Helper.getIntFromUser());
        System.out.print("Name: ");
        p.setName(Helper.getStringFromUser());

        System.out.print("Description:");
        p.setDescription(Helper.getStringFromUser());

        System.out.print("Price:");
        p.setPrice(Helper.getDoubleFromUser());

        System.out.print("Quantity ");
        p.setQuantity(Helper.getIntFromUser());
        System.out.print("Supplier ID: ");
        p.setSupplier(supplierRepository.getById(Helper.getIntFromUser()));
        partRepository.save(p);
    }
    public void printAllParts() {
        List<Part> parts = partRepository.findAll();
        for (Part p: parts){
            System.out.println(p);
        }
    }


}