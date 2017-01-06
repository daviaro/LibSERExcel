
import java.util.logging.Level;
import net.illustrato.ctrl.CtrlCoco;
import net.illustrato.intfz.ReporteExcel;
import net.illustrato.mdl.Evaluado;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adalbertdavidaroca
 */
public class Pruebas {

    private final static Logger LOG = LogManager.getLogger(Pruebas.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LOG.info("Pruebas 222");
        System.out.println("Pruebas.main()");
        LOG.info("Pruebas 222");

        CtrlCoco ctrlCoco = new CtrlCoco();
        
        ReporteExcel reporteExcel=null;
        
        Evaluado evaluado = new Evaluado();
        
        evaluado.setNombComp("Adalbert David Aroca Lancheros");
        
        evaluado.setRegiLabo("Registro Laboral 1");
        
        evaluado.setCargo("Ingeniero de desarrollo senior master 3");
        
        evaluado.setNiveJera("Pruebas nivel Jeraraquico");
        
        evaluado.setDepartam("Sistemas");
        
        evaluado.setGerencia("Gerencia TI");
        
        evaluado.setAreaFunc("TODAS");
        
        evaluado.setSubProc("Prueba de descripcion de proceso y subproceso de evaluado");
        
        ctrlCoco.setEvaluado(evaluado);
        
        reporteExcel = ctrlCoco;

        try {
            reporteExcel.escribirExcel("/Users/adalbertdavidaroca/NetBeansProjects/LibSERExcel/plantillas/hu3.xls", "/Users/adalbertdavidaroca/NetBeansProjects/LibSERExcel/plantillas", "hu3-prueb.xls");
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
