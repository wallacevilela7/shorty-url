package tech.wvs.shortyurl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class LinkNotFoundExcepiton extends ShortyUrlException{

    private final String detail;

    public LinkNotFoundExcepiton(String detail) {
        super(detail);
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);

        pd.setTitle("Link not found");
        pd.setDetail(detail);

        return pd;
    }
}
