package Exercicio02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Empregado> listaEmpregado = new ArrayList<>();

        listaEmpregado.add(new Empregado("Joao", 3, 10));
        listaEmpregado.add(new Empregado("Maria", 10, 10));
        listaEmpregado.add(new Empregado("Pedro", 10, 100));
        listaEmpregado.add(new Empregado("Carol", 25, 1000));

        /// PREDICADO --> Filtro lógico para selecionar ano de experiência
        Predicate<Empregado> filtro = e -> e.anosExperiencia() >=5;

        Stream fluxo = Stream.of(listaEmpregado);
        /// Operador Ternário
        ///[Teste lógico] ? [] : []
        ///Se o teste for VERDADEIRO [] : se for FALSO []
        /*listaEmpregado.stream()
                .map(e -> new Empregado(e.nome(), e.anosExperiencia(),
                       e.salario() * (e.anosExperiencia()>=5 ? 1.20 : 1.10)))
                .sorted(Comparator.comparing(Empregado::nome))
                .forEach(System.out::println);*/

        /// Usando o precicado=
        List<Empregado> aux = listaEmpregado.stream()
                .map(e -> new Empregado(e.nome(), e.anosExperiencia(),
                       e.salario() * (filtro.test(e) ? 1.20 : 1.10)))
                .sorted(Comparator.comparing(Empregado::nome))
                //gera uma lista a partir do resultado
                .toList();
        //Exibe a lista
        aux.forEach(System.out::println);

    }///////////////////// MAIN //////////////////////////
}///////////////////////////////////////////
