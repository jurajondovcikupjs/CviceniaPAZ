package sk.upjs.ondovcik.juraj;

import sk.upjs.paz.graph.Edge;
import sk.upjs.paz.graph.Graph;
import sk.upjs.paz.graph.Vertex;
import java.util.Map.Entry;
import java.util.*;

public class OneWay {

    public static void main(String[] args) {
        Graph mesto = new Graph();
        mesto.setDirected(true);

        Vertex zero = mesto.addVertex("0");
        Vertex one = mesto.addVertex("1");
        Vertex two = mesto.addVertex("2");
        Vertex three = mesto.addVertex("3");
        Vertex four = mesto.addVertex("4");
        Vertex five = mesto.addVertex("5");
        Vertex[] cities = new Vertex[]{zero, one, two, three, four, five};

        mesto.addEdge(one, two);
        mesto.addEdge(two, one);

        mesto.addEdge(two, three);
        mesto.addEdge(three, two);

        mesto.addEdge(one, three);
        mesto.addEdge(three, one);

        mesto.addEdge(one, four);

        mesto.addEdge(three, four);
        //mesto.addEdge(four, three);

        mesto.addEdge(four, five);

        mesto.addEdge(zero, five);
        mesto.addEdge(five, zero);

        mesto.addEdge(zero, four);

        boolean possible = true;
        for (int i = 0; i < cities.length; i++) {
            Map<Vertex, Boolean> map = dfsNerekurzivne(mesto, cities[i]);
            for (Map.Entry<Vertex, Boolean> entry : map.entrySet()) {
                if (!entry.getValue()) {
                    possible = false;
                    break;
                }
            }
        }
        System.out.println(possible);
    }

    public static Map<Vertex, Boolean> dfsNerekurzivne(Graph g, Vertex start) {
        Map<Vertex, Boolean> navstiveny = g.createVertexMap(false);
        Stack<Vertex> zasobnik = new Stack<Vertex>();
        zasobnik.push(start);
        while (!zasobnik.isEmpty()) {
            Vertex v = zasobnik.pop();
            if (navstiveny.get(v))
                continue;
            navstiveny.put(v, true);
            for (Vertex sused : v.getOutNeighbours())
                if (!navstiveny.get(sused))
                    zasobnik.push(sused);
        }
        return navstiveny;
    }

}
