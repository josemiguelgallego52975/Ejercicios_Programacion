package DAO;

import Modelo.Cuenta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class CuentaDAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public static void crearCuenta(Cuenta cuenta){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cuenta);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static Cuenta buscarCuentaPorId(String iban) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Cuenta.class, iban);
        } finally {
            em.close();
        }
    }

    public static void modificarCuenta(Cuenta cuenta) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cuenta);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static String borrarCuenta(String iban) {
        String respuesta = "";
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Cuenta cuenta = em.find(Cuenta.class, iban);
            if (cuenta != null) {
                em.remove(cuenta);
                em.getTransaction().commit();
                respuesta = "Cuenta con IBAN " + iban + " borrada correctamente.";
            } else {
                respuesta = "No se encontró la cuenta con IBAN: " + iban;
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            respuesta = "Error: No se puede borrar la cuenta porque tiene titulares asociados.";
            e.printStackTrace();
        } finally {
            em.close();
        }
        return respuesta;
    }

    public static List<Cuenta> listarCuentas() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Cuenta c", Cuenta.class).getResultList();
        } finally {
            em.close();
        }
    }
}
