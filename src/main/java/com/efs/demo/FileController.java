package com.efs.demo;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class FileController {
    private static final String EFS_PATH = "/mnt/efs";
//    @PostMapping(value="/upload", consumes =  MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//        String filePath = EFS_PATH + "/" + file.getOriginalFilename();
//        Files.write(Paths.get(filePath), file.getBytes());
//
//        return "File uploaded successfully to EFS: " + file.getOriginalFilename();
//    }
//    @GetMapping("/files")
//    public List<String> listFiles() throws IOException {
//        // Stream the list of file names in the EFS directory
//        return Files.list(Paths.get(EFS_PATH))
//                .map(path -> path.getFileName().toString())
//                .collect(Collectors.toList());
//    }
    @GetMapping("/getSecrets")
    public Map<String, String> getEnvVariables() {
        Map<String, String> env = new HashMap<>();
        env.put("DB Username", System.getenv("DB_USERNAME"));
        env.put("DB password", System.getenv("DB_PASSWORD"));

        return env;
    }
}
