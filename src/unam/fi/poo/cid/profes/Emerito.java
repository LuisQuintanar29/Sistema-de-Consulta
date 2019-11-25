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
public class Emerito extends Profesor{

    private String entidad;
    private ArrayList<String> contrib;
    
    @Override
    public void ProfesorG() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public ArrayList<String> getContrib() {
        return contrib;
    }

    public void setContrib(ArrayList<String> contrib) {
        this.contrib = contrib;
    }
    
    public void imprime(){
        int i = 0;
        this.ImprimeProfesor();
        System.out.println("ENTIDAD:\t\t"+this.getEntidad());
        System.out.println("CONTIBUCIONES:");
        for(var c: this.getContrib()){
            System.out.println("\t"+i+++". "+c);
        }
    }
}
