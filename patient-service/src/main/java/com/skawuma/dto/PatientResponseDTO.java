package com.skawuma.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author samuelkawuma
 * @package com.skawuma.dto
 * @project Patient-Managemet-System
 * @date 4/5/25
 */
@Setter
@Getter
public class PatientResponseDTO {
    private String id;
    private String name;
    private String email;
    private String address;
    private String dateOfBirth;

}
