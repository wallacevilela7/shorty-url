package tech.wvs.shortyurl.Links.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.wvs.shortyurl.Links.Link;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {

    Optional<Link> findByUrlShortened(String urlShortened);
}
