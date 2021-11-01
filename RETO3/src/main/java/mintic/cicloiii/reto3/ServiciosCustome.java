package mintic.cicloiii.reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCustome {
    @Autowired
    private RepositorioCustome metodosCrud;

    public List<Custome> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Custome> getCustome(int idCustome){
        return metodosCrud.getCustome(idCustome);
    }

    public Custome save(Custome custome){
        if(custome.getId()==null){
            return metodosCrud.save(custome);
        }else{
            Optional<Custome> e=metodosCrud.getCustome(custome.getId());
            if(e.isEmpty()){
                return metodosCrud.save(custome);

            }else{
                return custome;

            }
        } 
    }

    public Custome update(Custome custome){
        if(custome.getId()!=null){
            Optional<Custome> e=metodosCrud.getCustome(custome.getId());
            if(!e.isEmpty()){
                if(custome.getName()!=null){
                    e.get().setName(custome.getName());

                }
                if(custome.getBrand()!=null){
                    e.get().setBrand(custome.getBrand());
                }
            
                if(custome.getYear()!=null){
                    e.get().setYear(custome.getYear());
                }

                if(custome.getDescription()!=null){
                    e.get().setDescription(custome.getDescription());
                }

                if(custome.getCategory()!=null){
                    e.get().setCategory(custome.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return custome;
            }  
        }else{
            return custome;
        }
    }

    public boolean deleteCustome(int idCustome){
        Boolean aBoolean = getCustome(idCustome).map(custome ->{
            metodosCrud.delete(custome);
            return true;
        }).orElse(false);
        return aBoolean;

    }


}