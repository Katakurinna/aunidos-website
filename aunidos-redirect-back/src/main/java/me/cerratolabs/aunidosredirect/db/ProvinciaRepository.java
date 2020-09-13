package me.cerratolabs.aunidosredirect.db;

import me.cerratolabs.aunidosredirect.dto.Provincia;
import me.cerratolabs.aunidosredirect.dto.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface  ProvinciaRepository extends JpaRepository<Provincia, Long> {

    @Query
    Long findIdByName(String name);
    @Query
    Provincia findByName(String name);
}