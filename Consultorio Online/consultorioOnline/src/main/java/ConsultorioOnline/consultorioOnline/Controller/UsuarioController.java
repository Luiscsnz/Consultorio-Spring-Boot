/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsultorioOnline.consultorioOnline.Controller;

import ConsultorioOnline.consultorioOnline.Models.Persona;
import ConsultorioOnline.consultorioOnline.Models.TipoUsuario;
import ConsultorioOnline.consultorioOnline.Models.Usuario;
import ConsultorioOnline.consultorioOnline.Services.PersonaService;
import ConsultorioOnline.consultorioOnline.Services.TipoUsuarioService;
import ConsultorioOnline.consultorioOnline.Services.UsuarioService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private PersonaService personaService;
    
    @Autowired
    private TipoUsuarioService tipoUsuarioService;
    //AGREGAR - POST
    @PostMapping(value = "/")
    public ResponseEntity<Usuario> agregar(@RequestBody Usuario usuario) {
        Persona per = personaService.save(usuario.getPersona());
        usuario.setPersona(per);
        Usuario obj = usuarioService.save(usuario);
        
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //BORRAR
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Integer id) {
        Usuario obj = usuarioService.findById(id);
        if (obj != null) {
            usuarioService.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //EDITAR - PUT
    
    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> editar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        System.out.println(usuario);
        Usuario obj = usuarioService.findById(id);
        
        if (obj != null) {
            //TipoUsuario tu = tipoUsuarioService.findById(obj.getTipoUsuario().getId());
            Persona per = personaService.findById(obj.getPersona().getId());
            
            usuario.setNombre_usuario(usuario.getNombre_usuario());
            usuario.setPassword(usuario.getPassword());
            System.out.println(usuario.getPersona());
            
            usuario.setTipoUsuario(usuario.getTipoUsuario());
            
            per.setNombre(usuario.getPersona().getNombre());
            per.setApellido(usuario.getPersona().getApellido());
            per.setDireccion(usuario.getPersona().getDireccion());
            per.setCorreo(usuario.getPersona().getCorreo());
            per.setFecha_nacimiento(usuario.getPersona().getFecha_nacimiento());
            per.setCiudad(usuario.getPersona().getCiudad());
            per.setTelefono(usuario.getPersona().getTelefono());
            per.setSexo(usuario.getPersona().getSexo());
            
            usuario.setPersona(per);
            //tu.setNombre(usuario.getPersona().getNombre());
            System.out.println("este es el obj"+obj);
            //tipoUsuarioService.save(tu);
            personaService.save(per);
            usuarioService.save(usuario);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //BUSCAR TODOS
    @GetMapping("/list")
    public List<Usuario> consultarTodo() {
        return usuarioService.findAll();
    }

    //BUSCAR POR ID
    @GetMapping("/list/{id}")
    public Usuario consultaPorId(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

}
