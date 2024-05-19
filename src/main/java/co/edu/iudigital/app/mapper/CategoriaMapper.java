package co.edu.iudigital.app.mapper;

import co.edu.iudigital.app.dto.categoria.CategoriaRequest;
import co.edu.iudigital.app.dto.categoria.CategoriaResponse;
import co.edu.iudigital.app.model.Categoria;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoriaMapper {

    public Categoria toCategoria(CategoriaRequest categoriaRequest) {
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaRequest.getNombre());
        categoria.setDescripcion(categoriaRequest.getDescripcion());
        return categoria;
    }

    public CategoriaResponse toCategoriaResponse(Categoria categoria) {
        return CategoriaResponse.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .createdAt(categoria.getCreatedAt())
                .updatedAt(categoria.getUpdatedAt())
                .build();
    }

    public List<CategoriaResponse> toCategoriaResponses(List<Categoria> categorias) {
        return categorias.stream()
                .map(categoria -> toCategoriaResponse(categoria))
                .collect(Collectors.toList());
    }
}
