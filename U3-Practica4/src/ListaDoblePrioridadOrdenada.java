/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER}
 */
public class ListaDoblePrioridadOrdenada {
    private Nodo ini=null;
    private Nodo fin=null;
    
    public boolean Insertar(char dato, int prio){
        Nodo temp = new Nodo (dato, prio);
        if(temp==null){
            return false;
        }
        if(ini==null && fin==null){
            ini=temp;
            fin=temp;
            return true;
        }
        if((temp.prioridad>fin.prioridad) || (temp.prioridad==fin.prioridad && temp.valor<fin.valor)){
            if((temp.prioridad>ini.prioridad)||(temp.prioridad==ini.prioridad && temp.valor<ini.valor)){
                temp.sig=ini;
                ini.ant=temp;
                ini=temp;
                return true;
            }else{
                for(Nodo temp2=ini.sig; temp2.sig!=null; temp2=temp2.sig){
                    if(temp.prioridad<=temp2.prioridad){
                        if(temp.prioridad==temp2.prioridad && temp.valor<temp2.valor){
                            temp2.sig.ant=temp;
                            temp.sig=temp2.sig;
                            temp.ant=temp2;
                            temp2.sig=temp;
                            return true;
                        }else{
                            if(temp.prioridad>temp2.prioridad){
                                temp2.ant.sig=temp;
                                temp.ant=temp2.ant;
                                temp.sig=temp2;
                                temp2.ant=temp;
                                return true;
                            }
                        }
                    }else{
                        if(temp.prioridad>temp2.prioridad){
                                temp2.ant.sig=temp;
                                temp.ant=temp2.ant;
                                temp.sig=temp2;
                                temp2.ant=temp;
                            return true;
                        }
                    }
                }
            }
        }else{
            temp.ant=fin;
            fin.sig=temp;
            fin=temp;
            return true;
        }
        return true;
    }
    
    public boolean Eliminar(){
        if(ini==null && fin==null){
            return false;
        }
        if(ini==fin && ini!=null){
            fin=ini=null;
            return true;
        }
        Nodo temp = ini.sig;
        temp.ant=null;
        ini.sig=null;
        ini=temp;
        return true;
    }
    
    public String MostrarLista(){
        return "---ListaDoblePrioridad---\n" + MostrarLista(ini)+"-";
    }
    
    public String MostrarLista(Nodo n){
        if(ini==null && fin==null){
            return ("!ListaVacia!");
        }
        if(n.sig==null){
        return ("- (" + n.valor + " , " + n.prioridad+") ");
        }
        Nodo temp=n;
        return "- (" + temp.valor + " , " + temp.prioridad+") "+MostrarLista(temp.sig);
    }    
}
