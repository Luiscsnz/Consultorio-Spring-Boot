package ConsultorioOnline.consultorioOnline.Implement;

import ConsultorioOnline.consultorioOnline.Dao.PersonaDao;
import ConsultorioOnline.consultorioOnline.Models.Persona;
import ConsultorioOnline.consultorioOnline.Services.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService
{

    @Autowired
    private PersonaDao personaDao;

    //AGREGAR-EDITAR
    @Override
    @Transactional(readOnly=false)
    public Persona save(Persona person)
    {
        return personaDao.save(person);
    }

    //BORRAR
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id)
    {
        personaDao.deleteById(id);
    }

    //BUSCAR POR ID
    @Override
    @Transactional(readOnly=true)
    public Persona findById(Integer id)
    {    
        return personaDao.findById(id).orElse(null);
    }

    //BUSCAR TODOS
    @Override
    @Transactional(readOnly=true)
    public List<Persona> findAll()
    {
        return (List<Persona>) personaDao.findAll();
    }

}


