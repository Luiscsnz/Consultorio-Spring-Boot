
package ConsultorioOnline.consultorioOnline.Services;

import ConsultorioOnline.consultorioOnline.Models.Persona;
import java.util.List;

public interface PersonaService
{
    public Persona save(Persona Person);
    public void delete(Integer id);
    public Persona findById(Integer id);
    public List<Persona> findAll();
}


