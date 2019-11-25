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
public class Carrera extends  Profesor {

    private ArrayList<String> tesis;
    private ArrayList<String> seminarios;
    private String clsfcn;
    
    @Override
    public void ProfesorG() {
        System.out.println("Profesor de carrera de la UNAM");
    }

    public ArrayList<String> getTesis() {
        return tesis;
    }

    public void setTesis(ArrayList<String> tesis) {
        this.tesis = tesis;
    }

    public ArrayList<String> getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(ArrayList<String> seminarios) {
        this.seminarios = seminarios;
    }

    public String getClsfcn() {
        return clsfcn;
    }

    public void setClsfcn(String clsfcn) {
        this.clsfcn = clsfcn;
    }
    
    public void imprime(){
        int i = 0;
        this.ImprimeProfesor();
        System.out.println("CLASIFICACION:\t\t"+this.getClsfcn());
        System.out.println("Tesis:");
        for(var t : this.getTesis()){
            System.out.println("\t"+i++ +". "+t);
        }
        System.out.println("SEMINARIOS:");
        for(var t : this.getSeminarios()){
            System.out.println("\t"+i++ +". "+t);
        }
        
    }
    
}
