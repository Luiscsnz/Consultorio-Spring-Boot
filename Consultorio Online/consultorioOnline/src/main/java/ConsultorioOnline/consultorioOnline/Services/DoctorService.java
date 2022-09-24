/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ConsultorioOnline.consultorioOnline.Services;


import ConsultorioOnline.consultorioOnline.Models.Doctor;
import java.util.List;

public interface DoctorService
{
    public Doctor save(Doctor doctor);
    public void delete(Integer id);
    public Doctor findById(Integer id);
    public List<Doctor> findAll();
}
