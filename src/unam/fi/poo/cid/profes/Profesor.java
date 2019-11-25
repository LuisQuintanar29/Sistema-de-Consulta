/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fi.poo.cid.profes;

import java.util.Date;
import unam.fi.poo.cid.personas.Persona;

/**
 *
 * @author root
 */
public abstract class Profesor extends Persona{
    
    private int noTrabajador;
    private String tipoProf;
    private String rfc;
    private String titulo;
    private Date fechaCont;
    
    public abstract void ProfesorG();
    public abstract void imprime();

    public int getNoTrabajador() {
        return noTrabajador;
    }

    public void setNoTrabajador(int noTrabajador) {
        this.noTrabajador = noTrabajador;
    }

    public String getTipoProf() {
        return tipoProf;
    }

    public void setTipoProf(String tipoProf) {
        this.tipoProf = tipoProf;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Date getFechaCont() {
        return fechaCont;
    }

    public void setFechaCont(Date fechaCont) {
        this.fechaCont = fechaCont;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void ImprimeProfesor(){
        imprimePersona();
        System.out.println("CONTRATACION:\t\t"+this.getFechaCont());
        System.out.println("TIPO:\t\t\t"+this.getTipoProf());
        System.out.println("TITULO:\t\t\t"+this.getTitulo());
        System.out.println("RFC\t\t");
        for(var x: this.getRfc().toCharArray()){System.out.print("*");}
        System.out.print("\n");
        System.out.println("CURP:\t\t");
        for(var x: this.getCurp().toCharArray()){System.out.print("*");}
        System.out.print("\n");
    }

}
