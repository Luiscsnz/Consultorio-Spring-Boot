/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsultorioOnline.consultorioOnline.Implement;

import ConsultorioOnline.consultorioOnline.Dao.TipoUsuarioDao;
import ConsultorioOnline.consultorioOnline.Models.TipoUsuario;
import ConsultorioOnline.consultorioOnline.Services.TipoUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService
{

    @Autowired
    private TipoUsuarioDao tipoUsuarioDao;
    

    //AGREGAR-EDITAR
    @Override
    @Transactional(readOnly=false)
    public TipoUsuario save(TipoUsuario tipoUsuario)
    {
        return tipoUsuarioDao.save(tipoUsuario);
    }

    //BORRAR
    @Override
    @Transactional(readOnly=false)
    public void delete(Integer id)
    {
        tipoUsuarioDao.deleteById(id);
    }

    //BUSCAR POR ID
    @Override
    @Transactional(readOnly=true)
    public TipoUsuario findById(Integer id)
    {    
        return tipoUsuarioDao.findById(id).orElse(null);
    }

    //BUSCAR TODOS
    @Override
    @Transactional(readOnly=true)
    public List<TipoUsuario> findAll()
    {
        return (List<TipoUsuario>) tipoUsuarioDao.findAll();
    }

}
