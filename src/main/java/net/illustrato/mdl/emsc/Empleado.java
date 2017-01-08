/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.illustrato.mdl.emsc;

import java.io.Serializable;

/**
 *
 * @author adalbertdavidaroca
 */
public class Empleado implements Serializable{
    
    /**
     * Periodo, fecha desde hasta.
     */
    private String periodo;
    /**
     * Numero de registro laboral del evaluado
     */
    private String numeRlev;
    
    /**
     * Nombre completo del evaluado
     */
    private String nombCoev;
    
    /**
     * Nombre completo del evaluador
     */
    private String nombCoer;
    
    /**
     * Cargo del evaluado
     */
    private String cargEval;
    
    /**
     * Cargo del evaluador
     */
    private String cargEvar;
    
    /**
     * nivel jerarquico del cargo del evaluado
     */
    private String  nijeCaev;
    
    /**
     * Descripcion de la gerencia del 
     * evaluado
     */
    private String gereEval;
    
    /**
     * Descripcion de la gerencia del 
     * evaluador
     */
    private String gereEvdr;
    
    /**
     * Direccion del evaluado
     */
    private String direEval;
    
    /**
     * Direccion del evaluador
     */
    private String direEvdr;
    
    
    /**
     * Descripcion departamente del evaluado
     */
    private String depaEval;
    
    /**
     * Descripcion departamento del evaluador
     */
    private String depaEvdr;
    
    /**
     * Descripcion de la novedad
     */
    
    private String novedad;
    
    
    /**
     * 
     * @return periodo fecha desde - hasta
     */

    public String getPeriodo() {
        return periodo;
    }
    
    /**
     * 
     * @param periodo para actualizar el periodo.
     */

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    /**
     * 
     * @return numeRlev numero de registro laboral evaluado
     */

    public String getNumeRlev() {
        return numeRlev;
    }

    /**
     * 
     * @param numeRlev para actualizar el numero de registro laboral.
     */
    public void setNumeRlev(String numeRlev) {
        this.numeRlev = numeRlev;
    }

    /**
     * 
     * @return nombCoev Nombre completo evaluado
     */
    public String getNombCoev() {
        return nombCoev;
    }

    /**
     * 
     * @param nombCoev para actualizar el nombre completo del evaluador.
     */
    public void setNombCoev(String nombCoev) {
        this.nombCoev = nombCoev;
    }

    /**
     * 
     * @return nombCoer Nombre completo evaluador.
     */
    public String getNombCoer() {
        return nombCoer;
    }

    /**
     * 
     * @param nombCoer actualizar el nombre completo del evaluador.
     */
    public void setNombCoer(String nombCoer) {
        this.nombCoer = nombCoer;
    }

    /**
     * 
     * @return cargEval cargo del evaluado
     */
    public String getCargEval() {
        return cargEval;
    }

    /**
     * 
     * @param cargEval actualizar el cargo del evaluado
     */
    public void setCargEval(String cargEval) {
        this.cargEval = cargEval;
    }
    
    /**
     * 
     * @return cargEvar cargo del evaluador.
     */

    public String getCargEvar() {
        return cargEvar;
    }

    /**
     * 
     * @param cargEvar Para actualizar el cargo del evaluador
     */
    public void setCargEvar(String cargEvar) {
        this.cargEvar = cargEvar;
    }

    public String getNijeCaev() {
        return nijeCaev;
    }

    public void setNijeCaev(String nijeCaev) {
        this.nijeCaev = nijeCaev;
    }

    /**
     * @return  gereEval Gerenacia del evaluado
     */
    public String getGereEval() {
        return gereEval;
    }

    /**
     * @param gereEval Para actualizar la gerencia del Evaluado
     */
    public void setGereEval(String gereEval) {
        this.gereEval = gereEval;
    }

    /**
     * @return  gereEvdr gerencia del evaluador
     */
    public String getGereEvdr() {
        return gereEvdr;
    }

    /**
     * @param gereEvdr Para actualizar la gerencia del evaluador
     */
    public void setGereEvdr(String gereEvdr) {
        this.gereEvdr = gereEvdr;
    }

    /**
     * @return  direEval direccion del evaluado
     */
    public String getDireEval() {
        return direEval;
    }

    /**
     * @param direEval Para actualizar la direccion del evaluado
     */
    public void setDireEval(String direEval) {
        this.direEval = direEval;
    }

    /**
     * @return  direEvdr La direccion del evaluador
     */
    public String getDireEvdr() {
        return direEvdr;
    }

    /**
     * @param direEvdr actualizar la direccion del evaluador
     */
    public void setDireEvdr(String direEvdr) {
        this.direEvdr = direEvdr;
    }

    /**
     * @return  depaEval Departamento del evaluado
     */
    public String getDepaEval() {
        return depaEval;
    }

    /**
     * @param depaEval Para actualizar el departamento del evaluado
     */
    public void setDepaEval(String depaEval) {
        this.depaEval = depaEval;
    }

    /**
     * @return  depaEvdr Departamento del evaluador
     */
    public String getDepaEvdr() {
        return depaEvdr;
    }

    /**
     * @param depaEvdr  Para actualizar el departamento del evaluador
     */
    public void setDepaEvdr(String depaEvdr) {
        this.depaEvdr = depaEvdr;
    }

    /**
     * @return novedad  campo novedad del sistema de recursos humanos
     */
    public String getNovedad() {
        return novedad;
    }

    /**
     * @param novedad actualizar el campo novedad del sistema de recursos
     * humanos.
     */
    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }
    
    
    
    
    
}
