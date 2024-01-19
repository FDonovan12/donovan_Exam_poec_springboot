package fr.donovan.exam.centrale_ish.exception;

import lombok.Getter;

@Getter
public class NotFoundCentraleIshException extends RuntimeException {

    private final String type;

    private final String field;

    private final Object value;

    public NotFoundCentraleIshException(String type, String field, Object value) {
        super("Entity not found");
        this.type = type;
        this.field = field;
        this.value = value;
    }
}
