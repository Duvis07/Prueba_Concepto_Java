package co.edu.iudigital.app.dto.categoria;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CategoriaRequest implements Serializable {

    @NotNull(message = "Nombre requerido")
    String nombre;

    String descripcion;
}
