/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unam.fi.poo.cid.consulta;

import java.io.*;
import java.util.*;
import unam.fi.poo.cid.profes.*;
import unam.fi.poo.alumno.Estudiante;
import unam.fi.poo.cid.personas.Persona;
import unam.fi.poo.cid.proy.Proyecto;

/**
 *
 * @author root
 */
public class Sistema {

    private final HashMap<Integer, Proyecto> proyectos;
    private final HashMap<Integer, Persona> personas;
    
    public Sistema(){
        proyectos = new HashMap<>();
        personas = new HashMap<>();
    }
    
    public HashMap<Integer, Proyecto> getProyectos() {
        return proyectos;
    }

    public HashMap<Integer, Persona> getPersonas() {
        return personas;
    }
    
    public void cargarInformacion(){
        this.cargarEstudiantes();
        this.cargarProfesores();
        this.cargarProyectos();
    }
    
    private void cargarEstudiantes(){
        File myFile = new File("info/info_siae.csv");
        File fileD = new File("info/err_uplicado.csv");
        File fileI = new File("info/err_incompletos.csv");
        ArrayList<String> incompletos = new ArrayList<>();
        ArrayList<String> repetidos = new ArrayList<>();

        try{
            /*
                Borramos los archivos que ya existian, después creamos
                unos nuevos para empezar a escribir en ellos desde cero,
                y así poder agregar alumno, profesores y proyectos en el
                mismo archivo sin borrar lo agregado anteriormente
            */
            fileD.delete();
            fileI.delete();
            fileD.createNewFile();
            fileI.createNewFile();
            
            BufferedReader input = new BufferedReader(new FileReader(myFile));
            String s = input.readLine();
            while(s!= null){
                String[] in = s.split("\\|");//< Dividimos la entrada
                boolean esCompleto = true;//< Bandera, indica si esta completo
                Estudiante estudiante = new Estudiante();
                if( in.length != 5 ){
                    /*
                        Si no tiene la longitud, no tiene sentido revisarla
                    */
                    esCompleto = false;//<Cambiamos el valor de la bandera
                }else{
                    for( String var : in ){ if(var.isEmpty()){ esCompleto = false; } }
                    // A continuacion dividimos en nombre, apellidoP, apellidoM
                    String n[] = in[1].split(",");
                    if(n.length != 3){ esCompleto = false; }
                    else{
                        for( String v : n){
                            if(v.isEmpty()){ esCompleto = false; }
                        }
                    }
                    
                }
                
                if( esCompleto ){
                    /*
                        Si esta completo podemos agregar todos los
                        datos a un objeto del tipo Estudiante
                    */
                    String n[] = in[1].split(",");
                    estudiante.setNoCuenta(Integer.parseInt(in[0]));
                    estudiante.setNombres(n[0]);
                    estudiante.setApellidoP(n[1]);
                    estudiante.setApellidoM(n[2]);
                    estudiante.setFechaNac(new Date(in[2]));
                    estudiante.setCurp(in[3]);
                    estudiante.setCarrera(in[4]);
                    if(!personas.containsKey(estudiante.getNoCuenta())){
                        // Si no existe en el mapa, lo podemos agregar
                        personas.put(estudiante.getNoCuenta(), estudiante);
                    }else{
                        // Si ya existe el registro lo agregamos a una lista
                        // de repetidos
                        repetidos.add(s);
                    }
                }else{
                    // Si el registro esta incompleto lo agregamos a una
                    // lista de incompletos
                    incompletos.add(s);
                }
                s = input.readLine();
                
            }
            PrintWriter output;
            //Agregamos los repetidos e incompletos a su archivo
            output = new PrintWriter(new FileWriter(fileD.getAbsoluteFile(),true));
            for(String v: repetidos){ output.println(v); }
            output.close();
            output = new PrintWriter(new FileWriter(fileI.getAbsoluteFile(),true));
            for(String v: incompletos){ output.println(v); }
            //Cerramos las variables de lectura y escritura
            output.close();
            input.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found "+ myFile);
            System.exit(1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void cargarProfesores(){
        File myFile = new File("info/info_dgapa.csv");
        File fileD = new File("info/err_uplicado.csv");
        File fileI = new File("info/err_incompletos.csv");
        ArrayList<String> incompletos = new ArrayList<>();
        ArrayList<String> repetidos = new ArrayList<>();
        try{
            BufferedReader input = new BufferedReader(new FileReader(myFile));
            String s = input.readLine();
            while(s!= null){
                String[] in = s.split("\\|");
                Profesor profesor = null;
                boolean esCompleto = true;
                String tipoProfesor = in[1].toLowerCase();
                /*
                    Verificamos que tipo de profesor es y creamos un objeto
                    que corresponda a lo que dice en el archivo
                */
                if( tipoProfesor.equalsIgnoreCase("asignatura") ){
                    if( in.length != 5 ){ esCompleto = false; }
                    profesor = new Asignatura();
                }else{
                    if(tipoProfesor.equalsIgnoreCase("emerito")  || tipoProfesor.equalsIgnoreCase("emérito")){
                        tipoProfesor = "emerito";
                        if( in.length != 6 ){ esCompleto = false; }
                        profesor = new Emerito();
                    }else{
                        if( tipoProfesor.equalsIgnoreCase("carrera") ){
                            if( in.length != 7 ){ esCompleto = false; }
                            profesor = new Carrera();
                        }else{
                            if( tipoProfesor.equalsIgnoreCase("extraordinario") ){
                                if( in.length != 6 ){ esCompleto = false; }
                                profesor = new Extraordinario();
                            }else{
                                if( tipoProfesor.equalsIgnoreCase("ordinario") ){
                                    if( in.length != 7 ){ esCompleto = false; }
                                    String p[] = in[6].split(";");
                                    for(String v: p){
                                        if(v.isEmpty()){ esCompleto = false; }
                                    }
                                    profesor = new Ordinario();
                                }else{
                                    if( tipoProfesor.equalsIgnoreCase("visitante") ){
                                        if( in.length != 5 ){ esCompleto = false; }
                                        profesor = new Visitante();
                                    }
                                }
                            }
                        }
                    }
                }
                /*
                    Verificamos que exista una lista o datos entre los 
                    simbolos de tuberia "|"
                */
                if(esCompleto){
                    for( String var : in ){ if(var.isEmpty()){ esCompleto = false; } }
                    if(esCompleto){ 
                        String n[] = in[2].split(",");
                        if(n.length != 3){ esCompleto = false; }
                        else{
                            for( String v : n){
                                if(v.isEmpty()){ esCompleto = false; }
                            }
                        }
                        if(esCompleto){
                            String f[] = in[3].split(",");
                            if(f.length != 5 ){ esCompleto = false; }
                            else{
                                for( String v : f){
                                    if(v.isEmpty()){ esCompleto = false; }
                                }
                            }
                        }
                    }
                }
                if( esCompleto && profesor != null ){
                    /*
                        Si esta completo y se creo un objeto del tipo
                        profesor se agregan los datos donde corresponda
                    */
                    String n[] = in[2].split(",");
                    String n1[] = in[3].split(",");
                    profesor.setNoTrabajador(Integer.parseInt(in[0]));
                    profesor.setTipoProf(in[1]);
                    profesor.setNombres(n[0]);
                    profesor.setApellidoP(n[1]);
                    profesor.setApellidoM(n[2]);
                    profesor.setFechaNac(new Date(n1[0]));
                    profesor.setCurp(n1[1]);
                    profesor.setRfc(n1[2]);
                    profesor.setFechaCont(new Date(n1[3]));
                    profesor.setTitulo(n1[4]);
                    switch(tipoProfesor){
                        case "ordinario":
                            ArrayList<String> lista = new ArrayList<>();
                            String p[] = in[6].split(";");
                            for(String v: p){
                                lista.add(v);
                            }
                            ((Ordinario)profesor).setEntidad(in[4]);
                            ((Ordinario)profesor).setTipoInv(in[5]);
                            ((Ordinario)profesor).setPublica(lista);
                            break;
                        case "visitante":
                            ((Visitante)profesor).setAsignatura(in[4]);
                            break;
                        case "extraordinario":
                            ArrayList<String> list = new ArrayList<>();
                            String d[] = in[4].split(";");
                            for(String v: d){
                                list.add(v);
                            }
                            ((Extraordinario)profesor).setPublica(list);
                            ((Extraordinario)profesor).setNcnldd(in[5]);
                            break;
                        case "emerito":
                            ArrayList<String> cont = new ArrayList<>();
                            String c[] = in[4].split(";");
                            for(String v: c){
                                cont.add(v);
                            }
                            ((Emerito)profesor).setEntidad(n[4]);
                            ((Emerito)profesor).setContrib(cont);
                            break;
                        case "asignatura":
                            ArrayList<String> tesis = new ArrayList<>();
                            String t[] = in[4].split(";");
                            for(String v: t){
                                tesis.add(v);
                            }
                            ((Asignatura)profesor).setTesis(tesis);
                            break;
                        case "carrera":
                            ArrayList<String> tesis1 = new ArrayList<>();
                            String t1[] = in[4].split(";");
                            for(String v: t1){
                                tesis1.add(v);
                            }
                            ArrayList<String> sem = new ArrayList<>();
                            String se[] = in[4].split(";");
                            for(String v: se){
                                sem.add(v);
                            }
                            ((Carrera)profesor).setTesis(tesis1);
                            ((Carrera)profesor).setClsfcn(in[5]);
                            ((Carrera)profesor).setSeminarios(sem);
                            break;
                    }
                    if(!personas.containsKey(profesor.getNoTrabajador())){
                        //Si no extiste el registro en el mapa...
                        personas.put(profesor.getNoTrabajador(),profesor);
                    }else{
                        // Ya existe el registro
                        repetidos.add(s);
                    }
                }else{
                    // El registro esta incompleto
                    incompletos.add(s);
                }
                s = input.readLine();
                
            }
            PrintWriter output;
            output = new PrintWriter(new FileWriter(fileD.getAbsoluteFile(),true));
            for(String v: repetidos){ output.println(v); }
            output.close();
            output = new PrintWriter(new FileWriter(fileI.getAbsoluteFile(),true));
            for(String v: incompletos){ output.println(v); }
            output.close();
            input.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found: "+myFile);
            System.exit(1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void cargarProyectos(){
        File myFile = new File("info/info_proy.csv");
        File fileD = new File("info/err_uplicado.csv");
        File fileI = new File("info/err_incompletos.csv");
        ArrayList<String> incompletos = new ArrayList<>();
        ArrayList<String> repetidos = new ArrayList<>();
        try{
            BufferedReader input = new BufferedReader(new FileReader(myFile));
            String s = input.readLine();
            while(s!= null){
                String[] in = s.split("\\|");
                boolean esCompleto = true;
                if( in.length  != 4 ){ esCompleto = false; }
                else{
                    for(String v : in){ if( v.isEmpty() ){ esCompleto = false; } }
                }
                if(esCompleto){
                    if(!proyectos.containsKey(Integer.parseInt(in[0]))){
                        Proyecto proyecto = new Proyecto();
                        ArrayList<Integer> listP = new ArrayList<>();
                        ArrayList<Integer> listA = new ArrayList<>();
                        String prof[] = in[2].split(";");
                        String alum[] = in[3].split(";");
                        for(String v: prof){
                            listP.add(Integer.parseInt(v));
                        }
                        for(String v: alum){
                            listA.add(Integer.parseInt(v));
                        }
                        proyecto.setCveProy(Integer.parseInt(in[0]));
                        proyecto.setNomProy(in[1]);
                        proyecto.setProfesores(listP);
                        proyecto.setAlumnos(listA);
                        
                        proyectos.put(Integer.parseInt(in[0]), proyecto);
                    }else{
                         // Ya existe el registro
                        repetidos.add(s);
                    }
                    
                }else{
                    // El registro esta incompleto
                    incompletos.add(s);
                }
                
                
                s = input.readLine();
                
            }
            PrintWriter output;
            output = new PrintWriter(new FileWriter(fileD.getAbsoluteFile(),true));
            for(String v: repetidos){ output.println(v); }
            output.close();
            output = new PrintWriter(new FileWriter(fileI.getAbsoluteFile(),true));
            for(String v: incompletos){ output.println(v); }
            output.close();
            input.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found"+myFile);
            System.exit(1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void despliegaMenu(){
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        System.out.println("SISTEMA DE CONSULTA DE PROYECTOS DE LA CID");
        System.out.println("PROYECTO:");
        if( proyectos.values().isEmpty() ){
            System.out.println("NO HAY PROYECTOS DISPONIBLES");
        }else{
            for( Proyecto p : proyectos.values()){
                System.out.println("\t"+p.getCveProy() +". "+p.getNomProy());   
            }
        }
        System.out.println("INTRODUZCA LA CLAVE DEL PROYECTO:  ");
        Integer entrada = scanner.nextInt();
        HashMap<Integer,Proyecto> p = this.getProyectos();
        Proyecto a = p.get(entrada);
        if(a != null){
            System.out.println("NOMBRE DEL PROYECTOS: \t"+a.getNomProy());
            System.out.println("");
            System.out.println("PROFESOR(ES):");
            for(Integer profesores: a.getProfesores()){
                Profesor profesor = ((Profesor)personas.get(profesores));
                if(profesor != null){
                    profesor.imprime();   
                }else{
                    System.out.println("Un profesor del proyecto no "
                            + "se encuentra en la base de datos");
                }
            }
            System.out.println("");
            System.out.println("ESTUDIANTE(S):");
            for(var alumnos: a.getAlumnos()){
                Estudiante estudiante = ((Estudiante)personas.get(alumnos));
                if(estudiante != null){
                    estudiante.imprime();
                }else{
                    System.out.println("Un estudiante del proyecto no"
                            + " se encuentra en la base de datos");
                }
            }
            System.out.println("");
        }else{
            System.out.println("Clave no valida");
        }
    }
}
