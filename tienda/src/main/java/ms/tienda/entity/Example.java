package ms.tienda.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "example")
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

}
