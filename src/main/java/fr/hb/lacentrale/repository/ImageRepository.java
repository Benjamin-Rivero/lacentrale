package fr.hb.lacentrale.repository;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.hb.lacentrale.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
}