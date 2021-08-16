package com.example.demo.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;
import java.util.Optional;

@Repository

public interface SupplierRepository
        extends JpaRepository<Supplier, Long> {
    //@Override
    //This translates to a sql statement like SELECT * FROM supplier
    //WHERE Id = ?
    @Query("SELECT s FROM Supplier s WHERE s.email = ?1")
    Optional<Supplier> findSupplierByEmail(String email);
}
