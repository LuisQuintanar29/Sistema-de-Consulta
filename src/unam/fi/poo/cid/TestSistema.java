/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fi.poo.cid;

import unam.fi.poo.cid.consulta.Sistema;

/**
 *
 * @author root
 */
public class TestSistema {
    public static void main(String args[]){
        Sistema sistema = new Sistema();
        sistema.cargarInformacion();
        sistema.despliegaMenu();
    }
}
