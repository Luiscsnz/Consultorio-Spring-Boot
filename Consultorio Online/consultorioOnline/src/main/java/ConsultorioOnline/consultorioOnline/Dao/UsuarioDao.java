/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ConsultorioOnline.consultorioOnline.Dao;

import ConsultorioOnline.consultorioOnline.Models.Usuario;
import org.springframework.data.repository.CrudRepository;
public interface UsuarioDao extends CrudRepository<Usuario,Integer>{}

