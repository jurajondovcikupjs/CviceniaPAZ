package sk.upjs.ondovcik.juraj;

import sk.upjs.paz.graph.Edge;
import sk.upjs.paz.graph.Graph;
import sk.upjs.paz.graph.Vertex;

import java.util.*;

public class Frogs {

    public static void main(String[] args) {
        Graph City = new Graph();

        City.addVertex("C1");
        City.addVertex("C2");
        City.addVertex("C3");
        City.addVertex("C4");
        City.addVertex("C5");

        City.addEdge(City.getVertex("C1"), City.getVertex("C2"));
        City.getEdge(City.getVertex("C1"), City.getVertex("C2")).setWeight(1);

        City.addEdge(City.getVertex("C1"), City.getVertex("C3"));
        City.getEdge(City.getVertex("C1"), City.getVertex("C3")).setWeight(2);

        City.addEdge(City.getVertex("C2"), City.getVertex("C3"));
        City.getEdge(City.getVertex("C2"), City.getVertex("C3")).setWeight(1);

        City.addEdge(City.getVertex("C2"), City.getVertex("C4"));
        City.getEdge(City.getVertex("C2"), City.getVertex("C4")).setWeight(2);

        City.addEdge(City.getVertex("C3"), City.getVertex("C4"));
        City.getEdge(City.getVertex("C3"), City.getVertex("C4")).setWeight(1);

        City.addEdge(City.getVertex("C3"), City.getVertex("C5"));
        City.getEdge(City.getVertex("C3"), City.getVertex("C5")).setWeight(1);

        Set<Vertex> citiesSet = City.getVertices();
        Vertex[] cities = new  Vertex[citiesSet.size()];

        int i = 0;
        for (Vertex v : citiesSet) {
            cities[i++] = v;
        }

        int[][] matrixBefore = new int[City.getVertices().size()][City.getVertices().size()];

        for (int c = 0; c < cities.length; c++) {
            for (int v = 0; v < cities.length; v++) {
                int cena = najdiCestu(City, cities[c], cities[v]);
                matrixBefore[c][v] = cena;
            }
        }

        int[][] matrixAfter = new int[City.getVertices().size()][City.getVertices().size()];
        City.removeEdge(City.getEdge(City.getVertex("C2"), City.getVertex("C3")));

        for (int c = 0; c < cities.length; c++) {
            for (int v = 0; v < cities.length; v++) {
                int cena = najdiCestu(City, cities[c], cities[v]);
                matrixAfter[c][v] = cena;
            }
        }

        int maxZmena = 0;
        Vertex maxZmenaA = null;
        Vertex maxZmenaB = null;
        for (int c = 0; c < cities.length; c++) {
            for (int v = 0; v < cities.length; v++) {
                if (matrixBefore[c][v] != matrixAfter[c][v]) {
                    int rozdiel = Math.abs(matrixBefore[c][v] - matrixAfter[c][v]);
                    if (rozdiel > maxZmena) {
                        maxZmena = rozdiel;
                        maxZmenaA = cities[c];
                        maxZmenaB = cities[v];
                    }
                }
            }
        }

        System.out.println(Arrays.toString(cities));
        toString(matrixBefore);
        System.out.println("-----------------------------");
        toString(matrixAfter);
        System.out.println("-----------------------------");
        assert maxZmenaA != null;
        System.out.println("Najväčšia zmena: " + maxZmena + " medzi " + maxZmenaA + " a " + maxZmenaB);

    }

    public static void toString(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    public static Map<Vertex, Double> bellmanFord(Graph g, Vertex s) {
        Map<Vertex, Double> d = g.createVertexMap(Double.POSITIVE_INFINITY);
        d.put(s, 0d);

        for (int i = 0; i < g.getVertices().size(); i++)
            for (Edge e : g.getEdges())
                relax(e, d);

        return d;
    }

    public static void relax(Edge e, Map<Vertex, Double> d) {
        Vertex u = e.getSource();
        Vertex v = e.getTarget();
        if (d.get(u) + e.getWeight() < d.get(v))
            d.put(v, d.get(u) + e.getWeight());

        if (d.get(v) + e.getWeight() < d.get(u))
            d.put(u, d.get(v) + e.getWeight());
    }

    public static int najdiCestu(Graph g, Vertex start, Vertex ciel) {
        int hodnota = 0;
        Map<Vertex, Double> vzdialenosti = bellmanFord(g, start);
        List<Vertex> cesta = new ArrayList<>();
        Vertex aktualny = ciel;
        cesta.add(aktualny);
        while (aktualny != start) {
            // zistit susedov aktualneho
            Set<Vertex> susedia = aktualny.getNeighbours();
            for (Vertex sused : susedia) {
                Edge hrana = g.getEdge(aktualny, sused);
                // zistit ci po odpocitani hrany dostanem pre suseda hodnotu z mapy vzdielnosti
                if (vzdialenosti.get(aktualny) - hrana.getWeight() == vzdialenosti.get(sused)) {
                    // ak ano, patri do cesty a stane sa dalsim aktualnym - cyklus break
                    aktualny = sused;
                    cesta.add(aktualny);
                    hodnota += (int) hrana.getWeight();
                    break;
                }
            }
        }
        Collections.reverse(cesta);
        return hodnota;
    }

}
