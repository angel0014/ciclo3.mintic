package mintic.cicloiii.reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMensaje {
    @Autowired
    private RepositorioMensaje metodosCrud;

    public List<Mensaje> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Mensaje> getMensaje(int messageId){
        return metodosCrud.getMensaje(messageId);
    }

    public Mensaje save(Mensaje message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            //Optional<Mensaje> e=metodosCrud.getMensaje(message.getIdMessage());
            //if(e.isEmpty()){
                return metodosCrud.save(message);

            //}else{
                //return message;

            //}
        } 
    }

    public Mensaje update(Mensaje message){
        if(message.getIdMessage()!=null){
            Optional<Mensaje> e=metodosCrud.getMensaje(message.getIdMessage());
            //if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());

                }
               
                metodosCrud.save(e.get());
                return e.get();
            //}else{
                //return message;
            //}  
        }else{
            return message;
        }
    }

    public boolean deleteMessage(int idMessage){
        Boolean aBoolean = getMensaje(idMessage).map(message ->{
            metodosCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;

    }


}
    

