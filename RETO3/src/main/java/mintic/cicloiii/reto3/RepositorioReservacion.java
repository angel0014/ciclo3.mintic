package mintic.cicloiii.reto3;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
@Repository

public class RepositorioReservacion {
    
    @Autowired
    private InterfaceReservacion crud4;

    public List<Reservacion> getAll(){
        return (List<Reservacion>) crud4.findAll();
    }

    public Optional<Reservacion> getReservacion(int id){
        return crud4.findById(id);
    }

    public Reservacion save(Reservacion reservacion){
        return crud4.save(reservacion);
    }

    public void delete (Reservacion reservacion){
        crud4.delete(reservacion);
    }

}
    


