package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "SaleTransaction")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SaleTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "part_id")
    private Part part;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "sale_Date")
    private Date saleDate;
    @Column(name = "total_Price")
    private double totalPrice;

}
