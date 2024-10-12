package com.example.sash.admin;

import com.example.sash.model.GlampingPackage;
import com.example.sash.service.GlampingPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/glamping-packages")
public class GlampingPackageController {

    @Autowired
    private GlampingPackageService glampingPackageService;

    @GetMapping
    public List<GlampingPackage> getAllPackages() {
        return glampingPackageService.getAllPackages();
    }

    @PostMapping
    public GlampingPackage addPackage(@RequestBody GlampingPackage glampingPackage) {
        return glampingPackageService.addPackage(glampingPackage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlampingPackage> updatePackage(@PathVariable String id, @RequestBody GlampingPackage updatedPackage) {
        return glampingPackageService.updatePackage(id, updatedPackage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable String id) {
        glampingPackageService.deletePackage(id);
        return ResponseEntity.ok().build();
    }
}
