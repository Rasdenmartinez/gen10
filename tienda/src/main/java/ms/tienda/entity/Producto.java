package ms.tienda.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//identificador de capa y mapeo de base de datos ORM
@Data//genera automaticamente los getter y setter
@AllArgsConstructor//genera el constructor con todos los atributos
@NoArgsConstructor//genera constructor sin atributos
@Table(name = "productos")//referencia con nombre la tabla
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion_producto")
    private String descripcion_producto;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "id_proveedor")
    private Long id_proveedor;
    @Column(name = "is_active")
    private Boolean isActive;

}