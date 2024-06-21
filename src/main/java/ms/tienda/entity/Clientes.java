package ms.tienda.entity;

import jakarta.persistence.*;

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

    public Clientes(){
        //constructor vacio
    }

    public Clientes(Long Id, String nombre, String apellido, String direccion, String mail, String telefono) {
        this.Id = Id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.mail = mail;
        this.telefono = telefono;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
