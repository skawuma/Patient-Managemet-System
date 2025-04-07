package com.skawuma.exception;

/**
 * @author samuelkawuma
 * @package com.skawuma.exception
 * @project Patient-Managemet-System
 * @date 4/6/25
 */
public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
