/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.illustrato.mdl.core;

import java.io.Serializable;

/**
 * clase para realizar el registro de evidencias.
 * @author adalbertdavidaroca
 */
public class Evidenci implements Serializable{
    
    /**
     * Fecha en que se registra la evidencia.
     */
    private String fecha;
    
    /**
     * Descripcion de la evidencia.
     */
    private String descripc;

    /**
     * @return  fecha fecha de Registro de la evidencia.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha Para actualizar la fecha de registro de la evidencia.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return  descripc descripcion de la evidencia.
     */
    public String getDescripc() {
        return descripc;
    }

    /**
     * @param descripc actualizar la descripcion de la evidencia.
     */
    public void setDescripc(String descripc) {
        this.descripc = descripc;
    }
    
    
    
    
    
}
