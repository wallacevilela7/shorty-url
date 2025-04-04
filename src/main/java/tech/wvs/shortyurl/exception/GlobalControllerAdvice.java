package tech.wvs.shortyurl.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ShortyUrlException.class)
    public ProblemDetail handleShortyUrlException(ShortyUrlException e) {
        return e.toProblemDetail();
    }
}
