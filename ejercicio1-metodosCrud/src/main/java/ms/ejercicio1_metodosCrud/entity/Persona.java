package ms.ejercicio1_metodosCrud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name= "nombre")
    private String nombre;
    @Column(name= "direccion")
    private String direccion;
    @Column(name= "edad")
    private Integer edad;
    @Column(name= "id_departamento")
    private Integer id_departamento;

    public Persona() {
    }

    public Persona(Long id, String nombre, String direccion, Integer edad, Integer id_departamento) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        this.id_departamento = id_departamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }
}
