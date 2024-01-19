package fr.donovan.exam.centrale_ish.advisor;

import fr.donovan.exam.centrale_ish.custom_response.ResponseException;
import fr.donovan.exam.centrale_ish.exception.NotFoundCentraleIshException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundResponse {

    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) // Modifie le code HTTP de la réponse
    @ExceptionHandler(NotFoundCentraleIshException.class)
        // L'exception qui doit être "catch"
    ResponseException notFoundResponseHandler(NotFoundCentraleIshException e) {
        return new ResponseException(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                e.getType(),
                e.getField(),
                e.getValue(),
                e.getMessage()
        );
    }

}
