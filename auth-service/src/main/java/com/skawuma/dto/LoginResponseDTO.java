package com.skawuma.dto;

/**
 * @author samuelkawuma
 * @package com.skawuma.dto
 * @project Patient-Managemet-System
 * @date 4/27/25
 */
public class LoginResponseDTO {
    private final String token;

    public LoginResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }


}
