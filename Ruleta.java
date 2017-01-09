package traga_monedas;

import java.util.Random;

public class Ruleta {

    Nodo Ruleta = null;
    Nodo Aux;
    
    void Crear(){
        
        for (int i = 0; i <10; i++){
            
            Nodo nodo_n = new Nodo();
            nodo_n.dato = i;
            
            if (Ruleta == null){
                Ruleta = nodo_n;
                Aux = Ruleta;
            }
            else{
                if(nodo_n.dato != 9){
                    Aux.sig = nodo_n;
                    nodo_n.ant = Aux;
                    Aux = Aux.sig;
                }
                else{
                    Aux.sig = nodo_n;
                    nodo_n.ant = Aux;
                    nodo_n.sig = Ruleta;
                    Ruleta.ant = nodo_n;
                    Aux=Aux.sig;
                }
            }
        }
    }
    
    void Girar(){
        Random Rnd = new Random();
        int Alea = Rnd.nextInt(10);
        boolean Giro = Rnd.nextBoolean();
        
        if(Giro == true){
            while(Alea > -1){
                Ruleta = Ruleta.sig;
                Alea--;
            }
        }
        else{
            while(Alea > -1){
                Ruleta = Ruleta.ant;
                Alea--;
            }
        }
    }
}
