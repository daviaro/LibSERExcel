/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.illustrato.mdl.reto;

import java.io.Serializable;

/**
 *
 * @author adalbertdavidaroca
 */
public class CondAsoc implements Serializable{
    
    /**
     * descripcion de la conducta asociada
     */
    private String descrpci;
    
    /**
     * Puntaje de la conducta asociada
     */
    private int puntaje;

    /**
     * @return  descrpci la descripcion de la conducta asociada
     */
    public String getDescrpci() {
        return descrpci;
    }

    /**
     * @param descrpci actualizar la conducta asociada
     */
    public void setDescrpci(String descrpci) {
        this.descrpci = descrpci;
    }

    /**
     * @return  puntaje el puntaje de la conducta asociada.
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje para actualizar la conducta asociada.
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    
    
}
