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
public class Asignatura extends Profesor{

    private ArrayList<String> tesis;
     
    @Override
    public void ProfesorG() {
        System.out.println("Profesor de asignatura de la UNAM");
    }
    
    public ArrayList<String> getTesis() {
        return tesis;
    }

    public void setTesis(ArrayList<String> tesis) {
        this.tesis = tesis;
    }
    public void imprime(){
        int i = 0;
        this.ImprimeProfesor();
        System.out.println("Tesis:");
        for(var t : this.getTesis()){
            System.out.println("\t"+i++ +". "+t);
        }
    }
}
