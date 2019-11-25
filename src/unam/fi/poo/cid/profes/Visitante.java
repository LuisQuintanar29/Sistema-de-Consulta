/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fi.poo.cid.profes;

/**
 *
 * @author root
 */
public class Visitante extends Profesor {
    
    private String asignatura;
    
    @Override
    public void ProfesorG() {
        System.out.println("Profesor visitante de la UNAM");
    }
    
    public String getAsignatura(){
        return asignatura;
    }
    
    public void setAsignatura(String asignatura){
        this.asignatura = asignatura;
    }
    public void imprime(){
        this.ImprimeProfesor();
        System.out.println("ASIGNATURA:\t\t"+this.getAsignatura());
    }
}
