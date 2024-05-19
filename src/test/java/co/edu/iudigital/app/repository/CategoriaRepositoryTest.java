package co.edu.iudigital.app.repository;

import co.edu.iudigital.app.model.Categoria;
import co.edu.iudigital.app.util.ObjectUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DataJpaTest
class CategoriaRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    @Transactional
    @DisplayName("giveCategoria_whenGet_thenReturnCategorias")
    void giveCategoria_whenGet_thenReturnCategorias() {

        // Given
        Categoria categoria = ObjectUtils.getCategoria();
        testEntityManager.merge(categoria);
        testEntityManager.flush();

        categoria.setId(null);
        categoria.setCreatedAt(null);
        categoria.setUpdatedAt(null);
        categoria.setNombre("categoria2");
        categoria.setDescripcion("categoria2");

        testEntityManager.persistAndFlush(categoria);

         // When
        List<Categoria> categorias = categoriaRepository.findAll();

        // Then
        Assertions.assertThat(categorias).isNotEmpty();
        org.junit.jupiter.api.Assertions.assertEquals(categorias.get(0).getNombre(), "categoria1");
        org.junit.jupiter.api.Assertions.assertEquals(categorias.get(1).getNombre(), "categoria2");
    }
}