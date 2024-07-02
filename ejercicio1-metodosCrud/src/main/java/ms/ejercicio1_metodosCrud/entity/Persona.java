package ms.ejercicio1_metodosCrud.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "edad")
    private Byte edad;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento idDepartamento;

    @Column(name = "is_active")
    private Boolean isActive;
}
