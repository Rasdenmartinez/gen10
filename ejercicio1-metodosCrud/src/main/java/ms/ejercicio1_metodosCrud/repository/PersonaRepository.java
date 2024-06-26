package ms.ejercicio1_metodosCrud.repository;

import ms.ejercicio1_metodosCrud.entity.Persona;
import ms.ejercicio1_metodosCrud.response.PersonaResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
List<Persona> findByNombreContainingIgnoreCase(String name);
List<Persona> findByEdadGreaterThanEqual(Byte edad);

@Query(value = "select p.nombre, p.direccion, d.m2  from persona p\n" +
        "inner join departamento d  on p.id =d.id where p.nombre like %:name% ",nativeQuery = true)
    List<Object[]> personaResponse(String name);
}
