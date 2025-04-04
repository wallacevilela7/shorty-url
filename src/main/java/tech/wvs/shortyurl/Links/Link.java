package tech.wvs.shortyurl.Links;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url_default")
    private String urlDefault;

    @Column(name = "url_shortened")
    private String urlShortened;

    @Column(name = "url_qr_code")
    private String urlQrCode;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Link() {
    }

    public Link(Long id, String urlDefault, String urlShortened, String urlQrCode, LocalDateTime createdAt) {
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