/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managebeans;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosHistorialPacientesFactory;
import edu.eci.pdsw.samples.services.ServiciosPacientes;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2106913
 */
@ManagedBean(name = "HistorialPacientes")
@SessionScoped
public class RegistroConsultaBean implements Serializable {

    private final ServiciosPacientes servicepacientes = ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();
    private Paciente pacienteSelec;
    private Consulta consulta;
    private Paciente paciente;
    private String epss;
    private static Map<String, Object> eps;

    public void init(){
        eps = new LinkedHashMap<String, Object>();
        eps.put("Compensar", new Eps("Compensar", "8456981"));
        eps.put("Sanitas", new Eps("Sanitas","8456982"));
        eps.put("Sura", new Eps("Sura", "8456983"));
        eps.put("Coomeva", new Eps("Coomeva", "8456984"));
        eps.put("Medimas", new Eps("Medimas","8456985"));
        eps.put("SaludTotal", new Eps("SaludTotal","8456986")); 
    }
    
    public RegistroConsultaBean() {
        paciente = new Paciente();
        consulta = new Consulta();
    }

    public Paciente getPacienteSelec() {
        return pacienteSelec;
    }

    public void setPacienteSelec(Paciente pacienteSelec) {
        this.pacienteSelec = pacienteSelec;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Set<Consulta> getConsultas() {
        return pacienteSelec.getConsultas();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Paciente> getPacientes() throws ExcepcionServiciosPacientes {
        return servicepacientes.consultarPacientes();
    }

    public String getEpss() {
        return epss;
    }

    public void setEpss(String epss) {
        this.epss = epss;
    }

    public List<Eps> getEps() throws ExcepcionServiciosPacientes {
        return servicepacientes.obtenerEPSsRegistradas();
    }



    public void agregarConsulta() throws ExcepcionServiciosPacientes {
        servicepacientes.agregarConsultaPaciente(pacienteSelec.getId(),
        pacienteSelec.getTipoId(), consulta);
        consulta = new Consulta();
        pacienteSelec=servicepacientes.consultarPaciente(pacienteSelec.getId(), pacienteSelec.getTipoId());

    }

    public ServiciosPacientes getServicepacientes() {
        return servicepacientes;
    }

    public String action(){
        return "registropacientes.xhtml";
    }  
    
    public void agregarPaciente() throws ExcepcionServiciosPacientes {
        servicepacientes.registrarNuevoPaciente(paciente);
        paciente = new Paciente();
    }

    public void showMessage(String estado, String mensaje) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, estado, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

}
