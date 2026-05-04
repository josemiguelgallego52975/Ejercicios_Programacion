package Utilidades;

import jakarta.persistence.EntityManagerFactory;

public class BDConection {
    private static EntityManagerFactory emf;

    public static void crearEMF() {

        emf = jakarta.persistence.Persistence.createEntityManagerFactory("default");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
