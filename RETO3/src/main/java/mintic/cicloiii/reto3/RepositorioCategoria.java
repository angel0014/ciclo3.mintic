package mintic.cicloiii.reto3;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class RepositorioCategoria {
    @Autowired
    private InterfaceCategoria crud;

    public List<Categoria> getAll(){
        return (List<Categoria>) crud.findAll();
    }

    public Optional<Categoria> getCategoria(int id){
        return crud.findById(id);
    }

    public Categoria save(Categoria categoria){
        return crud.save(categoria);
    }

    public void delete (Categoria categoria){
        crud.delete(categoria);
    }

}
