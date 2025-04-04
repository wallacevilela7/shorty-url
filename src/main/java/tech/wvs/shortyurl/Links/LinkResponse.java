package tech.wvs.shortyurl.Links;

import java.time.LocalDateTime;

public class LinkResponse {
    private Long id;
    private String urlDefault;
    private String urlShortened;
    private String urlQrCode;
    private LocalDateTime createdAt;

    public LinkResponse() {
    }

    public LinkResponse(Long id, String urlDefault, String urlShortened, String urlQrCode, LocalDateTime createdAt) {
        this.id = id;
        this.urlDefault = urlDefault;
        this.urlShortened = urlShortened;
        this.urlQrCode = urlQrCode;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlDefault() {
        return urlDefault;
    }

    public void setUrlDefault(String urlDefault) {
        this.urlDefault = urlDefault;
    }

    public String getUrlShortened() {
        return urlShortened;
    }

    public void setUrlShortened(String urlShortened) {
        this.urlShortened = urlShortened;
    }

    public String getUrlQrCode() {
        return urlQrCode;
    }

    public void setUrlQrCode(String urlQrCode) {
        this.urlQrCode = urlQrCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
