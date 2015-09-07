/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testfile.repo;

import com.mycompany.testfile.model.DocFile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author UMBOON
 */
public interface DocFileRepo extends JpaRepository<DocFile, Integer>{
    
}
