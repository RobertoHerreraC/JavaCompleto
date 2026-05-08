package __Proyectos._09_JobTrackAsincrona.util;

import __Proyectos._09_JobTrackAsincrona.exception.BusinessException;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReportFileWriter {
    private final Path basePath = Path.of("exports");
    public void write(String fileName, String content){
        try{
            Files.createDirectories(basePath);

            Path filePath = basePath.resolve(fileName);
            try(BufferedWriter write = Files.newBufferedWriter(
                    filePath,
                    StandardCharsets.UTF_8
            )){
                write.write(content);
            }
            System.out.println("Reporte exportado en: "+filePath.toAbsolutePath());
        }catch (Exception e){
            throw new BusinessException("No se pudo exportar el reporte: "+e.getMessage());
        }
    }
}
