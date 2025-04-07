package com.skawuma.exception;

/**
 * @author samuelkawuma
 * @package com.skawuma.exception
 * @project Patient-Managemet-System
 * @date 4/6/25
 */
public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(String message) {
        super(message);
    }
}

