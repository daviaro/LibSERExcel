
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import net.illustrato.ctrl.CtrlEmsc;
import net.illustrato.intfz.ReporteExcel;
import net.illustrato.mdl.core.Evidenci;
import net.illustrato.mdl.core.OptuMejo;
import net.illustrato.mdl.emsc.Empleado;
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
public class Pruebas3 {

    private final static Logger LOG = LogManager.getLogger(Pruebas.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LOG.info("Pruebas 222");
        System.out.println("Pruebas.main()");
        LOG.info("Pruebas 222");

        CtrlEmsc ctrlEmsc = new CtrlEmsc();

        ReporteExcel reporteExcel = null;

        List<Empleado> listEmpl = new ArrayList<>();

        Empleado empleado = new Empleado();

        empleado.setPeriodo("10-01-2017");

        empleado.setNumeRlev("333333444");

        empleado.setNombCoev("Adalbert David Aroca");

        empleado.setNombCoer("Pruebas evaluador ");

        empleado.setDireEval("Calle 109 - 80 ");

        empleado.setDireEvdr("Calle 180 - 90 ");

        empleado.setGereEval("gerencia evaluado");

        empleado.setGereEvdr("gerencia evaluador");

        empleado.setDepaEval("Pruebas 1");

        empleado.setDepaEvdr("Pruebas 2");

        empleado.setNijeCaev("Nivel Jerarquico");

        empleado.setNovedad("Novedad de nada");

        listEmpl.add(empleado);

        empleado = new Empleado();

        empleado.setPeriodo("01-01-2017 / 10-01-2017");

        empleado.setNumeRlev("333333444 2");

        empleado.setNombCoev("Adalbert David Aroca 2");

        empleado.setNombCoer("Pruebas evaluador 2");

        empleado.setDireEval("Calle 109 - 80 2");

        empleado.setDireEvdr("Calle 180 - 90 2");

        empleado.setGereEval("gerencia evaluado 2");

        empleado.setGereEvdr("gerencia evaluador 2");

        empleado.setDepaEval("Pruebas 1 2");

        empleado.setDepaEvdr("Pruebas 2 2");

        empleado.setNijeCaev("Nivel Jerarquico 2");

        empleado.setNovedad("Novedad de nada 2");

        listEmpl.add(empleado);
        
        
        empleado = new Empleado();

        empleado.setPeriodo("01-01-2017 / 10-01-2017 3");

        empleado.setNumeRlev("333333444 3");

        empleado.setNombCoev("Adalbert David Aroca 3");

        empleado.setNombCoer("Pruebas evaluador 3");

        empleado.setDireEval("Calle 109 - 80 3");

        empleado.setDireEvdr("Calle 180 - 90 3");

        empleado.setGereEval("gerencia evaluado 3");

        empleado.setGereEvdr("gerencia evaluador 3");

        empleado.setDepaEval("Pruebas 1 3");

        empleado.setDepaEvdr("Pruebas 2 3");

        empleado.setNijeCaev("Nivel Jerarquico 3");

        empleado.setNovedad("Novedad de nada 3");

        listEmpl.add(empleado);
        
        
        empleado = new Empleado();

        empleado.setPeriodo("01-01-2017 / 10-01-2017 4");

        empleado.setNumeRlev("333333444 4");

        empleado.setNombCoev("Adalbert David Aroca 4");

        empleado.setNombCoer("Pruebas evaluador 4");

        empleado.setDireEval("Calle 109 - 80 4");

        empleado.setDireEvdr("Calle 180 - 90 4");

        empleado.setGereEval("gerencia evaluado 4");

        empleado.setGereEvdr("gerencia evaluador 4");

        empleado.setDepaEval("Pruebas 1 4");

        empleado.setDepaEvdr("Pruebas 2 4");

        empleado.setNijeCaev("Nivel Jerarquico 4");

        empleado.setNovedad("Novedad de nada 4");

        listEmpl.add(empleado);
        
        empleado = new Empleado();

        empleado.setPeriodo("01-01-2017 / 10-01-2017 5");

        empleado.setNumeRlev("333333444 5");

        empleado.setNombCoev("Adalbert David Aroca 5");

        empleado.setNombCoer("Pruebas evaluador 5");

        empleado.setDireEval("Calle 109 - 80 5");

        empleado.setDireEvdr("Calle 180 - 90 5");

        empleado.setGereEval("gerencia evaluado 5");

        empleado.setGereEvdr("gerencia evaluador 5");

        empleado.setDepaEval("Pruebas 1 5");

        empleado.setDepaEvdr("Pruebas 2 5");

        empleado.setNijeCaev("Nivel Jerarquico 5");

        empleado.setNovedad("Novedad de nada 5");

        listEmpl.add(empleado);
        
        
        empleado = new Empleado();

        empleado.setPeriodo("01-01-2017 / 10-01-2017 6");

        empleado.setNumeRlev("333333444 6");

        empleado.setNombCoev("Adalbert David Aroca 6");

        empleado.setNombCoer("Pruebas evaluador 6");

        empleado.setDireEval("Calle 109 - 80 6");

        empleado.setDireEvdr("Calle 180 - 90 6");

        empleado.setGereEval("gerencia evaluado 6");

        empleado.setGereEvdr("gerencia evaluador 6");

        empleado.setDepaEval("Pruebas 1 6");

        empleado.setDepaEvdr("Pruebas 2 6");

        empleado.setNijeCaev("Nivel Jerarquico 6");

        empleado.setNovedad("Novedad de nada 6");

        listEmpl.add(empleado);
        
        empleado = new Empleado();

        empleado.setPeriodo("01-01-2017 / 10-01-2017 7");

        empleado.setNumeRlev("333333444 7");

        empleado.setNombCoev("Adalbert David Aroca 7");

        empleado.setNombCoer("Pruebas evaluador 7");

        empleado.setDireEval("Calle 109 - 80 7");

        empleado.setDireEvdr("Calle 180 - 90 7");

        empleado.setGereEval("gerencia evaluado 7");

        empleado.setGereEvdr("gerencia evaluador 7");
        
        empleado.setCargEval("Pruebas evaluado 7");
        
        empleado.setCargEvar("Pruebas evaluador 7");

        empleado.setDepaEval("Pruebas 1 7");

        empleado.setDepaEvdr("Pruebas 2 7");

        empleado.setNijeCaev("Nivel Jerarquico 7");

        empleado.setNovedad("Novedad de nada 7");

        listEmpl.add(empleado);

        ctrlEmsc.setListEmpl(listEmpl);

        reporteExcel = ctrlEmsc;

        try {
            reporteExcel.escribirExcel("/Users/adalbertdavidaroca/NetBeansProjects/LibSERExcel/plantillas/hu14.xls", "/Users/adalbertdavidaroca/NetBeansProjects/LibSERExcel/plantillas", "hu14-prueb.xls");
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
