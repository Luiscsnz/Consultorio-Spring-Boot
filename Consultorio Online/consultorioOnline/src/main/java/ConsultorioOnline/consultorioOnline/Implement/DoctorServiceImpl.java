
package ConsultorioOnline.consultorioOnline.Implement;

import ConsultorioOnline.consultorioOnline.Dao.DoctorDao;
import ConsultorioOnline.consultorioOnline.Models.Doctor;
import ConsultorioOnline.consultorioOnline.Services.DoctorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao doctorDao;

    //AGREGAR-EDITAR
    @Override
    @Transactional(readOnly = false)
    public Doctor save(Doctor doctor) {
        return doctorDao.save(doctor);
    }

    //BORRAR
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        doctorDao.deleteById(id);
    }

    //BUSCAR POR ID
    @Override
    @Transactional(readOnly = true)
    public Doctor findById(Integer id) {
        return doctorDao.findById(id).orElse(null);
    }

    //BUSCAR TODOS
    @Override
    @Transactional(readOnly = true)
    public List<Doctor> findAll() {
        return (List<Doctor>) doctorDao.findAll();
    }

}
