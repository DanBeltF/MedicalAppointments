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
public class ServiciosPacientesTest {

    ServiciosPacientes test = ServiciosHistorialPacientesFactory.getInstance().getTestingServiciosPaciente();
    
    public ServiciosPacientesTest() {
    }

    @Before
    public void setUp() {
    }
    
    @Test
    public void registroConsultasPacientesTestCE1() throws ExcepcionServiciosPacientes {
        Consulta con = new Consulta(java.sql.Date.valueOf("2020-01-01"), "Dolor de cabeza", 745334);
        try {
            test.agregarConsultaPaciente(0, "CC", con);
            fail("esta agregando a un paciente inexistente");
        } catch (Exception e) {
            Logger.getLogger(ServiciosPacientesTest.class.getName()).log(Level.SEVERE, null, e);}   
    }
    
    
    @Test
    public void registroPacientesTestCE3() throws ExcepcionServiciosPacientes{
        try{
            Paciente paci = new Paciente(8, "CC", "Estiven Martinez", new Date(2010, 2, 1), new Eps("Sura", "798273892-0"));
            test.registrarNuevoPaciente(paci);
            assertEquals("Si se agrega el paciente", "Estiven Martinez", test.consultarPaciente(8, "CC").getNombre());
        } catch (ExcepcionServiciosPacientes ex) {
            Logger.getLogger(ServiciosPacientesTest.class.getName()).log(Level.SEVERE, null, ex);}
        }
}