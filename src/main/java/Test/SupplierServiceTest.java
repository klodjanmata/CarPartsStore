//package Test;
//
//import Entity.Supplier;
//import Repository.SupplierRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//public class SupplierServiceTest {
//
//    private SupplierRepository supplierRepository;
//
//    @BeforeEach
//    public void setup() {
//        supplierRepository = new SupplierRepository();
//    }
//
//    @Test
//    public void testAddSupplier() {
//        Supplier supplier = new Supplier();
//        supplier.setName("Test Supplier");
//        supplier.setEmail("test@supplier.com");
//        supplier.setPhone("123456789");
//
//        supplierRepository.save(supplier);
//
//        List<Supplier> all = supplierRepository.findAll();
//        Assertions.assertTrue(all.stream().anyMatch(s -> s.getName().equals("Test Supplier")));
//    }
//}
//
