/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fi.poo.alumno;

import unam.fi.poo.cid.personas.Persona;

/**
 *
 * @author root
 */
public class Estudiante extends Persona{

    private int noCuenta;
    private String carrera;
    
    public int getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    public void imprime(){
        this.imprimePersona();//< Metodo de la superclase
        System.out.println("NO. DE CUENTA:\t\t"+this.getNoCuenta());
        System.out.println("CURP:\t\t\t"+this.getCurp());
        System.out.println("CARRERA:\t\t"+this.getCarrera());
    }
}
