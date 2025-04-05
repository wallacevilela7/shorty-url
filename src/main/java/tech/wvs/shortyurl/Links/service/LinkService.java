package tech.wvs.shortyurl.Links.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import tech.wvs.shortyurl.Links.Link;
import tech.wvs.shortyurl.Links.repository.LinkRepository;
import tech.wvs.shortyurl.exception.LinkNotFoundExcepiton;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }


    //Gerar uma URL aletoria, indexar no banco de dados e retornar a URL original
    //TODO: Refatorar para manter parte da URL original
    public String generateRandomUrl() {
        return RandomStringUtils.randomAlphanumeric(5, 10);
    }

    public Link save(String urlDefault) {
        Link link = new Link();
        link.setUrlDefault(urlDefault);
        link.setUrlShortened(generateRandomUrl());
        link.setCreatedAt(LocalDateTime.now());
        link.setUrlQrCode("UNDEFINED");

        return linkRepository.save(link);
    }

    public String getOriginalUrl(String urlShortened) {
        return linkRepository
                .findByUrlShortened(urlShortened)
                .map(Link::getUrlDefault)
                .orElseThrow(() -> new
                        LinkNotFoundExcepiton("Couldn't found this URL, please check the URL and try again"));
    }
}
