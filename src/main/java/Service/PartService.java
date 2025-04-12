package Service;

import Entity.Part;
import Repository.PartRepository;
import Repository.SupplierRepository;
import Util.Helper;

public class PartService {
    private final PartRepository partRepository = new PartRepository();
    private final SupplierRepository supplierRepository = new SupplierRepository();
    public void addPart(){
        System.out.println("Adding a new part!");
        Part p = new Part();
        System.out.println("Write Name:");
        p.setName(Helper.getStringFromUser());

        System.out.println("Write description");
       p.setDescription(Helper.getStringFromUser());

        System.out.println("Put the Price ");
        p.setPrice(Helper.getFloatFromUser());

        System.out.println("Put the quantity");
        p.setQuantity(Helper.getIntFromUser());

        System.out.println("Set Supplier Id");
        p.setSupplier(supplierRepository.getById(Helper.getIntFromUser()));
    }
     public void printAllParts(){
         System.out.println();
     }
}

