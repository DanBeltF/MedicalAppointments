/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatis.mappers;

import java.util.List;
import edu.eci.pdsw.samples.entities.Eps;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2104784
 */
public interface EpsMapper {
    public List<Eps> loadAllEps();
    
    public Eps loadEpsByNit(@Param("nit") int nit);
    
    public void registrarEps(@Param("e")Eps e);
    
    public void updateEps(@Param("e")Eps e);
    
}
