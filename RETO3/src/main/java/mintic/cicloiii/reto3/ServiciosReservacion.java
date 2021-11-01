package mintic.cicloiii.reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosReservacion {
    @Autowired
    private RepositorioReservacion metodosCrud;

    public List<Reservacion> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Reservacion> getReservacion(int idReservacion){
        return metodosCrud.getReservacion(idReservacion);
    }

    public Reservacion save(Reservacion reservacion){
        if(reservacion.getIdReservation()==null){
            return metodosCrud.save(reservacion);
        }else{
            Optional<Reservacion> e=metodosCrud.getReservacion(reservacion.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservacion);

            }else{
                return reservacion;

            }
        } 
    }

    public Reservacion update(Reservacion reservacion){
        if(reservacion.getIdReservation()!=null){
            Optional<Reservacion> e=metodosCrud.getReservacion(reservacion.getIdReservation());
            if(!e.isEmpty()){
                if(reservacion.getStartDate()!=null){
                    e.get().setStartDate(reservacion.getStartDate());

                }
                if(reservacion.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservacion.getDevolutionDate());
                }

                if(reservacion.getStatus()!=null){
                    e.get().setStatus(reservacion.getStatus());
                }
            
               
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservacion;
            }  
        }else{
            return reservacion;
        }
    }

    public boolean deleteReservacion(int idReservacion){
        Boolean aBoolean = getReservacion(idReservacion).map(reservacion ->{
            metodosCrud.delete(reservacion);
            return true;
        }).orElse(false);
        return aBoolean;

    }


}
    

