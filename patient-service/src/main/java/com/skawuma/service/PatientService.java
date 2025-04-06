package com.skawuma.service;

import com.skawuma.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author samuelkawuma
 * @package com.skawuma.service
 * @project Patient-Managemet-System
 * @date 4/5/25
 */
@Service
public class PatientService {


    private PatientRepository patientRepository;
    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
}

