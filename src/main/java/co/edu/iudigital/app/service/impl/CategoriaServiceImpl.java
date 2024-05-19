package co.edu.iudigital.app.service.impl;

import co.edu.iudigital.app.dto.categoria.CategoriaRequest;
import co.edu.iudigital.app.mapper.CategoriaMapper;
import co.edu.iudigital.app.model.Categoria;
import co.edu.iudigital.app.repository.CategoriaRepository;
import co.edu.iudigital.app.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Categoria> getAll() {
        return categoriaRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Categoria getByName(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }

    @Transactional(readOnly = true)
    @Override
    public Categoria getById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Categoria save(CategoriaRequest categoriaRequest) {
        Categoria categoria = categoriaMapper.toCategoria(categoriaRequest);
        return categoriaRepository.save(categoria);
    }

    @Transactional
    @Override
    public Categoria update(Long id, CategoriaRequest categoriaRequest) {
        Optional<Categoria> categoriaOptional =
                categoriaRepository.findById(id);
        if(categoriaOptional.isPresent()) {
            Categoria categoria = categoriaMapper.toCategoria(categoriaRequest);
            return categoriaRepository.save(categoria);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}
