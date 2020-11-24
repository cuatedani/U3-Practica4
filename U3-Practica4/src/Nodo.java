/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER}
 */
public class Nodo {
    char valor;
    int prioridad;
    Nodo sig;
    Nodo ant;
    
    public Nodo(char dato, int prio){
        valor = dato;
        prioridad = prio;
        sig = null;
        ant = null;
    }     
}
