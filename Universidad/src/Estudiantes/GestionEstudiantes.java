package Estudiantes;

import java.util.HashMap;

public class GestionEstudiantes {
    private HashMap<String, Estudiante> estudiantes;

    public GestionEstudiantes() {
        estudiantes = new HashMap<>();
    }

    // Método para insertar un estudiante
    public boolean insertarEstudiante(String codigo, Estudiante estudiante) {
        if (estudiantes.containsKey(codigo)) {
            return false; // Estudiante ya existe
        } else {
            estudiantes.put(codigo, estudiante);
            return true; // Estudiante agregado
        }
    }

    // Método para consultar un estudiante
    public Estudiante consultarEstudiante(String codigo) {
        return estudiantes.get(codigo); // Retorna el estudiante o null si no existe
    }

    // Método para modificar un estudiante
    public boolean modificarEstudiante(String codigo, Estudiante estudiante) {
        if (estudiantes.containsKey(codigo)) {
            estudiantes.put(codigo, estudiante); // Sobrescribe el estudiante existente
            return true;
        } else {
            return false; // No se encontró el estudiante
        }
    }

    // Método para borrar un estudiante
    public boolean borrarEstudiante(String codigo) {
        return estudiantes.remove(codigo) != null; // Retorna true si se borró, false si no
    }
}
