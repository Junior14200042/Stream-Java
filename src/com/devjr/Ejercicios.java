package com.devjr;

import com.devjr.models.Cursos;

import java.util.*;
import java.util.stream.Collectors;


public class Ejercicios {

    public static void main(String[] args) {

        List<Cursos> cursos = Arrays.asList(
                new Cursos("Cursos profesional de Java", 6.5f, 50, 200 ),
                        new Cursos("Cursos profesional de Python", 8.5f, 60, 800 ),
                        new Cursos("Cursos profesional de DB", 4.5f, 70, 700 ),
                        new Cursos("Cursos profesional de Android", 7.5f, 10, 400 ),
                        new Cursos("Cursos profesional de Escritura", 1.5f, 10, 300 )
                );

        /* 1.- Obtener la cantidad de cursos con una duración mayor a 5 horas. */

            long cantidad= cursos.stream()
                    .filter(d->d.getDuracion()>5)
                    .count();

            System.out.println("Cantidad de cursos con duración > a 5 horas es: "+cantidad);

        /* 2.- Obtener la cantidad de cursos con una duración menor a 2 horas. */

            long cantidad2=cursos.stream()
                    .filter(d->d.getDuracion()<2)
                    .count();

            System.out.println("Cantidad de cursos con duración < a 2 horas es: "+cantidad2);

        /* 3.- Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.*/

            cursos.stream()
                    .filter(v->v.getVideos()>50)
                    .forEach(t-> System.out.println(t.getTitulo()));

        /* 4.- Mostrar en consola el título de los 3 cursos con mayor duración.*/

            cursos.stream()
                    .sorted(Comparator.comparingDouble(Cursos::getDuracion).reversed())
                    .limit(3)
                    .forEach(t-> System.out.println(t.getTitulo()));

        /* 5.- Mostrar en consola la duración total de todos los cursos. */

            double duracionTotal= cursos.stream()
                    .mapToDouble(Cursos::getDuracion)
                    .sum();

            System.out.println("La duración total de los cursos es: "+duracionTotal);


        /* 6.- Mostrar en consola todos aquellos libros que superen el promedio en cuanto a duración se refiere.*/

            double promedio = cursos.stream()
                    .mapToDouble(Cursos::getDuracion)
                    .average().orElseThrow(NoSuchElementException::new);
            cursos.stream()
                    .filter(d->d.getDuracion()>promedio)
                    .forEach(t-> System.out.println(t.getTitulo()));

        /* 7.- Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.*/

            cursos.stream()
                    .filter(a->a.getAlumnos()<500)
                    .forEach(d-> System.out.println(d.getDuracion()));

        /* 8.- Obtener el curso con mayor duración. */

            double mayorDuracion = cursos.stream()
                    .mapToDouble(Cursos::getDuracion)
                    .max().orElseThrow(NoSuchElementException::new);

            System.out.println("El curso con mayor duración es: "+mayorDuracion);

        /* 9.- Crear una lista de Strings con todos los titulos de los cursos.*/

            List<String> titulos =  cursos.stream()
                    .map(Cursos::getTitulo)
                    .collect(Collectors.toList());


    }
}
