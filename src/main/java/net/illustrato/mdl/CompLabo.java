/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.illustrato.mdl;


import java.io.Serializable;

/**
 * Esta clase se usara para la definicion y evaluacion de los compromisos 
 * laborales.
 * @author adalbertdavidaroca
 */
public class CompLabo implements Serializable{
    
    /**
     * Se almacena informacion sobre el objetivo estrategico del compromiso
     * laboral
     */
    private String objeEstr;
    
    /**
     * Se almacena informacion sobre el compromiso del area 
     */
    
    private String compArea;
    
    /**
     * Se almacena informacion sobre el compromiso con las funciones del Cargo.
     */
    
    private String compFuca;
    
    /**
     * Se almacena informacion sobre la meta.
     */
    
    private String meta;
    
    /**
     * Se almacena informacion sobre la evidencia
     */
    
    private String evidencia;
    
    /**
     * Se almacena informacion sobre los puntos para el periodo esperados.
     */
    
    private int pupeEspe;
    
    
    /**
     * Se almacena informacion sobre los puntos para el periodo logradoss.
     */
    
    private int pupeLogr;

    /**
     * @return  objeEstr el objetivo estrategico
     */
    public String getObjeEstr() {
        return objeEstr;
    }

    /**
     * @param objeEstr para actualizar el objetivo estrategico.
     */
    public void setObjeEstr(String objeEstr) {
        this.objeEstr = objeEstr;
    }

    /**
     * @return  compArea el compromiso de Area
     */
    public String getCompArea() {
        return compArea;
    }

    /**
     * @param compArea para actualizar el compromiso de Area.   
     */
    public void setCompArea(String compArea) {
        this.compArea = compArea;
    }

    /**
     * @return compFuca el compromisos de funciones del cargo
     */
    public String getCompFuca() {
        return compFuca;
    }

    /**
     * @param compFuca actualizar compromiso de las funciones del cargo.
     */
    public void setCompFuca(String compFuca) {
        this.compFuca = compFuca;
    }

    /**
     * @return  meta la meta 
     */
    public String getMeta() {
        return meta;
    }

    /**
     * @param meta para actualizar la meta.
     */
    public void setMeta(String meta) {
        this.meta = meta;
    }

    /**
     * @return  evidencia la evidencia del compromiso
     */
    public String getEvidencia() {
        return evidencia;
    }

    /**
     * @param evidencia para actualizar 
     */
    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }

    /**
     * @return  pupeEspe los puntos esperados por compromiso.
     */
    public int getPupeEspe() {
        return pupeEspe;
    }

    /**
     * @param pupeEspe para actualizar puntos esperados.
     */
    public void setPupeEspe(int pupeEspe) {
        this.pupeEspe = pupeEspe;
    }

    /**
     * @return pupeLogr puntos logrados en el compromiso
     */
    public int getPupeLogr() {
        return pupeLogr;
    }

    /**
     * @param pupeLogr actualizar los puntos por perido logrados
     */
    public void setPupeLogr(int pupeLogr) {
        this.pupeLogr = pupeLogr;
    }

   

   
    
}
