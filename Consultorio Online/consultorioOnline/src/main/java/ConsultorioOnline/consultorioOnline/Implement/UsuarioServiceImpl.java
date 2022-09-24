/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsultorioOnline.consultorioOnline.Implement;

import ConsultorioOnline.consultorioOnline.Dao.UsuarioDao;
import ConsultorioOnline.consultorioOnline.Models.Usuario;
import ConsultorioOnline.consultorioOnline.Services.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    //AGREGAR-EDITAR
    @Override
    @Transactional(readOnly = false)
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    //BORRAR
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        usuarioDao.deleteById(id);
    }

    //BUSCAR POR ID
    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }

    //BUSCAR TODOS
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }
        
}
