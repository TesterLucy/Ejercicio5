/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cantantes;

public class CantanteFamoso {
    private String nombre;
    private String discoConMasVentas;
    private int totalDeVentas;

    public CantanteFamoso(String nombre, String discoConMasVentas, int totalDeVentas) {
        this.nombre = nombre;
        this.discoConMasVentas = discoConMasVentas;
        this.totalDeVentas = totalDeVentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiscoConMasVentas() {
        return discoConMasVentas;
    }

    public void setDiscoConMasVentas(String discoConMasVentas) {
        this.discoConMasVentas = discoConMasVentas;
    }

    public int getTotalDeVentas() {
        return totalDeVentas;
    }

    public void setTotalDeVentas(int totalDeVentas) {
        this.totalDeVentas = totalDeVentas;
    }
}

