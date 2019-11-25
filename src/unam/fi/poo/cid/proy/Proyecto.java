/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fi.poo.cid.proy;

import java.util.ArrayList;

/**
 *
 * @author root
 */
public class Proyecto {
    
    private Integer cveProy;
    private String nomProy;
    private ArrayList<Integer> profesores;
    private ArrayList<Integer> alumnos;

    public Integer getCveProy() {
        return cveProy;
    }

    public void setCveProy(Integer cveProy) {
        this.cveProy = cveProy;
    }

    public String getNomProy() {
        return nomProy;
    }

    public void setNomProy(String nomProy) {
        this.nomProy = nomProy;
    }

    public ArrayList<Integer> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Integer> profesores) {
        this.profesores = profesores;
    }

    public ArrayList<Integer> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Integer> alumnos) {
        this.alumnos = alumnos;
    }
}
