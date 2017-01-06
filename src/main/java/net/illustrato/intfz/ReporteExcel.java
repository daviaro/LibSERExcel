
package net.illustrato.intfz;

/**
 * Esta interfaz tiene un metodo que se encarga de escribir un archivo excel 
 * apartir de una plantilla.
 * 
 * @author adalbertdavidaroca
 */
public interface ReporteExcel {
    /**
     *  
     * Se crea este metodo para realizar la escritura de un archivo en excel, 
     * apartir de un formato existente
     * en la hoja de EXCEL, en la pestaña Ingresos.
     * @param pathPlan ruta de la plantilla
     * @param pathDeex ruta destino donde se va almacenar la plantilla. 
     * @param nombResa nombre reporte salida
     * 
     * @throws Exception indica que el metodo genera excepciones que deben
     * ser capturadas para identificar cuando la misma no funcione bien.
     */
    public void escribirExcel(String pathPlan,String pathDeex,String nombResa) throws Exception;
    
}
