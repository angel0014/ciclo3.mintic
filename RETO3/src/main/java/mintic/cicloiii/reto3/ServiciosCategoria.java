package mintic.cicloiii.reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosCategoria {
    @Autowired
    private RepositorioCategoria metodosCrud;

    public List<Categoria> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Categoria> getCategoria(int idCategoria){
        return metodosCrud.getCategoria(idCategoria);
    }

    public Categoria save(Categoria categoria){
        if(categoria.getId()==null){
            return metodosCrud.save(categoria);
        }else{
            // Optional<Categoria> categoria1=metodosCrud.getCategoria(categoria.getId());
            //if(categoria1.isEmpty()){
                return metodosCrud.save(categoria);

        //     }else{
        //         return categoria;

        //     }
        } 
    }

    public Categoria update(Categoria categoria){
        if(categoria.getId()!=null){
            Optional<Categoria> g=metodosCrud.getCategoria(categoria.getId());
            //if(!g.isEmpty()){
                
                if(categoria.getDescription()!=null){
                    g.get().setDescription(categoria.getDescription());
                }

                if(categoria.getName()!=null){
                    g.get().setName(categoria.getName());
                }
                metodosCrud.save(g.get());
            //}
            
        }
        return categoria;
    }

    public boolean deletecategoria(int idCategoria){
        Boolean d = getCategoria(idCategoria).map(categoria ->{
            metodosCrud.delete(categoria);
            return true;
        }).orElse(false);
        return d;

    }

    

}
    

