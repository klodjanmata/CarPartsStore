package Service;

import Entity.Part;
import Repository.PartRepository;
import Repository.SupplierRepository;
import Util.Helper;

import java.util.ArrayList;
import java.util.HashMap;

public class PartService {

    private HashMap<String, Part> parts;


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
        p.setPrice(Helper.getDoubleFromUser());

        System.out.println("Put the quantity");
        p.setQuantity(Helper.getIntFromUser());

        System.out.println("Set Supplier Id");
        p.setSupplier(supplierRepository.getById(Helper.getIntFromUser()));
        partRepository.save(p);
    }
     public void printAllParts(){
         System.out.println("   ID \tName\tdescription \tprice \tquantity \tsuplier_id");
         if (parts!=null){
             parts.values().forEach(System.out::println);
         }
     }


    public boolean containsPartById(String id){
        if(parts.get(id) == null){
            return false;
        }else{
            return true;
        }
    }

    private HashMap <String ,Part>createTestPart(){
        HashMap<String, Part> lecturers = new HashMap<>();
        Part p = new Part();
        p.setId(2);
        p.setName("Timon");
        p.setDescription("Mercedes-Benz  2020");
        p.setPrice(300);
        p.setQuantity(2);
        p.setSupplier( );
//        parts.put(p.getId(), p);
//        return parts;
    }


}
