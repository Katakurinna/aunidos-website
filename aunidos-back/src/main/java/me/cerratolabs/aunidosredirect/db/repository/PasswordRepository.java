package me.cerratolabs.aunidosredirect.db.repository;

import me.cerratolabs.aunidosredirect.dto.Password;
import me.cerratolabs.aunidosredirect.dto.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Integer> {

    @Query
    Password findPasswordByProvincia(Integer provincia);
}