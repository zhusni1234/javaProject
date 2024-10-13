package com.example.sash.admin;

import com.example.sash.model.GlampingPackage;
import com.example.sash.service.GlampingPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/glamping-packages")
public class GlampingPackageController {

    @Autowired
    private GlampingPackageService glampingPackageService;

    // Only Admins should access package management endpoints
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<GlampingPackage> getAllPackages() {
        return glampingPackageService.getAllPackages();
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public GlampingPackage addPackage(@RequestBody GlampingPackage glampingPackage) {
        // Ensure that availableDates is handled (if provided)
        if (glampingPackage.getAvailableDates() == null || glampingPackage.getAvailableDates().isEmpty()) {
            // Optionally, initialize an empty list or handle this scenario
            glampingPackage.setAvailableDates(List.of()); // Sets to an empty list if not provided
        }
        return glampingPackageService.addPackage(glampingPackage);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<GlampingPackage> updatePackage(@PathVariable String id, @RequestBody GlampingPackage updatedPackage) {
        Optional<GlampingPackage> existingPackage = glampingPackageService.findById(id);

        if (existingPackage.isPresent()) {
            GlampingPackage packageToUpdate = existingPackage.get();
            packageToUpdate.setName(updatedPackage.getName());
            packageToUpdate.setPrice(updatedPackage.getPrice());
            packageToUpdate.setImages(updatedPackage.getImages());
            packageToUpdate.setAvailableDates(updatedPackage.getAvailableDates());  // Update availableDates

            glampingPackageService.save(packageToUpdate);
            return ResponseEntity.ok(packageToUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackage(@PathVariable String id) {
        glampingPackageService.deletePackage(id);
        return ResponseEntity.ok().build();
    }
}
