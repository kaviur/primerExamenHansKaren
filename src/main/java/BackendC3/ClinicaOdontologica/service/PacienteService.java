package BackendC3.ClinicaOdontologica.service;

import BackendC3.ClinicaOdontologica.dao.PacienteDAOH2;
import BackendC3.ClinicaOdontologica.dao.iDao;
import BackendC3.ClinicaOdontologica.model.Paciente;

public class PacienteService {
    private iDao<Paciente> pacienteiDao;

    public PacienteService() {
        pacienteiDao= new PacienteDAOH2();
    }
    //metodos manuales
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteiDao.guardar(paciente);
    }
    public Paciente buscarPorID(Integer id){
        return pacienteiDao.buscarPorId(id);
    }
    public Paciente buscarPorEmail(String email){
        return pacienteiDao.buscarPorString(email);
    }
}
