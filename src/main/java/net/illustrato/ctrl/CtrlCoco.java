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
import net.illustrato.mdl.coco.CompLabo;
import net.illustrato.mdl.coco.Evaluado;
import net.illustrato.mdl.coco.Evaluadr;
import net.illustrato.mdl.coco.TimoEval;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Permite poblar  la informacion necesaria para la concertacion de compromisos
 * laborales en la clase  y permite generar el reporte.
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
     * Metodo para obtener puntos por periodo esperados y logrados totales de
     * los compromisos laborales
     */
    private void sumPupe() {
        LOGGER.info("Inicia la totalizacion de los puntos");
        for (CompLabo compLabo : this.listCols) {
            LOGGER.debug("Puntos esperados:{} y puntos logrados:{} por objetivo estrategico {}", compLabo.getPupeEspe(), compLabo.getPupeLogr(), compLabo.getObjeEstr());
            this.totaPulo += compLabo.getPupeLogr();
            this.totaPues += compLabo.getPupeEspe();
        }
        LOGGER.debug("el total de puntos esperados {} y el total de puntos logrados ", this.totaPues, this.totaPulo);
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
        //Registra del archivo de excel
        Row row = null;
        //Celda en el archivo de excel
        Cell cell;
        //Hoja de excel
        Sheet sheet = null;
        //Numero de hojas en el libro de excel
        int numberOfSheets;
        //Es evaluacion definitiva
        boolean isevDefi = false;

        //Es evaluacion parcial
        boolean isevParc = false;

        //Constantes
        final String NOMBRE_HOJA = "COMPROMISOS LABORALES";

        // Fila y columna para 
        int fila = 0;

        int columna = 0;

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
                    sheet = workbook.getSheetAt(0);

                    LOGGER.debug("llenar informacion del evaluado");
                    LOGGER.debug("Se va actualizar la linea 6 celda 3. Valor Nombre Completo: {} ", evaluado.getNombComp());
                    row = sheet.getRow(6);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getNombComp());

                    LOGGER.debug("Se va actualizar la linea 7 celda 3. Valor Registro Laboral: {} ", evaluado.getRegiLabo());
                    row = null;
                    cell = null;

                    row = sheet.getRow(7);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getRegiLabo());

                    LOGGER.debug("Se va actualizar la linea 8 celda 3. Valor Registro Laboral: {} ", evaluado.getCargo());
                    row = null;
                    cell = null;

                    row = sheet.getRow(8);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getCargo());

                    LOGGER.debug("Se va actualizar la linea 9 celda 3. Valor Nivel Jerarquico: {} ", evaluado.getNiveJera());
                    row = null;
                    cell = null;

                    row = sheet.getRow(9);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getNiveJera());

                    LOGGER.debug("Se va actualizar la linea 10 celda 3. Valor Gerencia: {} ", evaluado.getGerencia());
                    row = null;
                    cell = null;

                    row = sheet.getRow(10);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getGerencia());

                    LOGGER.debug("Se va actualizar la linea 11 celda 3. Valor Departamento: {} ", evaluado.getDepartam());
                    row = null;
                    cell = null;

                    row = sheet.getRow(11);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getDepartam());

                    LOGGER.debug("Se va actualizar la linea 11 celda 3. Valor Area Funcional: {} ", evaluado.getAreaFunc());
                    row = null;
                    cell = null;

                    row = sheet.getRow(12);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getAreaFunc());

                    LOGGER.debug("Se va actualizar la linea 11 celda 3. Valor subproceso: {} ", evaluado.getSubProc());
                    row = null;
                    cell = null;

                    row = sheet.getRow(13);
                    cell = row.getCell(3);

                    cell.setCellValue(evaluado.getSubProc());

                    LOGGER.debug("Se inicia la escritura de evaluador ");

                    LOGGER.debug("Se va actualizar la linea 6 celda 12. Valor nombre completo: {}", evaluadr.getNombComp());
                    row = null;
                    cell = null;

                    row = sheet.getRow(6);
                    cell = row.getCell(12);

                    cell.setCellValue(evaluadr.getNombComp());

                    LOGGER.debug("Se va actualizar la linea 7 celda 12. Valor Registro laboral: {}", evaluadr.getRegiLabo());
                    row = null;
                    cell = null;

                    row = sheet.getRow(7);
                    cell = row.getCell(12);

                    cell.setCellValue(evaluadr.getRegiLabo());

                    LOGGER.debug("Se va actualizar la linea 8 celda 12. Valor Cargo: {}", evaluadr.getCargo());
                    row = null;
                    cell = null;

                    row = sheet.getRow(8);
                    cell = row.getCell(12);

                    cell.setCellValue(evaluadr.getCargo());

                    LOGGER.debug("Se va actualizar la linea 9 celda 12. Valor nivel jerarquico: {}", evaluadr.getNiveJera());
                    row = null;
                    cell = null;

                    row = sheet.getRow(9);
                    cell = row.getCell(12);

                    cell.setCellValue(evaluadr.getNiveJera());

                    LOGGER.debug("Se va actualizar la linea 10 celda 12. Valor gerencia: {}", evaluadr.getGerencia());
                    row = null;
                    cell = null;

                    row = sheet.getRow(10);
                    cell = row.getCell(12);

                    cell.setCellValue(evaluadr.getGerencia());

                    LOGGER.debug("Se va actualizar la linea 11 celda 12. Valor departamento: {}", evaluadr.getDepartam());
                    row = null;
                    cell = null;

                    row = sheet.getRow(11);
                    cell = row.getCell(12);

                    cell.setCellValue(evaluadr.getDepartam());

                    LOGGER.debug("Se va actualizar la linea 12 celda 12. Valor area funcional: {}", evaluadr.getAreaFunc());
                    row = null;
                    cell = null;

                    row = sheet.getRow(12);
                    cell = row.getCell(12);

                    cell.setCellValue(evaluadr.getAreaFunc());

                    LOGGER.debug("Se va actualizar la linea 13 celda 12. Valor subproceso: {}", evaluadr.getSubProc());
                    row = null;
                    cell = null;

                    row = sheet.getRow(13);
                    cell = row.getCell(12);

                    cell.setCellValue(evaluadr.getSubProc());

                    LOGGER.info("Finalizo escritura de evaluador ");

                    LOGGER.info("Se inicia la escritura de tipos y motivos de evaluacion ");

                    if (timoEval.getEvalDefi() != null && !timoEval.getEvalDefi().isEmpty()) {
                        isevDefi = true;
                    }

                    if (timoEval.getEvalParc() != null && !timoEval.getEvalParc().isEmpty()) {
                        isevParc = true;
                    }

                    if (isevParc && isevDefi) {
                        throw new Exception("Se debe elegir diligenciar, evaluacion parcial o definitiva. No es posible las dos");
                    }

                    LOGGER.debug("Se va actualizar la linea 15 celda 1. Valor Evaluacion Definitiva: {}", timoEval.getEvalDefi());
                    row = null;
                    cell = null;

                    row = sheet.getRow(15);
                    cell = row.getCell(1);

                    cell.setCellValue("EVALUACION DEFINITIVA: " + (timoEval.getEvalDefi() != null ? timoEval.getEvalDefi() : ""));

                    LOGGER.debug("Se va actualizar la linea 15 celda 10. Valor Evaluacion Parcial: {}", timoEval.getEvalParc());
                    row = null;
                    cell = null;

                    row = sheet.getRow(15);
                    cell = row.getCell(8);

                    cell.setCellValue("EVALUACION DEFINITIVA: " + (timoEval.getEvalParc() != null ? timoEval.getEvalParc() : ""));

                    LOGGER.debug("Se va actualizar la linea 16 celda 3. Valor Fecha Desde: {}", timoEval.getPeriDesd());
                    row = null;
                    cell = null;

                    row = sheet.getRow(16);
                    cell = row.getCell(3);

                    cell.setCellValue("DESDE: " + (timoEval.getPeriDesd() != null ? timoEval.getPeriDesd() : ""));

                    LOGGER.debug("Se va actualizar la linea 16 celda 8. Valor Fecha Desde: {}", timoEval.getPeriHast());
                    row = null;
                    cell = null;

                    row = sheet.getRow(16);
                    cell = row.getCell(8);

                    cell.setCellValue("HASTA: " + (timoEval.getPeriHast() != null ? timoEval.getPeriHast() : ""));

                    LOGGER.info("Se finaliza la escritura de tipos y motivos de evaluacion ");

                    LOGGER.info("Se inicia la escritura del proposito principal del cargo ");

                    LOGGER.debug("Se va actualizar la linea 18 celda 1. Valor  Proposito principal del cargo {}", evaluado.getPrprCarg());
                    row = null;
                    cell = null;

                    row = sheet.getRow(18);
                    cell = row.getCell(1);

                    cell.setCellValue(evaluado.getPrprCarg());

                    LOGGER.debug("Se finaliza la escritura del prosposito principal del cargo");

                    LOGGER.debug("Se inicia la  escritura de los compromisos laborales");

                    if (listCols.size() > 5) {
                        throw new Exception("El reporte soporta maximo 5 compromisos. Para aceptar compromisos adicionales se debe modifcar la plantilla.");
                    }

                    sumPupe();

                    fila = 22;

                    for (CompLabo compLabo : this.listCols) {

                        LOGGER.debug("Se va actualizar la linea {} celda 1. Valor  objetivo estrategico {}", fila, compLabo.getObjeEstr());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(1);

                        cell.setCellValue(compLabo.getObjeEstr());

                        LOGGER.debug("Se va actualizar la linea {} celda 3. Valor  compromisos del area {}", fila, compLabo.getCompArea());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(3);

                        cell.setCellValue(compLabo.getCompArea());

                        LOGGER.debug("Se va actualizar la linea {} celda 6. Valor  compromisos funciones cargo {}", fila, compLabo.getCompFuca());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(6);

                        cell.setCellValue(compLabo.getCompFuca());

                        LOGGER.debug("Se va actualizar la linea {} celda 9. Valor  meta {}", fila, compLabo.getMeta());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(9);

                        cell.setCellValue(compLabo.getMeta());

                        LOGGER.debug("Se va actualizar la linea {} celda 13. Valor  evidencia {}", fila, compLabo.getEvidencia());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(13);

                        cell.setCellValue(compLabo.getEvidencia());

                        LOGGER.debug("Se va actualizar la linea {} celda 15. Valor  puntos esperados {}", fila, compLabo.getPupeEspe());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(15);

                        cell.setCellValue(compLabo.getPupeEspe());

                        LOGGER.debug("Se va actualizar la linea {} celda 17. Valor  puntos logrados {}", fila, compLabo.getPupeLogr());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(17);

                        cell.setCellValue(compLabo.getPupeLogr());

                        fila++;

                    }
                    LOGGER.info("Fin de la actualizacion de compromisos");
                    LOGGER.info("Se procede a la actualizacion de puntajes totales");

                    LOGGER.debug("Se va actualizar la linea 27 celda 15. Valor  puntos totales esperados {}", this.totaPues);
                    row = null;
                    cell = null;

                    row = sheet.getRow(27);
                    cell = row.getCell(15);

                    cell.setCellValue(this.totaPues);

                    LOGGER.debug("Se va actualizar la linea 27 celda 18. Valor  puntos totales logrados {}",  this.totaPulo);
                    row = null;
                    cell = null;

                    row = sheet.getRow(27);
                    cell = row.getCell(17);

                    cell.setCellValue(this.totaPulo);

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
