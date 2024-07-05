package ms.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long idEmpleado;

    @Column(name = "nombre")
    private String nombre;


    @Column(name = "apellido")
    private String apellido;


    @Column(name = "puesto")
    private String puesto;


    @Column(name = "salario")
    private Double salario;


    @Column(name = "fecha_contratacion")
    private String fechaContratacion;

}
