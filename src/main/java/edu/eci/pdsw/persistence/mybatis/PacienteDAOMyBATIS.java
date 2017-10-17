/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.persistence.PacienteDAO;
import edu.eci.pdsw.persistence.PersistenceException;
import edu.eci.pdsw.persistence.mybatis.mappers.PacienteMapper;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public class PacienteDAOMyBATIS implements PacienteDAO {

    @Inject
    PacienteMapper pMap;
    
    @Override
    public List<Paciente> loadAll() throws PersistenceException {
        try {
            return pMap.loadPacientes();
        } catch (Exception ex) {
            throw new PersistenceException("Error al cargar los pacientes",ex);
        }
    }
    
    @Override
    public List<Paciente> load() throws PersistenceException {
        try {
            return pMap.loadPacientes();
        } catch (Exception ex) {
            throw new PersistenceException("Error al cargar los pacientes",ex);
        }
    }

    @Override
    public Paciente loadById(int id, String tipoId) throws PersistenceException {
        try {
            return pMap.loadPacienteById(id, tipoId);
        } catch (Exception ex) {
            throw new PersistenceException("Error al cargar el paciente con id: "+id,ex);
        }
    }

    @Override
    public void save(Paciente p) throws PersistenceException {
        try {
            pMap.insertarPaciente(p);
            for (Consulta c : p.getConsultas()) {
                pMap.insertConsulta(c, p.getId(), p.getTipoId(), (int) c.getCosto());
            }
        } catch (Exception ex) {
            throw new PersistenceException("Error al guardar el paciente"+p.getNombre(),ex);
        }
    }

    @Override
    public void update(Paciente p) throws PersistenceException {
        try {
            for (Consulta c : p.getConsultas()) {
                if (c.getId() == 0) {
                    pMap.insertConsulta(c, p.getId(), p.getTipoId(), (int) c.getCosto());
                }
            }
            pMap.actualizarPaciente(p);
        } catch (Exception ex) {
            throw new PersistenceException("Error al actualizar el pasiente"+p.getId(),ex);
        }
    }
}
