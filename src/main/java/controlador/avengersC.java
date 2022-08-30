package controlador;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Data;
import model.Vengador;
import service.APImarvel;

@Named(value = "avengersC")
@SessionScoped
@Data

public class avengersC implements Serializable {
    Vengador vengador;
    
    public avengersC(){
    vengador = new Vengador();
}
    
    public void llamar() {
        try{
            APImarvel.api(vengador);
        }catch(Exception e){
            System.out.println("ERROR"+e);
        }
    }
}


