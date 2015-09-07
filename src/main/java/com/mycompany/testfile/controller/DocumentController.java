/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testfile.controller;

import com.mycompany.testfile.model.Document;
import com.mycompany.testfile.model.DocFile;
import com.mycompany.testfile.repo.DocFileRepo;
import com.mycompany.testfile.repo.DocumentRepo;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

/**
 *
 * @author UMBOON
 */
@RestController
public class DocumentController {
    
    @Autowired
     private DocumentRepo documentRepo;
    @Autowired
    private DocFileRepo docFileRepo;
    
     private DocFile docFile = new DocFile();
     
    @RequestMapping(value = "/savedocument",method = RequestMethod.POST)
    private void saveDocument(@RequestBody Document document){
        System.out.println("---------------------------------------------------->"+docFile.getNameFile());
        document.setFile(docFile);
        documentRepo.save(document);
        docFile = new DocFile();
    }
    
    @RequestMapping(value = "/savedocfile" , method = RequestMethod.POST)
   public void saveDocFile(MultipartRequest multipartRequest){
       // docFile.setContent(multipartRequest.getFile("file"));
   }
    
    @RequestMapping(value = "/deletedocument",method = RequestMethod.POST)
    private void deleteDocument(@RequestBody Document document){
        documentRepo.delete(document);
    }
    
    @RequestMapping(value = "/getdocument",method = RequestMethod.GET)
    private Page<Document> getDocument (Pageable pageable){
        return documentRepo.findAll(pageable);
    }
    
    
     
//    @RequestMapping(value = "/dowloaddocument" , method = RequestMethod.POST)
//    private void Dowload(@RequestBody DocFile file){
//        System.out.println("------------------------------------------------>"+file.getId());
//        System.out.println("------------------------------------------------>"+file.getContent());
//        System.out.println("------------------------------------------------>"+file.getNameFile());
//    ResponseEntity<InputStreamResource> body = ResponseEntity.ok().contentLength(file.getContent().length)
//                .contentType(MediaType.parseMediaType(file.getType()))
//                .header("Content-Disposition", "attachment; filename=\""+ file.getNameFile()+"\"")
//                .body(new InputStreamResource(new ByteArrayInputStream(file.getContent())));
//    }
    
}
