/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ConsultorioOnline.consultorioOnline.Services;

import ConsultorioOnline.consultorioOnline.Models.Usuario;
import java.util.List;

public interface UsuarioService {
    public Usuario save(Usuario usuario);
    public void delete(Integer id);
    public Usuario findById(Integer id);
    public List<Usuario> findAll();
}
