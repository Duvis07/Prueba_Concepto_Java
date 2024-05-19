package co.edu.iudigital.app.service.impl;

import co.edu.iudigital.app.model.Categoria;
import co.edu.iudigital.app.service.CategoriaService;
import co.edu.iudigital.app.service.GenerarReporteService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class GenerateReportesServiceImpl implements GenerarReporteService {

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public ByteArrayOutputStream exportToExcel() throws IOException {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Hoja1");

        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Id");
        row.createCell(1).setCellValue("Nombre");
        row.createCell(2).setCellValue("Descripcion");
        row.createCell(3).setCellValue("Creado");

        List<Categoria> categoriaList = categoriaService.getAll();

        int i = 1;
        for(Categoria c: categoriaList) {
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(c.getId());
            row.createCell(1).setCellValue(c.getNombre());
            row.createCell(2).setCellValue(c.getDescripcion());
            row.createCell(3).setCellValue(c.getCreatedAt().toString());
            i++;
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        workbook.write(stream);

        return stream;
    }

}
