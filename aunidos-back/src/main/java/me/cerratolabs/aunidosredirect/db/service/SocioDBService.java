package me.cerratolabs.aunidosredirect.db.service;

import me.cerratolabs.aunidosredirect.db.repository.SocioRepository;
import me.cerratolabs.aunidosredirect.db.repository.CodVerificacionRepository;
import me.cerratolabs.aunidosredirect.dto.Socio;
import me.cerratolabs.aunidosredirect.dto.CodVerificacion;
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

    public Boolean crearSocio(Socio socio) throws Exception {
        SocioUtils.verificarSocio(socio);
        if (existeSocio(socio)) {
            throw new CrearSocioException("El socio ya existe");
        }
        socio.setFecAlta(new Date());
        this.socioRepository.saveAndFlush(socio);
        return true;
    }

    public Boolean existeSocio(Socio socio) throws Exception {
        Socio socioExistente = this.socioRepository.findByDniOOrEmailOrTelMovil(socio.getDni(), socio.getEmail(), socio.getTelMovil());
        if (socioExistente != null && socioExistente.getDni() != null) {
            return true;
        }
        return false;
    }

    public CodVerificacion generarCodigoVerificarEmail(String email) throws Exception {
        CodVerificacion codVerificacion = new CodVerificacion();
        String codigo = GenerarCodigo.generar();
        codVerificacion.setEmail(email);
        codVerificacion.setId(0);
        codVerificacion.setCodigo(codigo);
        codVerificacion.setFecCad(new Date(System.currentTimeMillis() + 3700000));
        this.codVerificacionRepository.removeAllByEmail(FechaUtils.obtenerFechaFormateada(), email);
        this.codVerificacionRepository.saveAndFlush(codVerificacion);
        return codVerificacion;
    }

    public Boolean verificarEmailSocio(String email, String codigo) throws Exception {
        // Comprobar si el socio no está ya verificado.
        Boolean verificado = this.socioRepository.comprobarSiNoEstaVerificado(email);
        if (verificado != null && !verificado) throw new CrearSocioException("El socio ya está verificado");
        // Comprobar si el código y el email son correctos.
        CodVerificacion codVerificacion = this.codVerificacionRepository.findByEmailAndCodigoAndFecCadIsNull(email, codigo);

        if (codVerificacion == null || codVerificacion.getEmail() == null)
            throw new CrearSocioException("El codigo o email no es correcto.");

        this.socioRepository.confirmarEmailSocio(email);
        this.codVerificacionRepository.removeAllByEmail(FechaUtils.obtenerFechaFormateada(), email);
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
        return this.socioRepository.findAllByProvinciaAAndFecBajaIsNull(provincia);
    }

    public boolean modificarSocio(Socio socio) throws Exception {
        if (socio == null) return false;
        if (!this.socioRepository.existsByDniOrEmailOrTelMovil(socio.getDni(), socio.getEmail(), socio.getTelMovil()))
            return false;
        this.socioRepository.saveAndFlush(socio);
        return true;
    }
}