/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsultorioOnline.consultorioOnline.Controller;

import ConsultorioOnline.consultorioOnline.Models.TipoUsuario;
import ConsultorioOnline.consultorioOnline.Services.TipoUsuarioService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/tipousuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    //AGREGAR - POST
    @PostMapping(value = "/")
    public ResponseEntity<TipoUsuario> agregar(@RequestBody TipoUsuario tipoUsuario) {

        TipoUsuario obj = tipoUsuarioService.save(tipoUsuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //BORRAR
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TipoUsuario> eliminar(@PathVariable Integer id) {
        TipoUsuario obj = tipoUsuarioService.findById(id);
        if (obj != null) {
            tipoUsuarioService.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //EDITAR - PUT
    @PutMapping(value = "/{id}")
    public ResponseEntity<TipoUsuario> editar(@PathVariable Integer id, @RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario obj = tipoUsuarioService.findById(id);
        if (obj != null) {
            
            
            obj.setNombre(tipoUsuario.getNombre());
            
            

            tipoUsuarioService.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //BUSCAR TODOS
    @GetMapping("/list")
    public List<TipoUsuario> consultarTodo() {
        return tipoUsuarioService.findAll();
    }

    //BUSCAR POR ID
    @GetMapping("/list/{id}")
    public TipoUsuario consultaPorId(@PathVariable Integer id) {
        return tipoUsuarioService.findById(id);
    }

}
