/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traga_monedas;

import java.io.*;

public class Textos {
    
    String s;
    boolean existe = false;
    int fichas;
    
    boolean Leer(String nombre) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("/home/symq9485/Proyectos/UNIMAR/Estructura_de_Datos/Traga_Monedas/entrada.txt");
        BufferedReader br = new BufferedReader(fr);

        while((s = br.readLine())!=null){
            if (s.equals(nombre)){
                existe = true;
                break;

            }
        }
    
        return existe;
    }
    int LeerF(String nombre) throws FileNotFoundException, IOException{
        
        FileReader fr = new FileReader("/home/symq9485/Proyectos/UNIMAR/Estructura_de_Datos/Traga_Monedas/entrada.txt");
        BufferedReader br = new BufferedReader(fr);
        
        while((s = br.readLine())!=null){
                if (s.equals(nombre)){
                    fichas = Integer.parseInt(br.readLine());
                    break;
                }
        }
        
        return fichas;
    }
    
}
