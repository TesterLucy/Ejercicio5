package profesores;

import java.util.HashMap;

public class GestionProfesores {
    private HashMap<String, Profesor> profesores;

    public GestionProfesores() {
        profesores = new HashMap<>();
    }

    // Método para insertar un estudiante
    public boolean insertarEstudiante(String codigo, Profesor estudiante) {
        if (profesores.containsKey(codigo)) {
            return false; // Estudiante ya existe
        } else {
            profesores.put(codigo, estudiante);
            return true; // Estudiante agregado
        }
    }

    // Método para consultar un estudiante
    public Profesor consultarProfesor(String codigo) {
        return profesores.get(codigo); // Retorna el estudiante o null si no existe
    }

    // Método para modificar un estudiante
    public boolean modificarProfesor(String codigo, Profesor estudiante) {
        if (profesores.containsKey(codigo)) {
            profesores.put(codigo, estudiante); // Sobrescribe el estudiante existente
            return true;
        } else {
            return false; // No se encontró el estudiante
        }
    }

    // Método para borrar un estudiante
    public boolean borrarProfesor(String codigo) {
        return profesores.remove(codigo) != null; // Retorna true si se borró, false si no
    }
}
