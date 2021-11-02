package mintic.cicloiii.reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCostume {
    @Autowired
    private RepositorioCostume metodosCrud;

    public List<Costume> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Costume> getCostume(int idCostume){
        return metodosCrud.getCostume(idCostume);
    }

    public Costume save(Costume costume){
        if(costume.getId()==null){
            return metodosCrud.save(costume);
        }else{
            //Optional<Custome> e=metodosCrud.getCustome(custome.getId());
            //if(e.isEmpty()){
                return metodosCrud.save(costume);

            //}else{
                //(return custome;

            //}
        } 
    }

    public Costume update(Costume costume){
        if(costume.getId()!=null){
            Optional<Costume> e=metodosCrud.getCostume(costume.getId());
            //if(!e.isEmpty()){
                if(costume.getName()!=null){
                    e.get().setName(costume.getName());

                }
                if(costume.getBrand()!=null){
                    e.get().setBrand(costume.getBrand());
                }
            
                if(costume.getYear()!=null){
                    e.get().setYear(costume.getYear());
                }

                if(costume.getDescription()!=null){
                    e.get().setDescription(costume.getDescription());
                }

                if(costume.getCategory()!=null){
                    e.get().setCategory(costume.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            //}else{
                //return costume;
            //}  
        }else{
            return costume;
        }
    }

    public boolean deleteCostume(int idCostume){
        Boolean aBoolean = getCostume(idCostume).map(costume ->{
            metodosCrud.delete(costume);
            return true;
        }).orElse(false);
        return aBoolean;

    }


}