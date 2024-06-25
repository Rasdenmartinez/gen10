package ms.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Clientes {
    @Id //para decir que la columna id es la id primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para mencionar que es autoincrementable
    @Column(name="Id") //para especificar que columna va con el atributo
    private Long Id;

    @Column(name="nombre")
    private String nombre;

    @Column (name = "apellido")
    private String apellido;

    @Column (name = "direccion")
    private String direccion;

    @Column (name = "correo_electronico")
    private String mail;

    @Column (name = "telefono")
    private String telefono;
<<<<<<< HEAD

=======
>>>>>>> 6772ff397828f79a0e1d834e1c95b5383c3a04a5
}
