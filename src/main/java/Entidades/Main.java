package Entidades;

import GUI.Inicial;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clase principal que contiene el método de inicio de la aplicación.
 */
public class Main {

    /**
     * Método de inicio de la aplicación.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en este
     * caso).
     */
    public static void main(String[] args) {
        // Crear una instancia de la clase Inicial
        Inicial a = new Inicial();
        // Hacer visible la ventana de Inicial
        a.setVisible(true);

        // Crear una instancia de EntityManagerFactory para establecer la conexión a la base de datos
        EntityManagerFactory enti = Persistence.createEntityManagerFactory("ConexionPU");

        // Crear una instancia de EntityManager para interactuar con la base de datos
        EntityManager entity = enti.createEntityManager();

        // Iniciar una transacción
        entity.getTransaction().begin();

        // Realizar operaciones de persistencia o consulta en la base de datos
        // Confirmar la transacción
        entity.getTransaction().commit();

        // Cerrar la instancia de EntityManager
        entity.close();
    }
}
