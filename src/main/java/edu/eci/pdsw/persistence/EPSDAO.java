/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence;

import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import java.util.List;
/**
 *
 * @author DANIEL
 */
public interface EPSDAO{
    
    public List<Eps> loadAll() throws PersistenceException;
    
    public List<Eps> load() throws PersistenceException;

    public Eps loadById(int nit) throws PersistenceException;
    
    public void save(Eps e) throws PersistenceException ;
    
    public void update(Eps e) throws PersistenceException;
}
