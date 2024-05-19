package co.edu.iudigital.app.controller;

import co.edu.iudigital.app.dto.categoria.CategoriaRequest;
import co.edu.iudigital.app.dto.categoria.CategoriaResponse;
import co.edu.iudigital.app.util.ObjectUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.BDDAssertions.then;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoriaControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void save_shouldCreateSuccessful() throws JsonProcessingException {

        // Given
        CategoriaRequest categoriaRequest = ObjectUtils.getCategoriaRequest();
        HttpStatus expected = HttpStatus.CREATED;

        // When
        ResponseEntity<CategoriaResponse> actual =
                testRestTemplate.postForEntity(
                        "http://localhost:"+port+"/categorias",
                        categoriaRequest,
                        CategoriaResponse.class
                );

        // Then
        then(actual.getStatusCode()).isEqualTo(expected);
        //...
    }

    @Test
    void index_shouldGetSuccessful() {
        // Given
        HttpStatus expected = HttpStatus.OK;

        // When
        ResponseEntity<CategoriaResponse[]> actual =
                testRestTemplate.getForEntity("http://localhost:"+port+"/categorias", CategoriaResponse[].class);

        // Then
        then(actual.getStatusCode()).isEqualTo(expected);
        //...
    }

}
