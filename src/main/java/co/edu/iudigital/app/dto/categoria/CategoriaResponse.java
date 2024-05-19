package co.edu.iudigital.app.dto.categoria;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CategoriaResponse implements Serializable {

    Long id;

    String nombre;

    String descripcion;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
