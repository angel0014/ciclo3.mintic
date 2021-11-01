package mintic.cicloiii.reto3;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class RepositorioCustome {

    @Autowired
    private InterfaceCustome crud;

    public List<Custome> getAll(){
        return (List<Custome>) crud.findAll();
    }

    public Optional<Custome> getCustome(int id){
        return crud.findById(id);
    }

    public Custome save(Custome custome){
        return crud.save(custome);
    }

    public void delete (Custome custome){
        crud.delete(custome);
    }

}