package Service;

import Entity.Part;
import Entity.SaleTransaction;
import Repository.PartRepository;
import Repository.SaleTransactionRepository;
import Util.Helper;

import java.util.Date;
import java.util.List;

public class SaleTransactionService {
    private final SaleTransactionRepository saleRepo = new SaleTransactionRepository();
    private final PartRepository partRepo = new PartRepository();

    public void sellPart() {
        System.out.println("Selling a part!");

        System.out.println("Enter Part ID:");
        int partId = Helper.getIntFromUser();
        Part part = partRepo.getById(partId);

        if (part == null) {
            System.out.println("Part not found.");
            return;
        }

        System.out.println("Enter Quantity:");
        int qty = Helper.getIntFromUser();

        if (part.getQuantity() < qty) {
            System.out.println("Not enough quantity in stock.");
            return;
        }

        SaleTransaction sale = new SaleTransaction();
        sale.setPart(part);
        sale.setQuantity(qty);
        sale.setSaleDate(new Date());
        sale.setTotalPrice(part.getPrice() * qty);

        part.setQuantity(part.getQuantity() - qty);

        partRepo.save(part);
        saleRepo.save(sale);

        System.out.println("Sale recorded successfully!");
    }

    public void viewSales() {
        List<SaleTransaction> sales = saleRepo.findAll();
        System.out.println("ID\tPart ID\tQuantity\tDate\tTotal Price");
        for (SaleTransaction s : sales) {
            System.out.printf("%d\t%d\t%d\t%s\t%.2f\n",
                    s.getId(), s.getPart().getId(), s.getQuantity(),
                    s.getSaleDate(), s.getTotalPrice());
        }
    }
}

