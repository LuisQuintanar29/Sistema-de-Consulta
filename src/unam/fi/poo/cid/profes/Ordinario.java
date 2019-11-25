/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fi.poo.cid.profes;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Ordinario extends Profesor{

    private String entidad;
    private String tipoInv;
    private ArrayList<String> publica;
    
    @Override
    public void ProfesorG(){
        System.out.println("Profesor ordinario de la UNAM");
    }

    
    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getTipoInv() {
        return tipoInv;
    }

    public void setTipoInv(String tipoInv) {
        this.tipoInv = tipoInv;
    }

    public ArrayList<String> getPublica() {
        return publica;
    }

    public void setPublica(ArrayList<String> publica) {
        this.publica = publica;
    }
    
    public void imprime(){
        int i = 0;
        this.ImprimeProfesor();
        System.out.println("ENTIDAD:\t\t"+this.getEntidad());
        System.out.println("INVESTIGADOR:\t\t"+this.getTipoInv());
        System.out.println("PUBLICACIONES:");
        for(var p: this.getPublica()){
            System.out.println("\t"+i+++". "+p);
        }
    }
        
}
