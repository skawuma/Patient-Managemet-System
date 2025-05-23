package com.skawuma.repository;

import com.skawuma.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author samuelkawuma
 * @package com.skawuma.repository
 * @project Patient-Managemet-System
 * @date 4/5/25
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    boolean existsByEmail(String email);
    // METHOD IGNORES THE EMAIL WE HAVE AND UPDATING
    boolean existsByEmailAndIdNot(String email, UUID id);

    Page<Patient> findByNameContainingIgnoreCase(String name, Pageable pageable);
}

