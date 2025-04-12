
package Service;

import Entity.Part;
import Entity.Supplier;
import Repository.SupplierRepository;
import Util.Helper;

import java.util.HashMap;
import java.util.List;

public class SupplierService {
    private final SupplierRepository supplierRepository = new SupplierRepository();



    public void addSupplier(){
        System.out.println("Adding a new Supplier!");
        Supplier s = new Supplier();

        System.out.println("Write Supplier Name:");
        s.setName(Helper.getStringFromUser());

        System.out.println("Write Supplier Email");
        s.setEmail(Helper.getStringFromUser());

        System.out.println("Write phone number:");
        s.setPhone(Helper.getDoubleFromUser());

    }


    public void deleteSupplier(){
        System.out.print("Supplier ID ");
        Supplier s = supplierRepository.getById(Helper.getIntFromUser());
        supplierRepository.delete(s);
        System.out.println("Supplier Deleted!");
    }

    public void editSupplier(){
        System.out.print("Enter Supplier ID: ");
        Supplier s = supplierRepository.getById(Helper.getIntFromUser());
        if(s == null){
            System.out.println("Supplier does not exist!");
            return;
        }
        System.out.println("Write Supplier Name:");
        s.setName(Helper.getStringFromUser());

        System.out.println("Write Supplier Email");
        s.setEmail(Helper.getStringFromUser());

        System.out.println("Write phone number:");
        s.setPhone(Helper.getDoubleFromUser());

        supplierRepository.save(s);
    }

    public void printAllSuppliers(){
        System.out.println("Suppliers");
        List<Supplier> supplier =supplierRepository.findAll();
        for(Supplier s :supplier){
            System.out.println(s);
        }
    }


    }



