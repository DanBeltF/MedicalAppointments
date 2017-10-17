/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import edu.eci.pdsw.samples.entities.*;
import edu.eci.pdsw.samples.services.*;
import edu.eci.pdsw.samples.services.impl.*;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
public class ServiciosPacientesTest {

    public ServiciosPacientesTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Diseño de pruebas Clases de equivalencia
     *
     * CE1: Descripción: El paciente existe 
     * Resultado esperado: Se agrega consulta
     *
     * CE2: Descripción: El paciente no existe 
     * Resultado esperado: ERROR
     *
     * CE3: Descripción: La EPS existe
     * Resultado esperado: Se agrega
     * 
     * CE4: Descripción: La EPS no existe
     * Resultado esperado: ERROR
     */
    @Test
    public void registroConsultasPacientesTestCE1() throws ExcepcionServiciosPacientes {
        try {
            ServiciosPacientes test = new ServiciosPacientesMock();
            Consulta con = new Consulta(java.sql.Date.valueOf("1956-05-01"), "Vomito", 1000);
            test.agregarConsultaPaciente(6, "CC", con);
            assertEquals("Si se agrega", 2, test.consultarPaciente(6, "CC").getConsultas().size());
        } catch (ExcepcionServiciosPacientes ex) {
            ex.getMessage();}   
    }
    
    @Test
    public void registroPacientesTestCE3() throws ExcepcionServiciosPacientes{
        try{
            ServiciosPacientes test = new ServiciosPacientesMock();
            Paciente paci = new Paciente(8, "CC", "Estiven Martinez", new Date(2010, 2, 1), new Eps("Sura", "798273892-0"));
            test.registrarNuevoPaciente(paci);
            assertEquals("Si se agrega el paciente", "Estiven Martinez", test.consultarPaciente(8, "CC").getNombre());
        } catch (ExcepcionServiciosPacientes ex) {
            ex.getMessage();
        }
    }
}

