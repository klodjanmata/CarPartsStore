package Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Supplier")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class    Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private Double phone;
    @OneToMany(mappedBy = "supplier")
    private List<Part>parts;
}
