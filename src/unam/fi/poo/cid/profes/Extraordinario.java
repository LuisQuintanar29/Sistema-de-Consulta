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
public class Extraordinario extends Profesor{

    private ArrayList<String> publica;
    private String ncnldd;
    
    @Override
    public void ProfesorG() {
        System.out.println("Profesor extraordinario de la UNAM");
    }
    
    public ArrayList<String> getPublica() {
        return publica;
    }

    public void setPublica(ArrayList<String> publica) {
        this.publica = publica;
    }

    public String getNcnldd() {
        return ncnldd;
    }

    public void setNcnldd(String ncnldd) {
        this.ncnldd = ncnldd;
    }
    public void imprime(){
        int i = 0;
        this.ImprimeProfesor();
        System.out.println("NACIONALIDAD:\t\t"+this.getNcnldd());
        System.out.println("PUBLICACIONES:");
        for(var p: this.getPublica()){
            System.out.println("\t"+ i+++". "+p );
        }
    }
}
