package ms.ejercicio1_metodosCrud.repository;

import ms.ejercicio1_metodosCrud.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
