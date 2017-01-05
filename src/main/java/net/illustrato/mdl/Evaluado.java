

package net.illustrato.mdl;

import java.io.Serializable;

/**
 * Esta clase se usa para manipular los datos correspondientes al Evaluado.
 * 
 * @author adalbertdavidaroca
 */
public class Evaluado implements Serializable{
    
    
    /**
    * Se almacena el nombre completo del evaluado.   
    */
    private String nombComp;
    
    /**
     * Se almacena el registro laboral del evaluado.
     */
    private String regiLabo;
    
    /**
     * Se almacena el cargo del evaluado
     * 
     */
    
    private String cargo;
    
    /**
     * Se almacena el nivel jerarquico del evaluado
     */
    
    private String niveJera;
    
    /**
     * Se almacena la gerencia del evaluado
     */
    
    private String gerencia;
    
    /**
     * Se almacena el departamento o direccion del evaluado
     */
    
    private String departam;
    
    /**
     * Se almacena el Area Funcional del evaluado
     */
    
    private String areaFunc;
    
    /**
     * Se almacena el proceso/subprocesos del evaluado
     */
    private String subProc;
    
    /**
     * Proposito principal del cargo que desempleña el evaluado
     */
    private String prprCarg;

    /**
     * @return nombComp el nombre completo del evaluado
     */
    public String getNombComp() {
        return nombComp;
    }

    /**
     * @param nombComp para actualizar el nombre completo del evaluado
     */
    public void setNombComp(String nombComp) {
        this.nombComp = nombComp;
    }

    /**
     * @return  regiLabo el registro laboral del evaluado. 
     */
    public String getRegiLabo() {
        return regiLabo;
    }

    /**
     * @param regiLabo para actualizar el Registro Laboral del evaluado.
     */
    public void setRegiLabo(String regiLabo) {
        this.regiLabo = regiLabo;
    }

    /**
     * @return cargo el cargo del evaluado
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo para actualizar el cargo del evaluado.
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return  niveJera el nivel jerarquico del evaluado.
     */
    public String getNiveJera() {
        return niveJera;
    }

    /**
     * @param niveJera para actualizar el nivel jerarquico
     */
    public void setNiveJera(String niveJera) {
        this.niveJera = niveJera;
    }

    /**
     * @return  gerencia la gerencia del evaluado.
     */
    public String getGerencia() {
        return gerencia;
    }

    /**
     * @param gerencia para actualizar la gerencia 
     */
    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    /**
     * @return  departam el departamento del evaluado.
     */
    public String getDepartam() {
        return departam;
    }

    /**
     * @param departam para actualizar el departamento del evaluado.
     */
    public void setDepartam(String departam) {
        this.departam = departam;
    }

    /**
     * @return areaFunc el area funcional del evaluado.
     */
    public String getAreaFunc() {
        return areaFunc;
    }

    /**
     * @param areaFunc para actualizar el area funcional del evaluado.
     */
    public void setAreaFunc(String areaFunc) {
        this.areaFunc = areaFunc;
    }

    /**
     * @return  subProc el proceso/subproceso del evaluado
     */
    public String getSubProc() {
        return subProc;
    }

    /**
     * @param subProc para actualizar proceso/subproceso del evaluado
     */
    public void setSubProc(String subProc) {
        this.subProc = subProc;
    }

    /**
     * @return  prprCarg el proposito principal del cargo del evaluado
     */
    public String getPrprCarg() {
        return prprCarg;
    }

    /**
     * @param prprCarg para actualizar el proposito principal del cargo.
     * 
     */
    public void setPrprCarg(String prprCarg) {
        this.prprCarg = prprCarg;
    }
    
    
    
    
}
