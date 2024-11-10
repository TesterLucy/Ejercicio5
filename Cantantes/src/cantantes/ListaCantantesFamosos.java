/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cantantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class  ListaCantantesFamosos implements Iterable<CantanteFamoso> {
    private ArrayList<CantanteFamoso> listaCantantesFamosos = new ArrayList<>();

    public void añadirCantante(CantanteFamoso cantante) {
        listaCantantesFamosos.add(cantante);
    }
    public void eliminarCantante(String nombre) {
        Iterator<CantanteFamoso> iterator = listaCantantesFamosos.iterator();
        while (iterator.hasNext()) {
            CantanteFamoso cantante = iterator.next();
            if (cantante.getNombre().equals(nombre)) {
                iterator.remove();
                System.out.println("Se ha eliminado el cantante: " + nombre);
                return;
            }
        }
        System.out.println("No se encontró el cantante con nombre: " + nombre);
    }
    public void mostrarLista() {
        Iterator<CantanteFamoso> iterator = listaCantantesFamosos.iterator();
        while (iterator.hasNext()) {
            CantanteFamoso cantante = iterator.next();
            System.out.println("Nombre: " + cantante.getNombre() + ", Disco con más ventas: " + cantante.getDiscoConMasVentas() + ", Total de ventas: "+ cantante.getTotalDeVentas());
        }
    }
    public void modificarCantante(String nombre, String nuevoNombre, String nuevoDisco, int nuevasVentas) {
        for (CantanteFamoso cantante : listaCantantesFamosos) {
            if (cantante.getNombre().equals(nombre)) {
                cantante.setNombre(nuevoNombre);
                cantante.setDiscoConMasVentas(nuevoDisco);
                cantante.setTotalDeVentas(nuevasVentas);
                System.out.println("Se ha modificado el cantante: " + nombre);
                return;
            }
        }
        System.out.println("No se encontró el cantante con nombre: " + nombre);
    }
    public int calcularTotalVentas() {
        int totalVentas = 0;
        for (CantanteFamoso cantante : listaCantantesFamosos) {
            totalVentas += cantante.getTotalDeVentas();
        }
        return totalVentas;
    }

    public void ordenarPorVentas() {
        Collections.sort(listaCantantesFamosos, new Comparator<CantanteFamoso>() {
            @Override
            public int compare(CantanteFamoso c1, CantanteFamoso c2) {
                return c2.getTotalDeVentas() - c1.getTotalDeVentas();
            }
        });
    }

    @Override
    public Iterator<CantanteFamoso> iterator() {
        return listaCantantesFamosos.iterator();
    }
}
