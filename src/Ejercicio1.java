
//CONSIGNA:

//Otro TXT que genere las instrucciones:
// Dificultad: Media
// Tiempo total 1 h 25 m
// Elaboración 10 m
// Cocción 1 h 15 m
// Reposo 5 m


// Estructura del programa:
// Una clase de Ingredientes
// Una clase de preparacion
// Una interfaz que implemente el metodo abstracto generaSalida
//Una vez generado el archivo txt subirlo a traves de la consola a nuestro repositorio remoto de GitHub
// Entregables:
// Captura del CMD (consola)
// LINK del Repositorio

import java.io.*;
import java.util.*;

interface interfaz{
    void generaSalida(String direccion,String datos);
}
class GrabarArchivo implements interfaz{
    public void generaSalida(String direccion,String datos){
        File archivo = new File(direccion);
        try {
            FileWriter escritor = new FileWriter(archivo);
            BufferedWriter buffer = new BufferedWriter(escritor);
            buffer.write(datos);
            buffer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Ingredientes{
    String ingrediente;

    public Ingredientes(String ingrediente) {
        this.ingrediente = ingrediente;
    }
}

class Preparacion{
    String instruccion;

    public Preparacion(String instruccion) {
        this.instruccion = instruccion;
    }
}

public class Ejercicio1 {
    public static void main(String[] args) {
        ArrayList ingredientes = new ArrayList<Ingredientes>();
        ingredientes.add(new Ingredientes("Arroz bomba 1500 g"));
        ingredientes.add(new Ingredientes("Pollo de corral 1"));
        ingredientes.add(new Ingredientes("Conejo 0.5"));
        ingredientes.add(new Ingredientes("Judía verde plana 500 g"));
        ingredientes.add(new Ingredientes("Garrofó 500 g"));
        ingredientes.add(new Ingredientes("Alcachofa (opcional) 500 g"));
        ingredientes.add(new Ingredientes("Aceite de oliva virgen extra"));
        ingredientes.add(new Ingredientes("Pimentón dulce"));
        ingredientes.add(new Ingredientes("Tomate triturado"));
        ingredientes.add(new Ingredientes("Azafrán"));
        ingredientes.add(new Ingredientes("Romero fresco"));
        ingredientes.add(new Ingredientes("Sal"));

        ArrayList instrucciones = new ArrayList<Preparacion>();
        instrucciones.add(new Preparacion("Dificultad: Media"));
        instrucciones.add(new Preparacion("Tiempo total 1 h 25 m"));
        instrucciones.add(new Preparacion("Elaboración 10 m"));
        instrucciones.add(new Preparacion("Cocción 1 h 15 m"));
        instrucciones.add(new Preparacion("Reposo 5 m"));

        Iterator<Ingredientes> iter1 = ingredientes.iterator();
        StringBuilder str1 = new StringBuilder();
        while (iter1.hasNext()) {
            str1.append(iter1.next().ingrediente + "\n");
        }

        Iterator<Preparacion> iter2 = instrucciones.iterator();
        StringBuilder str2 = new StringBuilder();
        while (iter2.hasNext()) {
            str2.append(iter2.next().instruccion + "\n");
        }

        GrabarArchivo grabar = new GrabarArchivo();

        String nombre1 = "Ingredientes.txt";
        grabar.generaSalida(nombre1,str1.toString());

        String nombre2 = "Instrucciones.txt";
        grabar.generaSalida(nombre2,str2.toString());

    }
}
