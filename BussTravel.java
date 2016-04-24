/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busstravel;

/**
 *
 * @author Javier
 */
import java.util.*;
public class BussTravel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] bus = new int [11][4];
        do{
            System.out.println("Ingrese opcion");
            opc(leerNumero(),bus);
        }while(leerNumero()!=2);
    }
    public static int leerNumero(){
        int n;
        Scanner leer = new Scanner(System.in);
        n=leer.nextInt();
        return n;
    }
    public static int [][] bus(){
        int [][] matriz = new int [11][4];
        return matriz;
    }
    public static void mostrar(int [][]matriz){
      int i,j;
      for ( i=0; i < matriz.length; i++) {
      for ( j=0; j < matriz[i].length; j++) {
        System.out.print (matriz[i][j]+"\t");
      }
          System.out.println();
    }
    }
    public static void comprar(){
        System.out.println("Ingrese opción");
        System.out.println("1) Comprar pasaje");
        System.out.println("2) Reservar pasaje");
        System.out.println("3) Salir");
    }
    public static void destino(){
        System.out.println("Ingrese destino");
        System.out.println("1) Santiago");
        System.out.println("2) Valdivia");
        System.out.println("3) Concepción");
    }
    public static void tipo(){
        System.out.println("1) Ida");
        System.out.println("2) Ida y vuelta");
    }
    public static void tarifa(){
        System.out.println("Ingrese tarifa");
        System.out.println("1) Adulto");
        System.out.println("2) Estudiante");
    }
    public static int[] asiento(int asiento){
        int fila=0,columna=0;
        if (asiento<=4){
            fila=0;
            columna=(asiento-1);            
        }else if(asiento>=5){
            fila=(int)(asiento-1)/4;
            columna=(asiento-1)%4;
        }
        return new int []{fila,columna};
    }
    public static int[][] pasajeC(int [][]matriz,int []asiento){
        matriz[asiento[0]][asiento[1]]=1;
        return matriz;
    }
    public static int[][] pasajeR(int [][]matriz,int []asiento){
        matriz[asiento[0]][asiento[1]]=2;
        return matriz;
    }
    public static boolean comprado(int[][]matriz,int[]asiento){
        if(matriz[asiento[0]][asiento[1]]==2){
            return true;
        }else
            return false;
    }
    public static boolean reservado(int[][]matriz,int[]asiento){
        if(matriz[asiento[0]][asiento[1]]==2){
            return true;
        }else
            return false;
    }
    public static void opc(int opc, int[][] bus){
        int asiento;
        switch(opc){
            case 1:
                System.out.println("Ingrese asiento");
                asiento=leerNumero();
                if(comprado(bus,asiento(asiento))==true){
                    System.out.println("Comprado");
                }else if(comprado(bus,asiento(asiento))==false){
                pasajeC(bus,asiento(asiento));
                }
                break;
            case 2:
                System.out.println("Ingrese asiento");
                asiento=leerNumero();
                if(reservado(bus,asiento(asiento))==true){
                    System.out.println("Reservado");
                }else if(comprado(bus,asiento(asiento))==false){
                pasajeR(bus,asiento(asiento));
                }
                break;
        }
    }
}
