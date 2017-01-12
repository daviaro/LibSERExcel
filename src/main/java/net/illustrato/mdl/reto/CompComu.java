/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.illustrato.mdl.reto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author adalbertdavidaroca
 */
public class CompComu implements Serializable{

    /**
     * Encabezado de la competencia comportamental comun
     */
    private String encaCocc;

    /**
     * Descripcion de la competencia comportamental comun
     */
    private String descCocc;

    /**
     * Listado de competencias asociadas
     */
    private List<CondAsoc> listCoas;

    /**
     * promedio puntaje por competencia.
     */
    private int promPunt;

    /**
     * Indica con x si es una competencia critica
     */
    private String compCrit;

    /**
     * Indica con x si es una competencia aceptable
     */
    private String compAcep;

    /**
     * Indica con x si es una competencia deseable
     */
    private String compDese;

    /**
     * @return  encaCocc encabezado Competencia Comportamentales comunes
     */
    public String getEncaCocc() {
        return encaCocc;
    }

    /**
     * @param encaCocc actualizar el encabezado Competencia Comportamentales comunes
     */
    public void setEncaCocc(String encaCocc) {
        this.encaCocc = encaCocc;
    }

    /**
     * @return descCocc Descripcion de la competencia comportamental comun.
     */
    public String getDescCocc() {
        return descCocc;
    }

    /**
     * @param descCocc  descCocc actualizar la competencia comportamental comun.
     */
    public void setDescCocc(String descCocc) {
        this.descCocc = descCocc;
    }

    /**
     * @return  listCoas lista de comportamientos 
     */
    public List<CondAsoc> getListCoas() {
        return listCoas;
    }

    /**
     * @param listCoas para actualizar el listado de conductas
     */
    public void setListCoas(List<CondAsoc> listCoas) {
        this.listCoas = listCoas;
    }

    /**
     * @return  promPunt promedio del puntaje de calificacion de la competencia
     */
    public int getPromPunt() {
        return promPunt;
    }

    /**
     * @param promPunt actualizar el promedio de la calificacion 
     */
    public void setPromPunt(int promPunt) {
        this.promPunt = promPunt;
    }

    /**
     * @return  compCrit retorna x para indicar componente critico, de lo contrario
     * vacio.
     */
    public String getCompCrit() {
        return compCrit;
    }

    /**
     * @param compCrit actualizar el campo para indicar si es una componente critico
     */
    public void setCompCrit(String compCrit) {
        this.compCrit = compCrit;
    }

    /**
     * @return  compAcep retorna x para indicar el componente critico, de lo 
     * contrario vacio.
     */
    public String getCompAcep() {
        return compAcep;
    }

    /**
     * @param compAcep actualizar el campo para inidicar si es un componente Aceptable,
     * de lo contrario se deja vacio
     */
    public void setCompAcep(String compAcep) {
        this.compAcep = compAcep;
    }

    /**
     * @return  compDese retorna x para indicar el componente deseable, de lo
     * contrario vacio.
     */
    public String getCompDese() {
        return compDese;
    }

    /**
     * @param compDese actualizar el campo para indicar si es un componente deseable, de lo 
     * contrario vacio.
     */
    public void setCompDese(String compDese) {
        this.compDese = compDese;
    }
    
    

}
