package com.example.sash.service;

import com.example.sash.model.GlampingPackage;
import com.example.sash.repository.GlampingPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GlampingPackageService {

    @Autowired
    private GlampingPackageRepository glampingPackageRepository;

    public List<GlampingPackage> getAllPackages() {
        return glampingPackageRepository.findAll();
    }

    public GlampingPackage addPackage(GlampingPackage glampingPackage) {
        return glampingPackageRepository.save(glampingPackage);
    }

    public ResponseEntity<GlampingPackage> updatePackage(String id, GlampingPackage updatedPackage) {
        Optional<GlampingPackage> existingPackage = glampingPackageRepository.findById(id);
        if (existingPackage.isPresent()) {
            GlampingPackage packageToUpdate = existingPackage.get();
            packageToUpdate.setName(updatedPackage.getName());
            packageToUpdate.setPrice(updatedPackage.getPrice());
            packageToUpdate.setImages(updatedPackage.getImages());
            return ResponseEntity.ok(glampingPackageRepository.save(packageToUpdate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deletePackage(String id) {
        glampingPackageRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public Optional<GlampingPackage> findById(String id) {
        return glampingPackageRepository.findById(id);
    }
}
