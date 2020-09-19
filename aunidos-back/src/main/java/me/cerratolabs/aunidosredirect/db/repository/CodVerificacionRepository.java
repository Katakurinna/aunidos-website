package me.cerratolabs.aunidosredirect.db.repository;

import me.cerratolabs.aunidosredirect.dto.CodVerificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
@Transactional
public interface CodVerificacionRepository extends JpaRepository<CodVerificacion, Integer> {
    @Modifying
    @Query(value = "UPDATE cod_verificacion set fec_cad = ?1 WHERE dni = ?2 AND fec_cad is null" , nativeQuery = true)
    void deleteAllByDni(Date fec_cad, String dni);

    CodVerificacion findByDniAndCodigoAndFecCadIsNull(String dni, String codigo);
}