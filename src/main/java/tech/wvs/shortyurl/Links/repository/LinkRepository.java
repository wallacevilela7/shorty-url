package tech.wvs.shortyurl.Links.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.wvs.shortyurl.Links.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
