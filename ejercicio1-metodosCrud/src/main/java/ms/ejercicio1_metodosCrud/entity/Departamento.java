package ms.ejercicio1_metodosCrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//identificador decapa y mapeo de base de datos ORM
@Data//genera automaticamente los getter y setter
@AllArgsConstructor//genera el constructor con todos los atributos
@NoArgsConstructor//genera constructor sin atributos
@Table(name = "departamento")//referencia con nombre la tabla
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "m2")
    private Double m2;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "is_active")
    private Boolean isActive;
}
