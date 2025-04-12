package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Part")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Override
    public String toString() {
        return

                " " + id +"\t"+
                " " + name + "\t" +
                " " + description + "\t" +
                " " + price + "\t"+
                " " + quantity + "\t"+
                " " + supplier +"\t";

    }
}
