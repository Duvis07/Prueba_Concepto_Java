package co.edu.iudigital.app.service;

import co.edu.iudigital.app.dto.categoria.CategoriaRequest;
import co.edu.iudigital.app.model.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> getAll();

    Categoria getByName(String nombre);

    Categoria getById(Long id);

    Categoria save(CategoriaRequest categoriaRequest);

    Categoria update(Long id, CategoriaRequest categoriaRequest);

    void deleteById(Long id);
}
