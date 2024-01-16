package br.com.matheus.naturaSSP.services.upload;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface IUploadService {

    String uploadFile(MultipartFile file);
}
