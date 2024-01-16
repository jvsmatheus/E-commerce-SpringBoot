package br.com.matheus.naturaSSP.services.upload;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class UploadServiceImp implements IUploadService{

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            /*
             * Copiar o arquivo recebido pela requisição
             * para uma pasta definida e retornar o cami
             * nho dele, caso de erro retornar NULL
             */
            System.out.println("DEBUG: " + file.getOriginalFilename());
            String pathDir = "C:\\Users\\Matheus\\OneDrive\\Documentos\\images";
            Path pathImg = Paths.get(pathDir + File.separator + file.getOriginalFilename());
            Files.copy(file.getInputStream(), pathImg, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("DEBUG: Arquivo copiado...");
            return pathImg.toString();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
