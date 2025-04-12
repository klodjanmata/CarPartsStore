//package Test;
//
//import Entity.Part;
//import Repository.PartRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//public class PartServiceTest {
//
//    private PartRepository partRepository;
//
//    @BeforeEach
//    public void setup() {
//        partRepository = new PartRepository();
//    }
//
//    @Test
//    public void testSaveAndFindPart() {
//        Part part = new Part();
//        part.setName("Test Part");
//        part.setDescription("JUnit Description");
//        part.setPrice(10.0);
//        part.setQuantity(5);
//        partRepository.save(part);
//
//        List<Part> parts = partRepository.findAll();
//        Assertions.assertFalse(parts.isEmpty());
//        Assertions.assertTrue(parts.stream().anyMatch(p -> p.getName().equals("Test Part")));
//    }
//}
//
