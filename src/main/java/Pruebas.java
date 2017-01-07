
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import net.illustrato.ctrl.CtrlCoco;
import net.illustrato.intfz.ReporteExcel;
import net.illustrato.mdl.CompLabo;
import net.illustrato.mdl.Evaluado;
import net.illustrato.mdl.Evaluadr;
import net.illustrato.mdl.TimoEval;
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

        ReporteExcel reporteExcel = null;

        Evaluado evaluado = new Evaluado();

        evaluado.setNombComp("Adalbert David Aroca Lancheros");

        evaluado.setRegiLabo("Registro Laboral 1");

        evaluado.setCargo("Ingeniero de desarrollo senior master 3");

        evaluado.setNiveJera("Pruebas nivel Jeraraquico");

        evaluado.setDepartam("Sistemas");

        evaluado.setGerencia("Gerencia TI");

        evaluado.setAreaFunc("TODAS");

        evaluado.setSubProc("Prueba de descripcion de proceso y subproceso de evaluado");

        evaluado.setPrprCarg("se necesita que el colaborador realice las metas pactadas para su cargo durante.....");

        Evaluadr evaluadr = new Evaluadr();

        evaluadr.setNombComp("Nombre completo evaluador");

        evaluadr.setRegiLabo("Registro laboral");

        evaluadr.setCargo("Cargo prueba");

        evaluadr.setNiveJera("Pruebas nivel Jeraraquico r");

        evaluadr.setDepartam("Sistemas r");

        evaluadr.setGerencia("Gerencia TI r ");

        evaluadr.setAreaFunc("TODAS r");

        evaluadr.setSubProc("Prueba de descripcion de proceso y subproceso de evaluado r");

        TimoEval timoEval = new TimoEval();

        timoEval.setEvalDefi("");
        timoEval.setEvalParc("X");
        timoEval.setPeriDesd("333333");
        timoEval.setPeriHast("666666");

        ctrlCoco.setTimoEval(timoEval);
        ctrlCoco.setEvaluado(evaluado);
        ctrlCoco.setEvaluadr(evaluadr);

        CompLabo compLabo = new CompLabo();
        compLabo.setObjeEstr("Objetivo 1");
        compLabo.setMeta("Meta 1");
        compLabo.setCompArea("Compromis 1");
        compLabo.setCompFuca("funciones de cargo 1");
        compLabo.setEvidencia("Evidencia 1");
        compLabo.setPupeEspe(10);
        compLabo.setPupeLogr(5);

        List<CompLabo> listLa = new ArrayList<>();

        listLa.add(compLabo);

        compLabo = new CompLabo();
        compLabo.setObjeEstr("Objetivo 2");
        compLabo.setMeta("Meta 2");
        compLabo.setCompArea("Compromis 2");
        compLabo.setCompFuca("funciones de cargo 2");
        compLabo.setEvidencia("Evidencia 2");
        compLabo.setPupeEspe(10);
        compLabo.setPupeLogr(7);

        listLa.add(compLabo);

        ctrlCoco.setListCols(listLa);

        reporteExcel = ctrlCoco;

        try {
            reporteExcel.escribirExcel("/Users/adalbertdavidaroca/NetBeansProjects/LibSERExcel/plantillas/hu3.xls", "/Users/adalbertdavidaroca/NetBeansProjects/LibSERExcel/plantillas", "hu3-prueb.xls");
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
