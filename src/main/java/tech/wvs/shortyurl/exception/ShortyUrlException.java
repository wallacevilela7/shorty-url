package tech.wvs.shortyurl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public abstract class ShortyUrlException extends RuntimeException {
    public ShortyUrlException(String message) {
        super(message);
    }

    public ProblemDetail toProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pd.setTitle("Internal Server Error");
        pd.setDetail("Please contact support");

        return pd;
    }
}
