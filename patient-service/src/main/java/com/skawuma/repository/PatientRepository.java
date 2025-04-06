package com.skawuma.repository;

import com.skawuma.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author samuelkawuma
 * @package com.skawuma.repository
 * @project Patient-Managemet-System
 * @date 4/5/25
 */
public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
