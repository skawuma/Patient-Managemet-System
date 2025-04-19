package com.skawuma.service;

import com.skawuma.dto.PatientRequestDTO;
import com.skawuma.dto.PatientResponseDTO;
import com.skawuma.exception.EmailAlreadyExistsException;
import com.skawuma.exception.PatientNotFoundException;
import com.skawuma.mapper.PatientMapper;
import com.skawuma.model.Patient;
import com.skawuma.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * @author samuelkawuma
 * @package com.skawuma.service
 * @project Patient-Managemet-System
 * @date 4/5/25
 */
@Service
public class PatientService {


    private final PatientRepository patientRepository;
    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


        public List<PatientResponseDTO> getPatients() {
            List<Patient> patients = patientRepository.findAll();

            return patients.stream().map(PatientMapper::toDTO).toList();

    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            throw new EmailAlreadyExistsException(
                    "A patient with this email " + "already exists"
                            + patientRequestDTO.getEmail());
        }

        Patient newPatient = patientRepository.save(
                PatientMapper.toModel(patientRequestDTO));

//        billingServiceGrpcClient.createBillingAccount(newPatient.getId().toString(),
//                newPatient.getName(), newPatient.getEmail());
//
//        kafkaProducer.sendEvent(newPatient);

        return PatientMapper.toDTO(newPatient);
    }

    public PatientResponseDTO updatePatient(UUID id,
                                            PatientRequestDTO patientRequestDTO) {

        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new PatientNotFoundException("Patient not found with ID: " + id));

        if (patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(),
                id)) {
            throw new EmailAlreadyExistsException(
                    "A patient with this email " + "already exists"
                            + patientRequestDTO.getEmail());
        }

        patient.setName(patientRequestDTO.getName());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        Patient updatedPatient = patientRepository.save(patient);
        return PatientMapper.toDTO(updatedPatient);
    }


    public void deletePatient(UUID id) {
        patientRepository.deleteById(id);
    }
}

