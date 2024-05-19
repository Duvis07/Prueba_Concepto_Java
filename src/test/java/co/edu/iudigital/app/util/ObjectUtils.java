package co.edu.iudigital.app.util;

import co.edu.iudigital.app.dto.categoria.CategoriaRequest;
import co.edu.iudigital.app.dto.categoria.CategoriaResponse;
import co.edu.iudigital.app.model.Categoria;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class ObjectUtils {


    public static List<CategoriaResponse> getCategoriaResponses() {
        return Collections.singletonList(getCategoriaResponse() );
    }

    public static CategoriaResponse getCategoriaResponse() {
        return CategoriaResponse.builder()
                .id(1L)
                .nombre("categoria")
                .descripcion("categoria")
                .createdAt(LocalDateTime.of(2024, 1, 1, 0, 0))
                .updatedAt(LocalDateTime.of(2024, 1, 1, 0, 0))
                .build();
    }

    public static CategoriaRequest getCategoriaRequest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CategoriaRequest categoriaRequest = objectMapper.readValue(JsonUtil.BODY_SAVE_CATEGORIA, CategoriaRequest.class);
        return categoriaRequest;
    }

    public static Categoria getCategoria() {
        Categoria categoria = new Categoria();
        categoria.setNombre("categoria1");
        categoria.setDescripcion("categoria1");
        return categoria;
    }
}
