package org.serratec.ONG.Exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String entrada, Long id) {
        super(entrada + " com ID " + id + " não encontrado");
    }
}
