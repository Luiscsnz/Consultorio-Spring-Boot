/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsultorioOnline.consultorioOnline.Controller;

import ConsultorioOnline.consultorioOnline.Models.Persona;
import ConsultorioOnline.consultorioOnline.Services.PersonaService;


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
@RequestMapping("/persona")
public class PersonaController
{

    @Autowired
    private PersonaService personaService;
    
    //AGREGAR - POST
    @PostMapping(value="/")
    public ResponseEntity<Persona> agregar(@RequestBody Persona person)
    {
        
        Persona obj = personaService.save(person);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //BORRAR
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Persona> eliminar(@PathVariable Integer id){
    Persona obj = personaService.findById(id);
    if(obj!=null)
        personaService.delete(id);
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //EDITAR - PUT
    @PutMapping(value="/{id}")
    public ResponseEntity<Persona> editar(@PathVariable Integer id, @RequestBody Persona person)
    {
        Persona obj = personaService.findById(id);
        if(obj!=null)
        {
            
            obj.setNombre(person.getNombre());
            obj.setApellido(person.getApellido());
            obj.setDireccion(person.getDireccion());
            obj.setCorreo(person.getCorreo());
            obj.setFecha_nacimiento(person.getFecha_nacimiento());
            obj.setCiudad(person.getCiudad());
            obj.setTelefono(person.getTelefono());
            obj.setSexo(person.getSexo());
            
            
            personaService.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //BUSCAR TODOS
    @GetMapping("/list")
    public List<Persona> consultarTodo()
    {
        return personaService.findAll();
    }

    //BUSCAR POR ID
    @GetMapping("/list/{id}")
    public Persona consultaPorId(@PathVariable Integer id)
    {
        return personaService.findById(id);
    }
    
}

