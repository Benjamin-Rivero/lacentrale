package fr.hb.lacentrale.repository;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.hb.lacentrale.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}