package co.edu.iudigital.app.controller;

import co.edu.iudigital.app.dto.categoria.CategoriaResponse;
import co.edu.iudigital.app.mapper.CategoriaMapper;
import co.edu.iudigital.app.service.CategoriaService;
import co.edu.iudigital.app.util.ObjectUtils;
import static org.assertj.core.api.BDDAssertions.then;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class CategoriaControllerTest {


    @InjectMocks
    private CategoriaController categoriaController;


    @Mock
    private CategoriaService categoriaService;

    @Mock
    private CategoriaMapper categoriaMapper;

    @Test
    void index() {
        // Given
        when(categoriaMapper.toCategoriaResponses(any())).thenReturn(ObjectUtils.getCategoriaResponses());

        // When
        ResponseEntity<List<CategoriaResponse>> actual = categoriaController.index();

        // Then
        then(actual.getBody()).isNotEmpty();
        then(actual.getBody().get(0).getId()).isEqualTo(1L);
        then(actual.getBody().get(0).getNombre()).isEqualTo("categoria");
    }

    @Test
    void save() throws JsonProcessingException {
        // Given
        when(categoriaMapper.toCategoriaResponse(any())).thenReturn(ObjectUtils.getCategoriaResponse());

        // When
        ResponseEntity<CategoriaResponse> actual = categoriaController.save(ObjectUtils.getCategoriaRequest());

        // Then
        then(actual.getBody()).isNotNull();
        then(actual.getBody().getNombre()).isEqualTo("categoria");
        then(actual.getBody().getDescripcion()).isEqualTo("categoria");
    }

    @Test
    void downloadFile() {
    }
}