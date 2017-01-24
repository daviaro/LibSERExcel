
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import net.illustrato.ctrl.CtrlCore;
import net.illustrato.intfz.ReporteExcel;
import net.illustrato.mdl.core.Evidenci;
import net.illustrato.mdl.core.OptuMejo;
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
public class Pruebas2 {

    private final static Logger LOG = LogManager.getLogger(Pruebas.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LOG.info("Pruebas 222");
        System.out.println("Pruebas.main()");
        LOG.info("Pruebas 222");

        CtrlCore ctrlCore = new CtrlCore();

        ReporteExcel reporteExcel = null;

       List<OptuMejo> listOpme = new ArrayList<>();
       List<Evidenci> listEvid = new ArrayList<>();


        OptuMejo optuMejo = new OptuMejo();
        optuMejo.setCapaTecn("Mejorar conocimientos sobre base de datos NOSQL");
        optuMejo.setComporta("Mas responsabilidad para los horarios de entrada.");

        listOpme.add(optuMejo);
        
        
        optuMejo = new OptuMejo();
        optuMejo.setCapaTecn("Mejorar conocimientos sobre base de datos NOSQL");
        optuMejo.setComporta("Mas responsabilidad para los horarios de entrada.");

        listOpme.add(optuMejo);
        
        optuMejo = new OptuMejo();
        optuMejo.setCapaTecn("Mejorar conocimientos sobre base de datos NOSQL");
        optuMejo.setComporta("Mas responsabilidad para los horarios de entrada.");

        listOpme.add(optuMejo);
        
        
        optuMejo = new OptuMejo();
        optuMejo.setCapaTecn("Mejorar conocimientos sobre base de datos NOSQL");
        optuMejo.setComporta("Mas responsabilidad para los horarios de entrada.");

        listOpme.add(optuMejo);
        
        
        optuMejo = new OptuMejo();
        optuMejo.setCapaTecn("Mejorar conocimientos sobre base de datos NOSQL");
        optuMejo.setComporta("Mas responsabilidad para los horarios de entrada.");

        listOpme.add(optuMejo);
        
        optuMejo = new OptuMejo();
        optuMejo.setCapaTecn("Mejorar conocimientos sobre base de datos NOSQL");
        optuMejo.setComporta("Mas responsabilidad para los horarios de entrada.");

        listOpme.add(optuMejo);
        
        optuMejo = new OptuMejo();
        optuMejo.setCapaTecn("Mejorar conocimientos sobre base de datos NOSQL");
        optuMejo.setComporta("Mas responsabilidad para los horarios de entrada.");

        listOpme.add(optuMejo);

        ctrlCore.setListOpme(listOpme);
        
        
        Evidenci evidenci=new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 1");

        listEvid.add(evidenci);
        
        evidenci=new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 2");

        listEvid.add(evidenci);
        
        evidenci=new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 3");

        listEvid.add(evidenci);
        
        
        evidenci=new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 4");

        listEvid.add(evidenci);
        
        evidenci=new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 5");

        listEvid.add(evidenci);
        
        evidenci=new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 6");

        listEvid.add(evidenci);
        
        
        evidenci=new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 7");

        listEvid.add(evidenci);
        
        
        evidenci=new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 8");

        listEvid.add(evidenci);
        
        evidenci=new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 9");

        listEvid.add(evidenci);
        
        
        evidenci=new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 10");

        listEvid.add(evidenci);
        
        
        evidenci=new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 11");

        listEvid.add(evidenci);
        
        
        evidenci=new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 12");

        listEvid.add(evidenci);
        
        ctrlCore.setExcelent("X");
        ctrlCore.setSatisfac("X");
        ctrlCore.setNoSatisf("X");
        
        ctrlCore.setSiinRecu("X");
        ctrlCore.setNoinRecu("X");
        ctrlCore.setListEvid(listEvid);
        
        reporteExcel = ctrlCore;

        try {
            reporteExcel.escribirExcel("/Users/adalbertdavidaroca/NetBeansProjects/LibSERExcel/plantillas/hu11.xls", "/Users/adalbertdavidaroca/NetBeansProjects/LibSERExcel/plantillas", "hu11-prueb.xls");
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
