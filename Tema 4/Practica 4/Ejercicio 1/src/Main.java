import Model.Coche;
import Model.Propietario;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    private static List<Coche> coches;
    private static List<Propietario> propietarios;
    public static void main(String[] args) {
        // COCHES
        Coche c1 = new Coche("1234 ABC", "Toyota", 2018 , 18000);
        Coche c2 = new Coche("5678 DEF", "BMW", 2015 , 25000);
        Coche c3 = new Coche("9012 GHI", "Seat", 2012 , 12000);

        Coche c4 = new Coche("3456 JKL", "Toyota", 2020 , 22000);
        Coche c5 = new Coche("7890 MNO", "Audi", 2017 , 30000);
        Coche c6 = new Coche("1122 PQR", "BMW", 2010 , 15000);

        Coche c7 = new Coche("3344 STU", "Seat", 2019 , 16000);
        Coche c8 = new Coche("5566 VWX", "Audi", 2014 , 20000);
        Coche c9 = new Coche("7788 YZA", "Toyota", 2021 , 24000);

        coches = new ArrayList<>();
        coches.add(c1);
        coches.add(c2);
        coches.add(c3);
        coches.add(c4);
        coches.add(c5);
        coches.add(c6);
        coches.add(c7);
        coches.add(c8);
        coches.add(c9);

        // PROPIETARIOS
        Propietario p1 = new Propietario (
                "Carlos",
                List.of(c1 , c2 , c3)
        );

        Propietario p2 = new Propietario (
                "Ana",
                List.of(c4 , c5 , c6)
        );

        Propietario p3 = new Propietario (
                "Luis",
                List.of(c7 , c8 , c9)
        );

        propietarios = new ArrayList<>();
        propietarios.add(p1);
        propietarios.add(p2);
        propietarios.add(p3);


        //1. Obtener una lista con las matriculas de los coches.
        //2. Contar cuantos coches tiene el propietario. ´
        //3. Obtener coches posteriores a 2015.
        //4. Calcular el precio medio de los coches.
        //5. Obtener el coche mas caro. ´
        //6. Comprobar si algun coche es de marca ”BMW”. ´

        boolean hayBMW = coches.stream()
                .anyMatch(c -> c.getMarca().equalsIgnoreCase("BMW"));
        JOptionPane.showMessageDialog(null, "¿Hay algún BMW? " + hayBMW);


        //7. Obtener lista de coches ordenados por precio (ascendente).

        List<Coche> cochesOrdenados = coches.stream()
                .sorted(Comparator.comparingDouble(Coche::getPrecio))
                .toList();
        String texto = cochesOrdenados.stream()
                .map(Coche::toString)
                .collect(Collectors.joining("\n"));

        JOptionPane.showMessageDialog(null, texto);



        //8. Obtener el coche mas antiguo.

        Optional<Coche> cocheMasAntiguo = coches.stream()
                .min(Comparator.comparingInt(Coche::getAnno));
        if (cocheMasAntiguo.isPresent()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Coche más antiguo:\n" + cocheMasAntiguo.get()
            );
        }


        //9. Contar coches que cuestan mas de 20.000.


        int total= (int) coches.stream()
                .filter(coche -> coche.getPrecio() > 20000)
                .count();
        JOptionPane.showMessageDialog(
                null,
                "Coches que cuestan más de 20.000€: " + total
        );


        //10. Obtener las marcas sin repetir.


        //11. Crear un Map con matricula y precio.
        //12. Agrupar coches por marca.
        //13. Agrupar coches por antiguos / modernos tomando como frontera el año 2015. ˜
        //14. Calcular el precio medio por marca

        Map<String, List<Coche>> cochesPorMarca = coches.stream()
                .collect(Collectors.groupingBy(Coche::getMarca));
        Map<String, Double> precioMedioPorMarca = coches.stream()
                .collect(Collectors.groupingBy(
                        Coche::getMarca,
                        Collectors.averagingDouble(Coche::getPrecio)
                ));
        StringBuilder texto1 = new StringBuilder();
        precioMedioPorMarca.forEach((marca, precio) ->
                texto1.append(marca).append(": ").append(precio).append("€\n")
        );

        JOptionPane.showMessageDialog(
                null,
                texto1.toString()
        );




        //15. Concatenar todas las matr´ıculas en una cadena

        String todasMatriculas = coches.stream()
                .map(Coche::getMatricula)   // obtenemos solo la matrícula de cada coche
                .collect(Collectors.joining(", "));  // las unimos con coma y espacio
        JOptionPane.showMessageDialog(
                null,
                "Todas las matrículas: " + todasMatriculas
        );


        //16. Contar coches de una marca concreta (”Toyota”)

        long totalToyota = coches.stream()
                .filter(c -> c.getMarca().equalsIgnoreCase("Toyota"))
                .count();
        JOptionPane.showMessageDialog(
                null,
                "Número de coches Toyota: " + totalToyota
        );


        //17. Obtener las marcas ordenadas alfabeticamente ´



        //18. Obtener el coche moderno mas barato ´
        //19. Comprobar si hay matr´ıculas repetidas
        //20. Obtener el TOP 3 de coches mas caros ´
        //21. Generar una lista con todos los propietarios y realiza los siguientes ejercicios:
            // a) Obtener una lista con TODOS los coches de todos los propietarios.
            // b) Contar el numero total de coche.s ´
            // c) Obtener todas las matr´ıculas.


    }
}