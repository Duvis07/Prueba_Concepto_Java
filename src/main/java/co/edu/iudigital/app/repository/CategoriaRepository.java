package co.edu.iudigital.app.repository;

import co.edu.iudigital.app.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository
        extends JpaRepository<Categoria, Long> {

    Categoria findByNombre(String nombre);
}
