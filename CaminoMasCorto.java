/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dijkstras;

import java.util.*;
import java.lang.*;
import java.io.*;

public class CaminoMasCorto {

    public CaminoMasCorto() {
    }

  

    int Metodo_En_Que_Vertice_Estoy_Ahora(int dist[], Boolean[] vectorValidaciondeVertice, int verticesEscenarios) {
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < verticesEscenarios; v++) {
            if (vectorValidaciondeVertice[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

 
    public String ImprimirVectorCaminoMasCorto(int dist[], int verticesEscenarios) {
        String respuesta = "Vertice\tDistancia desde el origen";
        //System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < verticesEscenarios; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                respuesta = respuesta + "\n" + (i + 1) + "------\t------> Vertice no conecta con origen";
            } else {
                respuesta = respuesta + "\n" + (i + 1) + "------\t------> " + dist[i];
                //System.out.println("\n" i + " \t\t " + dist[i]);
            }
        }
        return respuesta;
    }


    public int[] Algoritmo_Dijkstra(int[][] grafo, int origen, int verticesEscenarios) {
        int[] VectorDistanciaMinima = new int[verticesEscenarios]; // The output array. dist[i] will hold 

        Boolean[] VectorValidaciondeVertice = new Boolean[verticesEscenarios];

        // Initialize all distances as INFINITE and stpSet[] as false 
        // Definimos todas las distancias como infinito. Definimos el 3
        for (int i = 0; i < verticesEscenarios; i++) {
            VectorDistanciaMinima[i] = Integer.MAX_VALUE;
            VectorValidaciondeVertice[i] = false;
        }

        // Distance of source vertex from itself is always 0 
        VectorDistanciaMinima[origen] = 0;


        for (int count = 0; count < verticesEscenarios - 1; count++) {

            int Vertice_Actual = Metodo_En_Que_Vertice_Estoy_Ahora(VectorDistanciaMinima, VectorValidaciondeVertice, verticesEscenarios);

         
            VectorValidaciondeVertice[Vertice_Actual] = true;

     
            for (int i = 0; i < verticesEscenarios; i++) // Update dist[v] only if is not in sptSet, there is an 

            {
                if (!VectorValidaciondeVertice[i] && grafo[Vertice_Actual][i] != 0 && VectorDistanciaMinima[Vertice_Actual] != Integer.MAX_VALUE && VectorDistanciaMinima[Vertice_Actual] + grafo[Vertice_Actual][i] < VectorDistanciaMinima[i]) {
                    VectorDistanciaMinima[i] = VectorDistanciaMinima[Vertice_Actual] + grafo[Vertice_Actual][i];
                }
            }
        }

        // print the constructed distance array VER DE BORRAR
        //System.out.println(printSolution(dist)); VER DE BORRAR
        return VectorDistanciaMinima;

    }

}
