
package Service;

import Entity.Supplier;
import Repository.SupplierRepository;
import Util.Helper;

import java.util.HashMap;

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





    }



