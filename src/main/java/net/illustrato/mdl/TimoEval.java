/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.illustrato.mdl;

import java.io.Serializable;

/**
 * En esta clase de manipulan los tipos y motivos de evaluacion.
 *
 * @author adalbertdavidaroca
 */
public class TimoEval implements Serializable {

    /**
     * Se ingresa una X si la evaluacion es parcial. Sino va vacia.
     */
    private String evalParc;
    /**
     * Se ingresa un X si la evaluacion es definitiva. Sino va vacia.
     */
    private String evalDefi;

    /**
     * Periodo de inicio de la evaluacion.
     */
    private String periDesd;

    /**
     * Periodo de finalizacion de la evaluacion.
     */
    private String periHast;

    /**
     * @return evalParc Si la evalucion es parcial X. De lo contrario va nulo.
     */
    public String getEvalParc() {
        return evalParc;
    }

    /**
     * @param evalParc para actualizar el valor
     */
    public void setEvalParc(String evalParc) {
        this.evalParc = evalParc;
    }

    /**
     * @return evalDefi Si la evalucion es definitiva X. De lo contrario va
     * nulo.
     */
    public String getEvalDefi() {
        return evalDefi;
    }

    /**
     * @param evalDefi Para actualizar el valor evalucion definitiva.
     */
    public void setEvalDefi(String evalDefi) {
        this.evalDefi = evalDefi;
    }

    /**
     * @return periDesd periodo desde que se inicio el compromiso
     */
    public String getPeriDesd() {
        return periDesd;
    }

    /**
     * @param periDesd para actualizar el periodo de inicio del compromiso.
     */
    public void setPeriDesd(String periDesd) {
        this.periDesd = periDesd;
    }

    /**
     * @return periHast periodo hasta que se termina o evalua el compromiso
     */
    public String getPeriHast() {
        return periHast;
    }

    /**
     * @param periHast actualizar le periodo hasta cuando se termina o evalua el
     * compromiso
     */
    public void setPeriHast(String periHast) {
        this.periHast = periHast;
    }

}
