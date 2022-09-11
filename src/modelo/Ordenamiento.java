/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Virez
 */
public class Ordenamiento {
   
    PoblacionEstudiantil obj = new PoblacionEstudiantil();

    public void setObj(PoblacionEstudiantil obj) {
        this.obj = obj;
    }
    
    public void cambiar(int p1, int p2){
         int auxTiket;
         String auxNombre;
         String auxDocumento;
         double auxPromedio;
  
      auxNombre = obj.getNombre(p1);
      obj.setNombre(p1,obj.getNombre(p2));
      obj.setNombre(p2, auxNombre);
      
      auxDocumento = obj.getNumDocumento(p1);
      obj.setNumDocumento(p1,obj.getNumDocumento(p2));
      obj.setNumDocumento(p2, auxDocumento);
      
      auxPromedio = obj.getPromedio(p1);
      obj.setPromedio(p1,obj.getPromedio(p2));
      obj.setPromedio(p2, auxPromedio);
      
      auxTiket = obj.getCantTikets(p1);
      obj.setCantTikets(p1,obj.getCantTikets(p2));
      obj.setCantTikets(p2, auxTiket);
    }
    
     public void ordenarBurbuja() {
        int i, j;
        for (i = 0; i <= obj.getTam() - 1; i++) {
            for (j = 0; j <= (obj.getTam() - i) - 2; j++) {
                if (obj.getCantTikets(j) > obj.getCantTikets(j + 1)) {
                    cambiar(j, j + 1);
                }
            }
        }
    }
     
     public void ordenarIntercambio()
     {
        int i, j; 
        for (i=0; i<=obj.getTam()-1; i++){ 
            for (j=i+1; j<=obj.getTam()-1; j++){ 
                if (obj.getCantTikets(i) > obj.getCantTikets(j)){ 
                    cambiar(i, j); 
                } 
            } 
        } 
    } 
     
     public void ordenarSeleccion(){ 
        for (int i=0; i<=obj.getTam()-1; i++){ 
            cambiar(i, posicionMenor(i)); 
        } 
    } 
     
     public void ordenarQuickSort(int primero, int ultimo)
     {
        int i, j, centro; 
        int pivote; 
        centro = (primero+ultimo)/2; 
        pivote = obj.getCantTikets(centro); 
        i = primero; 
        j = ultimo; 
        do{ 
            while((i <= j) && (obj.getCantTikets(i) < pivote)){ 
                i = i + 1; 
            } 
            while((i <= j) && (obj.getCantTikets(j) > pivote)){ 
                j = j - 1; 
            } 
            if(i <= j){ 
                cambiar(i, j); 
                i = i + 1; 
                j = j - 1; 
            } 
        }while(i <= j); 
        if(primero < j){ 
            ordenarQuickSort(primero, j); 
        } 
        if(i < ultimo){ 
            ordenarQuickSort(i, ultimo); 
        } 
    } 
     
     public int posicionMenor(int inicio){ 
        int i;
        int posMenor;
        int menorElemento;
        posMenor = inicio; 
        menorElemento = obj.getCantTikets(inicio); 
        for (i=inicio+1; i<=obj.getTam()-1; i++){ 
            if (obj.getCantTikets(i) < menorElemento){ 
                menorElemento = obj.getCantTikets(i); 
                posMenor = i; 
            } 
        }
        return posMenor; 
    } 
     
     public String mostrarOrdenado(){

        String datos = ""; 

        for (int i = 0; i < obj.getTam(); i++) {
            datos = datos + String.valueOf("Posicion " + i + ":" + "\n"
                    + "Nombre: "+obj.getNombre(i) + "\n"
                    + "Numero documento: "+ obj.getNumDocumento(i) + "\n"
                    + "Promedio: "+ obj.getPromedio(i) + "\n"
                    + "Tikets disponibles: "+obj.getCantTikets(i) + "\n"+ "\n");
        }
       return datos;   
    }      
}

