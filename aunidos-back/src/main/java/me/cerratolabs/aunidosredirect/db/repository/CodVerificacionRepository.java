package me.cerratolabs.aunidosredirect.db.repository;

import me.cerratolabs.aunidosredirect.dto.CodVerificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodVerificacionRepository extends JpaRepository<CodVerificacion, Integer> {
    @Modifying
    @Query(value = "UPDATE cod_verificacion set fec_cad = ?1 WHERE email = ?2 AND fec_cad is null" , nativeQuery = true)
    List<CodVerificacion> removeAllByEmail(String fec_cad, String email);

    CodVerificacion findByEmailAndCodigoAndFecCadIsNull(String email, String codigo);
}