package traga_monedas;

import java.io.*;

public class Traga_monedas {
    
    static String nombre;
    static String dato1;
    static int fichas;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        System.out.print("Ingrese su Nombre: ");
        try{
            nombre = br.readLine();
        
            Textos arc = new Textos();
            fichas = arc.LeerF(nombre);
            int apuesta = 0;
            int ganancia = 0;
            String opcion;
            boolean continuar = true;
            
            if(true==arc.Leer(nombre)){
                while((fichas>0)&(continuar == true)){
                    System.out.println("Usted dispone de " + fichas + ".");
                    System.out.println("Ingrese la cantidad de monedas a apostar:\nA.- 1.\nB.- 2.\nC.- 3.\nD.- 5.");
                    opcion = br.readLine();
                    
                    switch(opcion.toLowerCase()){
                        case("a"):
                            apuesta = 1;
                            break;
                        case("b"):
                            apuesta = 2;
                            break;
                        case("c"):
                            apuesta = 3;
                            break;
                        case("d"):
                            apuesta = 5;
                            break;
                        default:
                            apuesta = 1;
                    }
                    
                    if(apuesta<=fichas){
                        fichas = fichas - apuesta;
                        System.out.println("Presione ENTER para girar.");
                        System.in.read();
                        Ruleta Ruleta1 = new Ruleta();
                        Ruleta Ruleta2 = new Ruleta();
                        Ruleta Ruleta3 = new Ruleta();
                        
                        Ruleta1.Crear();
                        Ruleta2.Crear();
                        Ruleta3.Crear();

                        Ruleta1.Girar();
                        Ruleta2.Girar();
                        Ruleta3.Girar();
                        
                        if((Ruleta1.Ruleta.dato == Ruleta2.Ruleta.dato)&(Ruleta2.Ruleta.dato==Ruleta3.Ruleta.dato)){
                            ganancia = apuesta * 10;
                            fichas = fichas + ganancia;
                            
                            System.out.println("Usted ha acertado con los numeros: " 
                            + Ruleta1.Ruleta.dato + "," + Ruleta2.Ruleta.dato + "," + Ruleta3.Ruleta.dato);
                            dato1 = Ruleta1.Ruleta.dato + "," + Ruleta2.Ruleta.dato + "," + Ruleta3.Ruleta.dato;
                            Traga_monedas archivo = new Traga_monedas();
                            archivo.Guardar(dato1, fichas, ganancia, apuesta);
                        }
                        else{
                            System.out.println("Mala suerte, usted ha perdido. Los numeros fueron: " + Ruleta1.Ruleta.dato + "," + Ruleta2.Ruleta.dato + "," + Ruleta3.Ruleta.dato);
                            System.out.println("Mas suerte en tu proximo intento.");
                            dato1 = Ruleta1.Ruleta.dato + "," + Ruleta2.Ruleta.dato + "," + Ruleta3.Ruleta.dato;
                            Traga_monedas archivo = new Traga_monedas();
                            archivo.Guardar(dato1, fichas, ganancia, apuesta);
                        }
                        System.out.println("¿Desea continuar jugando?: S/N");
                        opcion = br.readLine();
                        switch(opcion.toLowerCase()){
                            case("s"):
                                continuar = true;
                                break;
                            case("n"):
                                continuar = false;
                                System.out.println("Adios");
                                break;
                        }
                    }
                    else{
                        System.out.println("Su apuesta no puede ser mayor a su numero de fichas.");
                    }
                }
                if(fichas == 0){
                    System.out.println("Usted ya no dispone de fichas para apostar.");
                }
            }
            else{
                System.out.println("El usuario no existe");
            }
        }catch(Exception e){
            System.err.println("Se produjo un Error: " + e.getMessage() + ".Por favor vuelva a ingresar los datos");
        }
    }
    
    void Guardar (String ruleta, int ficha, int ganancia, int apuesta) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("/home/symq9485/Proyectos/UNIMAR/Estructura_de_Datos/Traga_Monedas/resultados.txt", true)); //cambia esto al directorio de tu archivo//
        bw.newLine();
        bw.write("Jugador: " + this.nombre + "\n" + "Ruleta: " + ruleta + "\n" +
                "Fichas: " + ficha + "\n" + "Apuesta: " + apuesta + "\n" + 
                "Ganancias: " + ganancia);
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
