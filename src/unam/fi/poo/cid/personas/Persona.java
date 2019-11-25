/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fi.poo.cid.personas;

import java.util.Date;

/**
 *
 * @author root
 */
public class Persona {
    private String nombres;
    private String apellidoP;
    private String apellidoM;
    private Date fechaNac;
    private String curp;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
    public void imprimePersona(){
        System.out.println("NOMBRE:\t\t\t"+this.getApellidoP()
                +" "+this.getApellidoM()
                +", "+this.getNombres());
        System.out.println("NACIMIENTO:\t\t"+this.getFechaNac());
    }
}
