
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import net.illustrato.ctrl.CtrlAgre;
import net.illustrato.ctrl.CtrlCoco;
import net.illustrato.intfz.ReporteExcel;
import net.illustrato.mdl.coco.CompLabo;
import net.illustrato.mdl.coco.Evaluado;
import net.illustrato.mdl.coco.Evaluadr;
import net.illustrato.mdl.coco.TimoEval;
import net.illustrato.mdl.core.Evidenci;
import net.illustrato.mdl.core.OptuMejo;
import net.illustrato.mdl.reto.CompExce;
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
public class Pruebas4 {

    private final static Logger LOG = LogManager.getLogger(Pruebas.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LOG.info("Pruebas 222");
        System.out.println("Pruebas.main()");
        LOG.info("Pruebas 222");

        CtrlAgre ctrlAgre = new CtrlAgre();

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

        ctrlAgre.setTimoEval(timoEval);
        ctrlAgre.setEvaluado(evaluado);
        ctrlAgre.setEvaluadr(evaluadr);

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

        ctrlAgre.setListCols(listLa);

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

        ctrlAgre.setListOpme(listOpme);

        Evidenci evidenci = new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 1");

        listEvid.add(evidenci);

        evidenci = new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 2");

        listEvid.add(evidenci);

        evidenci = new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 3");

        listEvid.add(evidenci);

        evidenci = new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 4");

        listEvid.add(evidenci);

        evidenci = new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 5");

        listEvid.add(evidenci);

        evidenci = new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 6");

        listEvid.add(evidenci);

        evidenci = new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 7");

        listEvid.add(evidenci);

        evidenci = new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 8");

        listEvid.add(evidenci);

        evidenci = new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 9");

        listEvid.add(evidenci);

        evidenci = new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 10");

        listEvid.add(evidenci);

        evidenci = new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 11");

        listEvid.add(evidenci);

        evidenci = new Evidenci();
        evidenci.setFecha("10-12-2016");
        evidenci.setDescripc("pruebas de la evidencia 12");

        listEvid.add(evidenci);

        ctrlAgre.setExcelent("X");
        ctrlAgre.setSatisfac("X");
        ctrlAgre.setNoSatisf("X");

        ctrlAgre.setSiinRecu("X");
        ctrlAgre.setNoinRecu("X");
        ctrlAgre.setListEvid(listEvid);
        
        //Quinta hoja compromisos de excelencia e innovacion
        
        CompExce compExce= new CompExce();
        
        compExce.setNombProy("Software para recursos humanos");
        compExce.setObjeEstr("Pruebas Objetivo estrategico");
        compExce.setPlanProb("Planteamiento del problema");
        compExce.setDescripc("Descripcion del problema o proyecto ");
        compExce.setFundJust("Fundamentos y justificacion");
        compExce.setObjetivo("Objetivos ");
        compExce.setUbicacio("Ubicacion del proyecto");
        compExce.setBenefiac("Beneficiarios del proyecto");
        compExce.setMetodolo("Metodologias");
        compExce.setCronogra("Listado de links");
        compExce.setMetaIndi("Metas e indicadores");
        compExce.setPresupue("Presupuestos y costos");
        compExce.setCaliExce(10);
        
        ctrlAgre.setCompExce(compExce);

        reporteExcel = ctrlAgre;

        try {
            reporteExcel.escribirExcel("/Users/adalbertdavidaroca/NetBeansProjects/LibSERExcel/plantillas/hu16.xls", "/Users/adalbertdavidaroca/NetBeansProjects/LibSERExcel/plantillas", "hu16-prueb.xls");
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
