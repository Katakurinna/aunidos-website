package me.cerratolabs.aunidosredirect.db.repository;

import me.cerratolabs.aunidosredirect.dto.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface SocioRepository extends JpaRepository<Socio, String> {

    @Query(value = "SELECT * FROM socio u WHERE fec_baja is null", nativeQuery = true)
    List<Socio> findAllActiveMembers();

    /**
     * Devuelve el socio por DNI
     * @param dni dni para realizar la busqueda
     * @return socio o nulo si no lo encuentra.
     */
    Socio findByDni(String dni);

    /**
     * Devuelve si un socio buscado por dni tiene el email verificado o no.
     * @param dni dni para testear
     * @return si el email esta verificado o no.
     */
    @Query(value = "SELECT email_confirmado FROM socio u WHERE fec_baja is null AND dni = ?1", nativeQuery = true)
    Boolean comprobarSiNoEstaVerificado(String dni);

    /**
     * Verifica el email del socio
     * @param dni dni del socio
     */
    @Modifying
    @Query(value = "UPDATE socio SET email_confirmado = true WHERE dni = ?1", nativeQuery = true)
    void confirmarEmailSocio(String dni);

    /**
     * Obten el socio si la fecha de baja es nula.
     * @param dni dni para realizar la busqueda
     * @return socio si existe y no esta dado de baja.
     */
    Socio findByDniAndFecBajaIsNull(String dni);

    /**
     * Obten el socio si la fecha de baja es nula.
     * @param email email para realizar la busqueda
     * @return socio si existe y no esta dado de baja.
     */
    Socio findByEmailAndFecBajaIsNull(String email);

    /**
     * Obten el socio si la fecha de baja es nula.
     * @param tel_movil tel_movil para realizar la busqueda
     * @return socio si existe y no esta dado de baja.
     */
    Socio findByTelMovilAndFecBajaIsNull(String tel_movil);

    /**
     * Obten todos los socios que tengan ese gremio.
     * @param gremio
     * @return lista de socios
     */
    List<Socio> findAllByGremioAndFecBajaIsNull(String gremio);

    /**
     * Obtener todos los socios que pertenezcan a esa provincia
     * @param provincia
     * @return lista de socios
     */
    List<Socio> findAllByProvinciaAndFecBajaIsNull(Integer provincia);

    /**
     * Comprobar si un socio existe por su dni, email o telefono movil
     * @param dni
     * @return si existe el socio o no
     */
    boolean existsByDni(String dni);
}
