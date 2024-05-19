package co.edu.iudigital.app.controller;

import co.edu.iudigital.app.dto.categoria.CategoriaRequest;
import co.edu.iudigital.app.dto.categoria.CategoriaResponse;
import co.edu.iudigital.app.mapper.CategoriaMapper;
import co.edu.iudigital.app.service.CategoriaService;
import co.edu.iudigital.app.service.GenerarReporteService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/categorias")
@Slf4j
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private GenerarReporteService generarReporteService;

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> index() {
        log.info("Getting all categorias");
        return ResponseEntity.ok(
                categoriaMapper.toCategoriaResponses(
                        categoriaService.getAll()
                )
        );
    }

    @PostMapping
    public ResponseEntity<CategoriaResponse> save(
            @RequestBody @Valid CategoriaRequest request
    ) {
        log.info("Saving categoria");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        categoriaMapper.toCategoriaResponse(
                                categoriaService.save(request)
                        )
                );
    }

    @GetMapping("/xlsx")
    public ResponseEntity<byte[]> downloadFile() throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.setContentDispositionFormData("attachment", "categorias.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .body(generarReporteService.exportToExcel().toByteArray());
    }
}
