package com.skawuma.controller;

import com.skawuma.dto.PatientRequestDTO;
import com.skawuma.dto.PatientResponseDTO;
import com.skawuma.dto.validators.CreatePatientValidationGroup;
import com.skawuma.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @author samuelkawuma
 * @package com.skawuma.controller
 * @project Patient-Managemet-System
 * @date 4/6/25
 */
@RestController
@RequestMapping("/patients")
@Tag(name = "Patient", description = "API for managing Patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping
    @Operation(summary = "Get Patients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description ="All Patients Displayed",
                    content ={
                            @Content(mediaType = "application/json",schema = @Schema(implementation = PatientResponseDTO.class))

                    }),
            @ApiResponse(responseCode = "400", description = "No Patient Added Yet , Please Add Patient ")
    }
    )
    public ResponseEntity<List<PatientResponseDTO>> getPatients() {
        List<PatientResponseDTO> patients = patientService.getPatients();
        return ResponseEntity.ok().body(patients);
    }

    @PostMapping
    @Operation(summary = "Create a new Patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",description ="Patient Added Successfully",
                    content= {
                            @Content(mediaType = "application/json",schema = @Schema(implementation = PatientResponseDTO.class))

                    }),
            @ApiResponse(responseCode = "400", description = "Validation Error")
    }
    )
    public ResponseEntity<PatientResponseDTO> createPatient(
            @Validated({Default.class, CreatePatientValidationGroup.class})
            @RequestBody PatientRequestDTO patientRequestDTO) {

        PatientResponseDTO patientResponseDTO = patientService.createPatient(
                patientRequestDTO);

        return ResponseEntity.ok().body(patientResponseDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a new Patient")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description ="Patient Updated Successfully",
                    content= {
                            @Content(mediaType = "application/json",schema =  @Schema(implementation = Default.class))

                    }),
            @ApiResponse(responseCode = "400", description = "Validation Error")
    }
    )
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id,
                                                            @Validated({Default.class}) @RequestBody PatientRequestDTO patientRequestDTO) {

        PatientResponseDTO patientResponseDTO = patientService.updatePatient(id,
                patientRequestDTO);

        return ResponseEntity.ok().body(patientResponseDTO);
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Patient")
    public ResponseEntity<?> deletePatient(@PathVariable UUID id) {
        patientService.deletePatient(id);
//        return ResponseEntity.noContent().build();
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }

}
