/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.illustrato.ctrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.channels.FileChannel;
import java.util.List;
import net.illustrato.intfz.ReporteExcel;
import net.illustrato.mdl.CompLabo;
import net.illustrato.mdl.Evaluado;
import net.illustrato.mdl.Evaluadr;
import net.illustrato.mdl.TimoEval;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Que obtiene la informacion necesaria para la concertacion de compromisos
 * laborales y permite generar el reporte
 *
 * @author adalbertdavidaroca
 */
public class CtrlCoco implements Serializable, ReporteExcel {

    private static final Logger LOGGER = LogManager.getLogger(CtrlCoco.class);

    /**
     * Se almacena la informacion sobre el evaluado
     */
    private Evaluado evaluado;

    /**
     * Se almacen la informacion sobre el evaluador.
     */
    private Evaluadr evaluadr;

    /**
     * Tipos o motivos de la evaluacion.
     */
    private TimoEval timoEval;

    /**
     * Listado de compromisos laborales.
     */
    private List<CompLabo> listCols;

    /**
     * total de puntos por periodo esperados segun la lista de compromisos
     * laborales
     */
    private int totaPues;

    /**
     * total de puntos por periodo logrados segun la lista de compromisos
     * laborales
     */
    private int totaPulo;

    /**
     * @return evaluado Toda la informacion que requiere la HU3 sobre el
     * evaluado.
     */
    public Evaluado getEvaluado() {
        return evaluado;
    }

    /**
     * @param evaluado actualizar al evaluado segun HU3.
     */
    public void setEvaluado(Evaluado evaluado) {
        this.evaluado = evaluado;
    }

    /**
     * @return evaluadr Toda la informacion que requiere la HU3 sobre el
     * evaluador
     */
    public Evaluadr getEvaluadr() {
        return evaluadr;
    }

    /**
     * @param evaluadr actualizar informacion sobre el evaluador.
     */
    public void setEvaluadr(Evaluadr evaluadr) {
        this.evaluadr = evaluadr;
    }

    /**
     * @return timoEval informacion sobre los tipos y motivos de la evaluacion
     */
    public TimoEval getTimoEval() {
        return timoEval;
    }

    /**
     * @param timoEval Para actualizar informacion de los tipos o motivos de la
     * evaluacion.
     */
    public void setTimoEval(TimoEval timoEval) {
        this.timoEval = timoEval;
    }

    /**
     * @return listCols listado de compromisos laborales.
     */
    public List<CompLabo> getListCols() {
        return listCols;
    }

    /**
     * @param listCols actualizar el listado de compromisos laborales
     */
    public void setListCols(List<CompLabo> listCols) {
        this.listCols = listCols;
    }

    /**
     * @return totaPues total puntos esperados evaluacion de compromisos
     */
    public int getTotaPues() {
        return totaPues;
    }

    /**
     * @param totaPues actualizar el total de puntos esperados.
     */
    public void setTotaPues(int totaPues) {
        this.totaPues = totaPues;
    }

    /**
     * @return totaPulo Total puntos logrados evaluacion de compromisos.
     */
    public int getTotaPulo() {
        return totaPulo;
    }

    /**
     * @param totaPulo Para actualizar el total de puntos logrados.
     */
    public void setTotaPulo(int totaPulo) {
        this.totaPulo = totaPulo;
    }

    /**
     *
     * Este metodo toma la informacion que se diligencia en la clase y genera un
     * archivo en excel a partir de una plantilla.
     *
     * @param pathPlan la ruta donde esta la plantilla en excel HU3
     * @param pathDeex la ruta donde se va a depositar el excel generado.
     * @param nombResa Nombre reporte de salida.
     * @throws Exception indica que el metodo genera excepciones que deben ser
     * capturadas para identificar cuando la misma no funcione bien.
     *
     */
    @Override
    public void escribirExcel(String pathPlan, String pathDeex, String nombResa) throws Exception {

        LOGGER.info("Iniciando escritura del archivo en excel");

        LOGGER.debug("Ruta de la plantilla {}", pathPlan);
        LOGGER.debug("Ruta donde se va a escribir la plantilla {} ", pathDeex);

        //Archivo Origen
        File archOrig = null;
        //Archivo  Destino
        File archDest = null;
        //ruta completa de la plantilla
        String pathDefi = pathDeex + File.separator + nombResa;
        //Fila inicial
        int filaInit = 0;
        //Celda incial
        int celdInit = 1;

        //Registra del archivo de excel
        Row row = null;
        //Celda en el archivo de excel
        Cell cell;
        //Hoja de excel
        Sheet sheet = null;
        //Numero de hojas en el libro de excel
        int numberOfSheets;

        //Constantes
        final String NOMBRE_HOJA = "COMPROMISOS LABORALES";

        try {
            archOrig = new File(pathPlan);

            if (!archOrig.exists()) {
                LOGGER.debug("Plantilla no existe en la ruta {} ", pathPlan);
                throw new IOException("La plantilla no existe en la ruta " + pathPlan);
            }

            archDest = new File(pathDeex);

            if (!archDest.exists()) {
                LOGGER.debug("Ruta no existe donde se va a depositar el excel {} , se va a crear", pathDeex);
                archDest.mkdirs();
            }

            LOGGER.info("Ruta del archivo a crear {}", pathDefi);
            archDest = new File(pathDefi);

            if (!archDest.exists()) {
                LOGGER.info("No existe el archivo en la ruta  {}, se procede a la creacion ", pathDefi);
                archDest.createNewFile();
            } else {

                LOGGER.info("el archivo que se requiere crear, ya existe {} se va a recrear", pathDefi);
                archDest.delete();
                LOGGER.info("archivo en la ruta {}, borrado", pathDefi);
                archDest.createNewFile();

                LOGGER.info("archivo en la ruta {}, se vuelve a crear", pathDefi);

            }

            LOGGER.info("Se inicia con la copia de la plantilla de la ruta {} a la ruta {} ", pathPlan, pathDefi);
            try (FileChannel archTror = new FileInputStream(archOrig).getChannel();
                    FileChannel archTrDe = new FileOutputStream(archDest).getChannel();) {

                archTrDe.transferFrom(archTror, 0, archTror.size());

                LOGGER.info("Termina la copia del archivo");

            } catch (Exception e) {
                LOGGER.info("Se genera un error con la transferencia {} ", e.getMessage());
                throw new Exception("Error [" + e.getMessage() + "]");
            }

            LOGGER.info("Se inicia con el diligenciamiento del formato ");

            LOGGER.info("Nombre Archivo {}", archDest.getName());
            if (!archDest.getName().toLowerCase().endsWith("xls")) {
                throw new Exception("La plantilla debe tener extension xls");
            }

            try (FileInputStream fis = new FileInputStream(archDest);
                    Workbook workbook = new HSSFWorkbook(fis);
                    FileOutputStream fos = new FileOutputStream(archDest);) {

                if (workbook != null) {
                    numberOfSheets = workbook.getNumberOfSheets();
                    LOGGER.debug("Numero de hojas {}", numberOfSheets);

                    LOGGER.info("Hoja seleccionada:{}", NOMBRE_HOJA);
                    sheet = workbook.getSheet(NOMBRE_HOJA);

                    LOGGER.debug("Se va actualizar la linea 8 celda 3");
                    row = sheet.getRow(6);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getNombComp());
                    
                    row =null;
                    cell = null;
                    
                    row = sheet.getRow(7);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getRegiLabo());
                    
                    row =null;
                    cell = null;
                    
                    row = sheet.getRow(8);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getCargo());
                    
                    row =null;
                    cell = null;
                    
                    row = sheet.getRow(9);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getNiveJera());
                    
                    row =null;
                    cell = null;
                    
                    row = sheet.getRow(10);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getGerencia());
                    
                    row =null;
                    cell = null;
                    
                    row = sheet.getRow(11);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getDepartam());
                    
                    row =null;
                    cell = null;
                    
                    row = sheet.getRow(12);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getAreaFunc());
                    
                    row =null;
                    cell = null;
                    
                    row = sheet.getRow(13);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getSubProc());
                    
                   
                    workbook.write(fos);

                } else {
                    throw new Exception("No se cargo de manera adecuada el archivo ");
                }

            } catch (Exception e) {
                System.out.println("" + e.getMessage());
            } 

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

}
