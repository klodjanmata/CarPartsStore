package Util;

import Entity.Part;


import java.io.*;
import java.util.List;

public class PartsCSVUtil {
    private static final String PARTFILE = "Files\\Import\\Parts.csv";
    private static final String SEPARATOR = ",";

    public static void readFromFile(List<Part>partList){
        String header = "ID" + SEPARATOR +
                "Name" + SEPARATOR +
                "Description" + SEPARATOR +
                "Price" + SEPARATOR +
                "Quantity" + SEPARATOR +
                "Supplier";

        try (BufferedReader reader = new BufferedReader(new FileReader(PARTFILE))){
            reader.read(header);
            for (Part p : partList){
                reader.readLine();
                reader.read(p.setId() + SEPARATOR);
               reader.read(p.getName() + SEPARATOR);
                reader.read(p.setDescription() + SEPARATOR);
                reader.read(p.setPrice() + SEPARATOR);
                reader.read(p.setQuantity() + SEPARATOR);
               reader.read(p.setSupplier() + SEPARATOR);
               reader.read(p.addPart().toString());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void writeToFile(List<Part> partList) {
        String header = "ID" + SEPARATOR +
                "Name" + SEPARATOR +
                "Description" + SEPARATOR +
                "Price" + SEPARATOR +
                "Quantity" + SEPARATOR +
                "Supplier";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PARTFILE))) {
            writer.write(header);
            for (Part p : partList) {
                writer.newLine();
                writer.write(p.setId() + SEPARATOR);
                writer.write(p.setName() + SEPARATOR);
                writer.write(p.setDescription() + SEPARATOR);
                writer.write(p.setPrice() + SEPARATOR);
                writer.write(p.setQuantity() + SEPARATOR);
                writer.write(p.getSupplier() + SEPARATOR);
                writer.write(p.addPart().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
