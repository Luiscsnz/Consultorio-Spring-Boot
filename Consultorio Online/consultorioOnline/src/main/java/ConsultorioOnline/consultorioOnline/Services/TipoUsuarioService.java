/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ConsultorioOnline.consultorioOnline.Services;

import ConsultorioOnline.consultorioOnline.Models.TipoUsuario;
import java.util.List;

/**
 *
 * @author SP
 */
public interface TipoUsuarioService {
    public TipoUsuario save(TipoUsuario tipoUsuario);
    public void delete(Integer id);
    public TipoUsuario findById(Integer id);
    public List<TipoUsuario> findAll();
}
