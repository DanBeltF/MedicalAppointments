package edu.eci.pdsw.persistence.mybatis.mappers;



import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import java.util.Date;

import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 *
 * @author 2106913
 */
public interface PacienteMapper {
        
    public Paciente loadPacienteById(@Param("id") int id,@Param("tipo_id")String tipoid);
        
    public List<Paciente> loadPacientes();
    
    public void insertarPaciente(@Param("pac") Paciente p);
    
    public void insertConsulta(@Param("con") Consulta con,@Param("idp") int idPaciente,@Param("tipoidp") String tipoid,@Param("costoc") int costoconsulta);
    
    public void actualizarPaciente(@Param("acpac") Paciente p); 

}
