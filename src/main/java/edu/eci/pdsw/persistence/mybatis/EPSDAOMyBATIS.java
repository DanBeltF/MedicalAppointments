/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.persistence.EPSDAO;
import edu.eci.pdsw.persistence.PersistenceException;
import edu.eci.pdsw.persistence.mybatis.mappers.EpsMapper;

import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import java.util.List;

/**
 *
 * @author DANIEL
 */
public class EPSDAOMyBATIS implements EPSDAO {

    @Inject
    EpsMapper epsMap;
    
    @Override
    public List<Eps> loadAll() throws PersistenceException {
        try {
            return epsMap.loadAllEps();
        } catch (Exception ex) {
            throw new PersistenceException("Error al cargar las eps",ex);
        }
    }
    
    @Override
    public List<Eps> load() throws PersistenceException {
        try {
            return epsMap.loadAllEps();
        } catch (Exception ex) {
            throw new PersistenceException("Error al cargar las eps",ex);
        }
    }
    
    @Override
    public Eps loadById(int nit) throws PersistenceException {
        try {
            return epsMap.loadEpsByNit(nit);
        } catch (Exception e) {
            throw new PersistenceException("Error al cargar la eps con nit: " + nit,e);
        }
    }

    @Override
    public void save(Eps e) throws PersistenceException {
        try {
            epsMap.registrarEps(e);
        } catch (Exception ex) {
            throw new PersistenceException("Error al guardar la eps" + e.getNombre(),ex);
        }
    }

    @Override
    public void update(Eps e) throws PersistenceException {
        try {
            epsMap.updateEps(e);
        } catch (Exception ex) {
            throw new PersistenceException("Error al actualizar la eps "+e.getNombre(),ex);
        }
    }

}
