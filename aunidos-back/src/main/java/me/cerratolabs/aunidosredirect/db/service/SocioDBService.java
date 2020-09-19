package me.cerratolabs.aunidosredirect.db.service;

import me.cerratolabs.aunidosredirect.db.repository.SocioRepository;
import me.cerratolabs.aunidosredirect.db.repository.CodVerificacionRepository;
import me.cerratolabs.aunidosredirect.dto.CodVerificacion;
import me.cerratolabs.aunidosredirect.dto.Socio;
import me.cerratolabs.aunidosredirect.exceptions.CrearSocioException;
import me.cerratolabs.aunidosredirect.utils.FechaUtils;
import me.cerratolabs.aunidosredirect.utils.GenerarCodigo;
import me.cerratolabs.aunidosredirect.utils.SocioUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;

@Service
public class SocioDBService {

    @Autowired private SocioRepository socioRepository;
    @Autowired private CodVerificacionRepository codVerificacionRepository;

    public void crearSocio(Socio socio) throws Exception {
        SocioUtils.verificarSocio(socio);
        if (existeSocio(socio)) {
            throw new CrearSocioException("El socio ya existe");
        }
        socio.setFecAlta(new Date());
        this.socioRepository.saveAndFlush(socio);
    }

    public boolean existeSocio(Socio socio) throws Exception {
        Socio socioExistente = this.socioRepository.findByDni(socio.getDni());
        if (socioExistente != null && socioExistente.getDni() != null) {
            return true;
        }
        return false;
    }

    public CodVerificacion generarCodigoVerificacion(String dni) throws Exception {
        CodVerificacion codVerificacion = new CodVerificacion();
        String codigo = GenerarCodigo.generar();
        codVerificacion.setDni(dni);
        codVerificacion.setId(0);
        codVerificacion.setCodigo(codigo);
        codVerificacion.setFecCad(new Date(System.currentTimeMillis() + 3700000));
        this.codVerificacionRepository.deleteAllByDni(new Date(), dni);
        this.codVerificacionRepository.save(codVerificacion);
        this.codVerificacionRepository.flush();
        return codVerificacion;
    }

    public boolean verificarEmailSocio(String dni, String codigo) throws Exception {
        // Comprobar si el socio no está ya verificado.
        Boolean verificado = this.socioRepository.comprobarSiNoEstaVerificado(dni);
        if (verificado != null && !verificado) throw new CrearSocioException("El socio ya está verificado");
        // Comprobar si el código y el email son correctos.
        CodVerificacion codVerificacion = this.codVerificacionRepository.findByDniAndCodigoAndFecCadIsNull(dni, codigo);

        if (codVerificacion == null || codVerificacion.getDni() == null)
            return false;

        this.socioRepository.confirmarEmailSocio(dni);
        this.codVerificacionRepository.deleteAllByDni(new Date(), dni);
        return true;
    }

    public Socio obtenerPorDNI(String data) throws Exception {
        if (ObjectUtils.isEmpty(data)) return null;
        return this.socioRepository.findByDniAndFecBajaIsNull(data);
    }

    public Socio obtenerPorEmail(String data) throws Exception {
        if (ObjectUtils.isEmpty(data)) return null;
        return this.socioRepository.findByEmailAndFecBajaIsNull(data);
    }

    public Socio obtenerPorTelefono(String data) throws Exception {
        if (ObjectUtils.isEmpty(data)) return null;
        return this.socioRepository.findByTelMovilAndFecBajaIsNull(data);
    }

    public List<Socio> obtenerSociosActivos() throws Exception {
        return this.socioRepository.findAllActiveMembers();
    }

    public List<Socio> obtenerSociosActivosYNoActivos() throws Exception {
        return this.socioRepository.findAll();
    }

    public List<Socio> obtenerSociosPorGremio(String gremio) throws Exception {
        if (ObjectUtils.isEmpty(gremio)) return null;
        return this.socioRepository.findAllByGremioAndFecBajaIsNull(gremio);
    }

    public List<Socio> obtenerSociosPorProvincia(Integer provincia) throws Exception {
        if (ObjectUtils.isEmpty(provincia)) return null;
        return this.socioRepository.findAllByProvinciaAndFecBajaIsNull(provincia);
    }

    public boolean modificarSocio(Socio socio) throws Exception {
        if (socio == null) return false;
        if (!this.socioRepository.existsByDni(socio.getDni()))
            return false;
        socio.setFecUltModificacion(new Date());
        this.socioRepository.saveAndFlush(socio);
        return true;
    }
}