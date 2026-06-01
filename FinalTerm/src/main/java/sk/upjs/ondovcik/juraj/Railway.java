package sk.upjs.ondovcik.juraj;

import sk.upjs.paz.graph.Edge;
import sk.upjs.paz.graph.Graph;
import sk.upjs.paz.graph.Vertex;

import java.util.*;

public class Railway {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("V1");
        graph.addVertex("V2");
        graph.addVertex("V3");
        graph.addVertex("V4");
        graph.addVertex("V5");

        graph.addEdge(graph.getVertex("V1"), graph.getVertex("V2"));
        graph.getEdge(graph.getVertex("V1"), graph.getVertex("V2")).setWeight(1);

        graph.addEdge(graph.getVertex("V1"), graph.getVertex("V3"));
        graph.getEdge(graph.getVertex("V1"), graph.getVertex("V3")).setWeight(2);

        graph.addEdge(graph.getVertex("V2"), graph.getVertex("V3"));
        graph.getEdge(graph.getVertex("V2"), graph.getVertex("V3")).setWeight(1);

        graph.addEdge(graph.getVertex("V2"), graph.getVertex("V4"));
        graph.getEdge(graph.getVertex("V2"), graph.getVertex("V4")).setWeight(4);

        graph.addEdge(graph.getVertex("V3"), graph.getVertex("V4"));
        graph.getEdge(graph.getVertex("V3"), graph.getVertex("V4")).setWeight(1);

        graph.addEdge(graph.getVertex("V3"), graph.getVertex("V5"));
        graph.getEdge(graph.getVertex("V3"), graph.getVertex("V5")).setWeight(1);

        //for (Vertex v : graph.getVertices()) {
        //    for (Vertex v2 : graph.getVertices()) {
        //        for (Vertex v3 : graph.getVertices()) {
        //            try {
        //                double p1 = graph.getEdge(graph.getVertex(v.getLabel()), graph.getVertex(v2.getLabel())).getWeight();
        //                double p2 = graph.getEdge(graph.getVertex(v2.getLabel()), graph.getVertex(v3.getLabel())).getWeight();
        //                double p3 = graph.getEdge(graph.getVertex(v.getLabel()), graph.getVertex(v3.getLabel())).getWeight();
        //                if (v != v2 && v2 != v3 && v != v3 &&  p1+p2 > p3 ) {
        //                    System.out.println("true" + v.getLabel() + v2.getLabel() + v3.getLabel());
        //                } else {
        //                    System.out.println("false" + v.getLabel() + v2.getLabel() + v3.getLabel());
        //                    break;
        //                }
        //            } catch (Exception e) {
//
        //            }
//
        //        }
        //    }
        //}

        int minLength = Integer.MAX_VALUE;
        Vertex c = null;
        int neighbours = 0;
        for (Vertex s1 : graph.getVertices()) {
            for (Vertex s2 : graph.getVertices()) {
                if (s1 != s2) {
                    int length = najdiCestu(graph, s1, s2).size();
                    if  (length < minLength) {
                        minLength = length;
                        c = s1;
                        neighbours = s1.getNeighbours().size();
                        System.out.println("new min length: " + minLength + " for vertex: " + c.getLabel() + " with neighbours: " + neighbours);
                    } else if  (length == minLength && s1.getNeighbours().size() > neighbours) {
                        c = s1;
                        neighbours = s1.getNeighbours().size();
                        System.out.println("new min length: " + minLength + " for vertex: " + c.getLabel() + " with neighbours: " + neighbours);
                    }
                }
            }
        }
        System.out.println(c.getLabel());

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

    public static List<Vertex> najdiCestu(Graph g, Vertex start, Vertex ciel) {
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
                    break;
                }
            }
        }
        Collections.reverse(cesta);
        return cesta;
    }



}
