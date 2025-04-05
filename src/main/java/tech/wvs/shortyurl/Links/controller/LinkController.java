package tech.wvs.shortyurl.Links.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.wvs.shortyurl.Links.Link;
import tech.wvs.shortyurl.Links.LinkResponse;
import tech.wvs.shortyurl.Links.repository.LinkRepository;
import tech.wvs.shortyurl.Links.service.LinkService;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/links")
public class LinkController {

    private final LinkService linkService;
    private final LinkRepository linkRepository;

    public LinkController(LinkService linkService, LinkRepository linkRepository) {
        this.linkService = linkService;
        this.linkRepository = linkRepository;
    }

    @GetMapping(path = "/listar-links")
    public ResponseEntity<List<Link>> findAll() {
        return ResponseEntity.ok(linkRepository.findAll());
    }

    @PostMapping(path = "/encurtador")
    public ResponseEntity<LinkResponse> shortenUrl(@RequestBody Map<String, String> request) {
        String urlDefault = request.get("urlOriginal");
        Link link = linkService.save(urlDefault);

        String generateRedirectUrl = "http://localhost:8080/api/links/redirect/" + link.getUrlShortened();

        LinkResponse linkResponse = new LinkResponse();
        linkResponse.setId(link.getId());
        linkResponse.setUrlDefault(link.getUrlDefault());
        linkResponse.setUrlShortened(generateRedirectUrl);
        linkResponse.setUrlQrCode(link.getUrlQrCode());
        linkResponse.setCreatedAt(link.getCreatedAt());

        return ResponseEntity.status(HttpStatus.CREATED).body(linkResponse);
    }

    @GetMapping("/redirect/{urlShortened}")
    public void redirectLink(@PathVariable("urlShortened") String urlShortened,
                             HttpServletResponse response) throws IOException {
        String originalUrl = linkService.getOriginalUrl(urlShortened);
        response.sendRedirect(originalUrl);
    }

}
