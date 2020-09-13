package me.cerratolabs.aunidosredirect.db;

import me.cerratolabs.aunidosredirect.dto.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {
    @Query
    SocialMedia findProvinciaByNameAndProvincia(String name, Integer provincia);
}