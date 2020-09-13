package me.cerratolabs.aunidosredirect.db;

import me.cerratolabs.aunidosredirect.dto.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends JpaRepository<URL, Integer> {

    @Query
    URL findURLByProvinciaAndAndSocialMedia(Integer provincia, Integer socialMedia);
}