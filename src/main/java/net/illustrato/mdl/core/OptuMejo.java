/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.illustrato.mdl.core;

import java.io.Serializable;

/**
 * Se guarda en esta clase la informacion correspondiente a las oportunidades de
 * mejoramiento
 * @author adalbertdavidaroca
 */
public class OptuMejo  implements Serializable{
    
    /**
     * Descripcion de oportunidad de mejoramiento tecnico o del cargo.
     */
    private String capaTecn;
    /**
     * Descripcion de oportunidad de mejoramiento sobre comportamiento o conducta
     */
    private String comporta;
    
    
    public OptuMejo(){
        this.capaTecn="";
        this.comporta="";
    }

    /**
     * @return capaTecn Descripcion de oportunidad de mejora en cuanto a capacidad tecnica.
     */
    public String getCapaTecn() {
        return capaTecn;
    }

    /**
     * @param capaTecn Actualizar la descipcion de oportunidad de mejora 
     * en cuanto a capacidad tecnica.
     */
    public void setCapaTecn(String capaTecn) {
        this.capaTecn = capaTecn;
    }

    /**
     * @return comporta Descripcion de oportunidad de mejora en cuanto a 
     * comportamiento o conduta
     */
    public String getComporta() {
        return comporta;
    }

    /**
     * @param comporta actualizar la descripcion de oportunidad de mejora en
     * cuanto a comportamiento o conducta.
     */
    public void setComporta(String comporta) {
        this.comporta = comporta;
    }
    
    
    
    
    
}
