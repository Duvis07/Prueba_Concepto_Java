package co.edu.iudigital.app.service;

import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public interface GenerarReporteService {

    ByteArrayOutputStream exportToExcel() throws IOException;
}
