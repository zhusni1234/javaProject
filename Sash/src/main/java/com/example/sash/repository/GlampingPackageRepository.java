package com.example.sash.repository;

import com.example.sash.model.GlampingPackage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlampingPackageRepository extends MongoRepository<GlampingPackage, String> {
}
