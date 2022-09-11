/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author Virez
 */
public class PoblacionEstudiantil {

    private String nombre[];
    private String numDocumento[];
    private double promedio[];
    private int cantTikets[];
    private int tam;

    public PoblacionEstudiantil() {
        nombre = null;
        numDocumento = null;
        promedio = null;
        cantTikets = null;
        tam = 0;
    }
    
    public void crearVector(){
    nombre = new String[tam];
    numDocumento = new String[tam];
    promedio = new double[tam];
    cantTikets = new int[tam];
    }
    
    public void setNombre(int p, String dato){
    nombre[p] = dato;
    }
    
    public String getNombre(int p){
    return nombre[p];
    }
    
    public void setNumDocumento(int p, String dato){
    numDocumento[p] = dato;
    }
    
    public String getNumDocumento(int p){
    return numDocumento[p];
    }
    
    public void setPromedio(int p, double dato){
    promedio[p] = dato;
    }
    
    public double getPromedio(int p){
    return promedio[p];
    }
    
    public void setCantTikets(int p){
    int numTikets;
    if(getPromedio(p) >= 4.3){
        numTikets=5;
    }
    else if(getPromedio(p) >= 3.6 && getPromedio(p) < 4.3){
        numTikets = 3;
            }
    else if(getPromedio(p) >= 3.3 && getPromedio(p) < 3.6){
        numTikets = 2;
    }
    else{
    numTikets = 0;
    }
    
    cantTikets[p] = numTikets;
    }
    
    public void setCantTikets(int p, int numTikets){
    
         cantTikets[p] = numTikets;
    }
    
    public int getCantTikets(int p){
    return cantTikets[p];
    }
    
    public void setTam(int num){
    tam = num;
    }
    
    public int getTam(){
    return tam;
    }
    
    public void mostrarSinOrdenar() {

        String datos = ""; 

        for (int i = 0; i <= getTam() - 1; i++) {
            datos = datos + String.valueOf("Posicion " + i + ":" + "\n"+ "Nombre: "+getNombre(i) + "\n"
                    + "Numero documento: "+ getNumDocumento(i) + "\n"
                    + "Promedio: "+ getPromedio(i) + "\n"
                    + "Tikets disponibles: "+getCantTikets(i) + "\n"+ "\n");
        }

        JOptionPane.showMessageDialog(null, "======== Datos sin ordenar =======" + "\n" + datos);
        
    }
}

