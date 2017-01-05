/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.illustrato.mdl;

import java.io.Serializable;
import java.util.List;

/**
 * clase para modelar una concertacion de compromiso laboral.
 * @author adalbertdavidaroca
 */
public class ConcCola implements Serializable{
    
    /**
     * Se almacena la  informacion sobre el evaluado
     */
     private Evaluado  evaluado;
     
     /**
      * Se almacen la informacion sobre el evaluador.
      */
     
     private Evaluadr evaluadr;
     
     
     /**
      * Tipos o motivos de la evaluacion.
      */
     
     private TimoEval timoEval;
     
     /**
      * Listado de compromisos laborales.
      */
     private List<CompLabo> listCols;
     
     
     
     /**
      * total de puntos por periodo esperados segun la lista de compromisos 
      * laborales
      */
     
     private int totaPues;
     
     /**
      * total de puntos por periodo logrados segun la lista de compromisos 
      * laborales
      */
     
     private int totaPulo;
     
     
     

    /**
     * @return the evaluado
     */
    public Evaluado getEvaluado() {
        return evaluado;
    }

    /**
     * @param evaluado the evaluado to set
     */
    public void setEvaluado(Evaluado evaluado) {
        this.evaluado = evaluado;
    }

    /**
     * @return the evaluadr
     */
    public Evaluadr getEvaluadr() {
        return evaluadr;
    }

    /**
     * @param evaluadr the evaluadr to set
     */
    public void setEvaluadr(Evaluadr evaluadr) {
        this.evaluadr = evaluadr;
    }

    /**
     * @return the timoEval
     */
    public TimoEval getTimoEval() {
        return timoEval;
    }

    /**
     * @param timoEval the timoEval to set
     */
    public void setTimoEval(TimoEval timoEval) {
        this.timoEval = timoEval;
    }

    /**
     * @return the listCols
     */
    public List<CompLabo> getListCols() {
        return listCols;
    }

    /**
     * @param listCols the listCols to set
     */
    public void setListCols(List<CompLabo> listCols) {
        this.listCols = listCols;
    }

    /**
     * @return the totaPues
     */
    public int getTotaPues() {
        return totaPues;
    }

    /**
     * @param totaPues the totaPues to set
     */
    public void setTotaPues(int totaPues) {
        this.totaPues = totaPues;
    }

    /**
     * @return the totaPulo
     */
    public int getTotaPulo() {
        return totaPulo;
    }

    /**
     * @param totaPulo the totaPulo to set
     */
    public void setTotaPulo(int totaPulo) {
        this.totaPulo = totaPulo;
    }
     
     
     
     
     
}
