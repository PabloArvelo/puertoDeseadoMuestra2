package com.puertodeseado.controladores.anticiporetorno;


import com.docraptor.*;
import com.docraptor.Doc.DocumentTypeEnum;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
@RequestMapping("/GenerarPDFs")
public class GenerarPDFRecibosControlador {
    private final String apiKey = "wW1t-q0DzCOENdxYKWOh";

    @PostMapping
    public ResponseEntity<Resource> generatePdfs(@RequestBody Map<String, List<String>> request) throws IOException {
        List<String> recibos = request.get("recibos");

        ByteArrayOutputStream zipOutputStream = new ByteArrayOutputStream();
        try (ZipOutputStream zos = new ZipOutputStream(zipOutputStream)) {
            int counter = 1;
            for (String htmlContent : recibos) {
                // Llamar a DocRaptor para convertir HTML a PDF
                byte[] pdfBytes = convertHtmlToPdf(htmlContent);


                // Agregar el PDF al archivo ZIP
                ZipEntry entry = new ZipEntry("recibo_" + counter++ + ".pdf");
                zos.putNextEntry(entry);
                zos.write(pdfBytes);
                zos.closeEntry();
            }
        }

        // Configurar la respuesta como un archivo ZIP
        ByteArrayResource resource = new ByteArrayResource(zipOutputStream.toByteArray());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=recibos.zip");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(zipOutputStream.size())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    private byte[] convertHtmlToPdf(String htmlContent) {
        // Crear cliente de DocRaptor
        DocApi docApi = new DocApi();
        ApiClient client = docApi.getApiClient();
        client.setUsername(apiKey);  // Configurar la clave API

        // Crear un objeto Document para los parámetros de la solicitud
        Doc document = new Doc();

        document.setDocumentContent(htmlContent);  // Establecer el contenido HTML
        document.setName("recibo.pdf");  // Nombre del archivo PDF
        document.setTest(true);  // Cambiar a false para producción
        //document.setDocumentType("pdf");  // Tipo de documento (PDF)
        document.setDocumentType(DocumentTypeEnum.PDF);  // Tipo de documento (PDF)

        // el navegador por defecto, usa screen para visualizar y docraptor, print
        // seteo screen para que se vea como en el navegador
        PrinceOptions princeOptions = new PrinceOptions();
        princeOptions.setMedia("screen");
        document.setPrinceOptions(princeOptions);


        try {
            // Llamar a la API para generar el documento PDF
            byte[] pdfBytes = docApi.createDoc(document);

            // Retornar el archivo PDF generado
            return pdfBytes;
        } catch (ApiException e) {
            // Manejar cualquier excepción de la API
            throw new RuntimeException("Error al contactar con la API de DocRaptor: " + e.getMessage());
        }
    }

}



