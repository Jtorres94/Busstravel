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
        int [][] busSi = new int [11][4];
        int [][] busSv = new int [11][4];
        int [][] busCi = new int [11][4];
        int [][] busCv = new int [11][4];
        int [][] busVi = new int [11][4];
        int [][] busVv = new int [11][4];
        do{
            destino();
            destinos(numero(leerNumero()),busSi,busSv,busCi,busCv,busVi,busVv);
        }while(numero(leerNumero())!=4);
        System.out.println("_________________________");
        mostrar(busSi);
        System.out.println("_________________________");
        mostrar(busSv);
        System.out.println("_________________________");
        mostrar(busCi);
        System.out.println("_________________________");
        mostrar(busCv);
        System.out.println("_________________________");
        mostrar(busVi);
        System.out.println("_________________________");
        mostrar(busVv);
        
    }
    public static String leerNumero(){
        String n;
        Scanner leer = new Scanner(System.in);
        n=leer.nextLine();
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
        System.out.println("2) Concepcion");
        System.out.println("3) Valdivia");
        System.out.println("4) Salir");
    }
    public static void tipo(){
        System.out.println("Ingrese tipo de pasaje");
        System.out.println("1) Ida");
        System.out.println("2) Ida y vuelta");
        System.out.println("3) Salir");
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
    public static void CyR(int opc, int[][] bus){
        int asiento;
        switch(opc){
            case 1:
                System.out.println("Ingrese asiento");
                asiento=numero(leerNumero());
                if(comprado(bus,asiento(asiento))==true){
                    System.out.println("Comprado");
                }else if(comprado(bus,asiento(asiento))==false){
                pasajeC(bus,asiento(asiento));
                }
                break;
            case 2:
                System.out.println("Ingrese asiento");
                asiento=numero(leerNumero());
                if(reservado(bus,asiento(asiento))==true){
                    System.out.println("Reservado");
                }else if(comprado(bus,asiento(asiento))==false){
                pasajeR(bus,asiento(asiento));
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }
    public static void CyRIV(int opc, int[][] bus, int[][] busv){
        int asiento,asientov;
        switch(opc){
            case 1:
                System.out.println("Ingrese asiento ida");
                asiento=numero(leerNumero());
                if(comprado(bus,asiento(asiento))==true){
                    System.out.println("Comprado");
                }else if(comprado(bus,asiento(asiento))==false){
                pasajeC(bus,asiento(asiento));
                }
                 System.out.println("Ingrese asiento vuelta");
                asientov=numero(leerNumero());
                if(comprado(busv,asiento(asientov))==true){
                    System.out.println("Comprado");
                }else if(comprado(busv,asiento(asientov))==false){
                pasajeC(busv,asiento(asientov));
                }
                break;
                
            case 2:
                System.out.println("Ingrese asiento ida");
                asiento=numero(leerNumero());
                if(reservado(bus,asiento(asiento))==true){
                    System.out.println("Reservado");
                }else if(comprado(bus,asiento(asiento))==false){
                pasajeR(bus,asiento(asiento));
                }
                System.out.println("Ingrese asiento vuelta");
                asientov=numero(leerNumero());
                if(reservado(busv,asiento(asientov))==true){
                    System.out.println("Reservado");
                }else if(comprado(busv,asiento(asientov))==false){
                pasajeR(busv,asiento(asientov));
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Opcion no valida");
        }
    }
    public static void destinos(int opc, int [][] busSi, int [][]busSv, int [][] busCi, int [][]busCv, int [][] busVi, int [][]busVv){
        switch(opc){
            case 1:
                tipo();
                iIV(numero(leerNumero()),busSi,busSv);
                break;
            case 2:
                tipo();
                iIV(numero(leerNumero()),busCi,busCv);
                break;
            case 3:
                tipo();
                iIV(numero(leerNumero()),busVi,busVv);
                break;
            case 4:
                break;
            default: System.out.println("Opcion no valida");
        }
    }
    public static void iIV(int opc, int [][] busi, int [][]busv){
        switch(opc){
            case 1:
                comprar();
                CyR(numero(leerNumero()),busi);
                break;
            case 2:
                comprar();
                CyRIV(numero(leerNumero()),busi,busv);
                break;
            case 3:
                break;
            default: System.out.println("opcion no valida");
        }
    }
     public static boolean validar(String cadena){
    	try {
    		Integer.parseInt(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
        }
     public static int numero(String a){
            if(validar(a)==true){
                return Integer.parseInt(a);
        }else   
                System.out.println("Ingrese un numero");
                return 0;
        }
}
