/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConsultorioOnline.consultorioOnline.Controller;

import ConsultorioOnline.consultorioOnline.Models.Doctor;
import ConsultorioOnline.consultorioOnline.Services.DoctorService;


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
@RequestMapping("/doctor")
public class DoctorController
{

    @Autowired
    private DoctorService doctorService;
    
    //AGREGAR - POST
    @PostMapping(value="/")
    public ResponseEntity<Doctor> agregar(@RequestBody Doctor doctor)
    {
        
        Doctor obj = doctorService.save(doctor);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //BORRAR
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Doctor> eliminar(@PathVariable Integer id){
    Doctor obj = doctorService.findById(id);
    if(obj!=null)
        doctorService.delete(id);
    else
        return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //EDITAR - PUT
    @PutMapping(value="/{id}")
    public ResponseEntity<Doctor> editar(@PathVariable Integer id, @RequestBody Doctor doctor)
    {
        Doctor obj = doctorService.findById(id);
        if(obj!=null)
        {
            obj.setEspecializacion(doctor.getEspecializacion());
            obj.setPersona(doctor.getPersona());
            
            
            
            
            doctorService.save(obj);
        }
        else
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    //BUSCAR TODOS
    @GetMapping("/list")
    public List<Doctor> consultarTodo()
    {
        return doctorService.findAll();
    }

    //BUSCAR POR ID
    @GetMapping("/list/{id}")
    public Doctor consultaPorId(@PathVariable Integer id)
    {
        return doctorService.findById(id);
    }
    
}
