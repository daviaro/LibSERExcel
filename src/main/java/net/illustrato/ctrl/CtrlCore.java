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
import net.illustrato.mdl.core.Evidenci;
import net.illustrato.mdl.core.OptuMejo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * Permite poblar la informacion necesaria para la consolidacion de resultados
 * en la clase y permite generar el reporte.
 *
 * @author adalbertdavidaroca
 */
public class CtrlCore implements ReporteExcel, Serializable {

    private static final Logger LOGGER = LogManager.getLogger(CtrlCore.class);

    /**
     * Lista de oportunidades de mejora; mejora tecnica y/o de comportamiento.
     */
    private List<OptuMejo> listOpme;

    /**
     * Lista de evidencias.
     */
    private List<Evidenci> listEvid;

    /**
     * Escala de calificacion. Es excelente.
     */
    private String excelent;

    /**
     * Escala de calificacion. Es satisfactorio.
     */
    private String satisfac;

    /**
     * Escala de calificacion. No es satisfactorio.
     */
    private String noSatisf;

    /**
     * Total de calificacion.
     */
    private int numeToca;

    /**
     * X Si interpone recursos
     */
    private String siinRecu;

    /**
     * X Nointerpone recursos
     */
    private String noinRecu;

    /**
     * @return listOpme La lista de oprtunidades de mejora.
     */
    public List<OptuMejo> getListOpme() {
        return listOpme;
    }

    /**
     * @param listOpme actualizar la lista de oportunidades de mejora.
     */
    public void setListOpme(List<OptuMejo> listOpme) {
        this.listOpme = listOpme;
    }

    /**
     * @return listEvid lista de evidencias
     */
    public List<Evidenci> getListEvid() {
        return listEvid;
    }

    /**
     * @param listEvid actualizar lista de evidencias.
     */
    public void setListEvid(List<Evidenci> listEvid) {
        this.listEvid = listEvid;
    }

    /**
     * @return excelent Se obtiene X si el total de puntos esta entre 91-100
     */
    public String getExcelent() {
        return excelent;
    }

    /**
     * @param excelent Se actualiza con X si los puntos totales estan entre 91 -
     * 100
     */
    public void setExcelent(String excelent) {
        this.excelent = excelent;
    }

    /**
     * @return satisfac Se obtiene X si el total de puntos esta entre 78-90
     */
    public String getSatisfac() {
        return satisfac;
    }

    /**
     * @param satisfac Se actualiza con X si los puntos totales estan entre 78 -
     * 90
     */
    public void setSatisfac(String satisfac) {
        this.satisfac = satisfac;
    }

    /**
     *
     * @return noSatisf X si no es satisfactorio.
     */
    public String getNoSatisf() {
        return noSatisf;
    }

    /**
     *
     * @param noSatisf para actualizar con X si no es satisfactorio
     */
    public void setNoSatisf(String noSatisf) {
        this.noSatisf = noSatisf;
    }

    /**
     * @return numeToca Se obtiene X si el total de puntos esta entre
     */
    public int getNumeToca() {
        return numeToca;
    }

    /**
     * @param numeToca Se actualiza el numero total de calificacion.
     */
    public void setNumeToca(int numeToca) {
        this.numeToca = numeToca;
    }

    /**
     *
     * @return siinRecu Una X si interpone recursos
     */
    public String getSiinRecu() {
        return siinRecu;
    }

    /**
     *
     * @param siinRecu Para actualizar con una X si hay recursos. Vacio si no
     * interpone recursos.
     */
    public void setSiinRecu(String siinRecu) {
        this.siinRecu = siinRecu;
    }

    /**
     *
     * @return noinRecu Una X si no interpone recursos
     */
    public String getNoinRecu() {
        return noinRecu;
    }

    /**
     *
     * @param noinRecu Para actualizar con una X si no hay recursos.Vacio si
     * existe.
     */
    public void setNoinRecu(String noinRecu) {
        this.noinRecu = noinRecu;
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
        //Constantes
        final String NOMBRE_HOJA = "RESULTADOS EVALUACION";
        // Fila y columna para 
        int fila = 0;
        int columna = 0;
        //Fila inicio evidencia
        int filaEvid;

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

                    fila = 5;

                    LOGGER.info("Se inicia con la escritura de las oportunidades de mejora");

                    for (OptuMejo optuMejo : this.listOpme) {

                        if (fila > 8) {

                            copyRow(workbook, sheet, fila - 2, fila - 1);
                            sheet.addMergedRegion(new CellRangeAddress(fila - 1, fila - 1, 1, 4));
                            sheet.addMergedRegion(new CellRangeAddress(fila - 1, fila - 1, 6, 7));

                        }

                        LOGGER.debug("Se va actualizar la linea {} celda 1. Valor  Capacitacion tecnica {}", fila, optuMejo.getCapaTecn());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(1);

                        cell.setCellValue(optuMejo.getCapaTecn());

                        LOGGER.debug("Se va actualizar la linea {} celda 6. Valor  compromisos del area {}", fila, optuMejo.getComporta());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(6);

                        cell.setCellValue(optuMejo.getComporta());

                        fila++;

                    }

                    //Ajustando los formulario
                    sheet.addMergedRegion(new CellRangeAddress(fila, fila, 1, 7));
                    sheet.addMergedRegion(new CellRangeAddress(fila + 1, fila + 1, 2, 6));

                    LOGGER.info("Fin de la escritura de las oportunidades de mejora");

                    LOGGER.info("Se inicia la escritura de las evidencias   ");

                    fila += 2;
                    filaEvid = fila + 5;

                    for (Evidenci evidenci : this.listEvid) {

                        if (filaEvid < fila) {
                            copyRow(workbook, sheet, fila - 1, fila);

                        }

                        LOGGER.debug("Se va actualizar la linea {} celda 1. Valor Fecha {}", fila, evidenci.getFecha());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(1);

                        cell.setCellValue(evidenci.getFecha());

                        LOGGER.debug("Se va actualizar la linea {} celda 6. Valor  compromisos del area {}", fila, evidenci.getDescripc());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(2);

                        cell.setCellValue(evidenci.getDescripc());

                        sheet.addMergedRegion(new CellRangeAddress(fila, fila, 2, 6));

                        fila++;

                    }

                    LOGGER.info("Fin de la escritura de las Evidencias");

                    LOGGER.info("Inicio de escritura de calificaciones");
                    //Ajustando los formulario - resultado
                    sheet.addMergedRegion(new CellRangeAddress(fila, fila, 1, 7));
                    sheet.addMergedRegion(new CellRangeAddress(fila + 1, fila + 1, 2, 5));
                    sheet.addMergedRegion(new CellRangeAddress(fila + 2, fila + 2, 2, 5));

                    LOGGER.debug("Se va actualizar la linea {} celda 2. Valor Excelente {}", fila + 2, this.excelent);
                    row = null;
                    cell = null;

                    row = sheet.getRow(fila + 2);
                    cell = row.getCell(2);

                    cell.setCellValue((this.excelent != null ? this.excelent : ""));

                    sheet.addMergedRegion(new CellRangeAddress(fila + 3, fila + 3, 2, 5));

                    LOGGER.debug("Se va actualizar la linea {} celda 2. Valor satisfactorio {}", fila + 3, this.satisfac);
                    row = null;
                    cell = null;

                    row = sheet.getRow(fila + 3);
                    cell = row.getCell(2);

                    cell.setCellValue((this.satisfac != null ? this.satisfac : ""));

                    sheet.addMergedRegion(new CellRangeAddress(fila + 4, fila + 4, 2, 5));

                    LOGGER.debug("Se va actualizar la linea {} celda 2. Valor satisfactorio {}", fila + 4, this.noSatisf);
                    row = null;
                    cell = null;

                    row = sheet.getRow(fila + 4);
                    cell = row.getCell(2);

                    cell.setCellValue((this.noSatisf != null ? this.noSatisf : ""));

                    //Ajustando Total  Calificacion en Numero
                    sheet.addMergedRegion(new CellRangeAddress(fila + 1, fila + 1, 6, 7));
                    sheet.addMergedRegion(new CellRangeAddress(fila + 2, fila + 4, 6, 7));

                    LOGGER.debug("Se va actualizar la linea {} celda 2. Valor total calificacion {}", fila + 2, this.numeToca);
                    row = null;
                    cell = null;

                    row = sheet.getRow(fila + 2);
                    cell = row.getCell(6);

                    cell.setCellValue(this.numeToca);
                    
                    LOGGER.info("Fin de escritura de calificaciones");
                    
                    LOGGER.info("Inicio de escritura de interposicion de recursos");

                    //Firma del evaluado ajuste
                    sheet.addMergedRegion(new CellRangeAddress(fila + 5, fila + 5, 1, 3));
                    sheet.addMergedRegion(new CellRangeAddress(fila + 5, fila + 5, 4, 6));

                    //Ajustando recursos
                    sheet.addMergedRegion(new CellRangeAddress(fila + 6, fila + 6, 1, 7));

                    LOGGER.debug("Se va actualizar la linea {} celda 5. Valor si interpone recursos {}", fila + 7, this.siinRecu);
                    row = null;
                    cell = null;

                    row = sheet.getRow(fila + 7);
                    cell = row.getCell(6);

                    cell.setCellValue("SI:" + (this.siinRecu != null ? this.siinRecu : ""));

                    LOGGER.debug("Se va actualizar la linea {} celda 5. Valor si interpone recursos {}", fila + 7, this.noinRecu);
                    row = null;
                    cell = null;

                    row = sheet.getRow(fila + 7);
                    cell = row.getCell(7);

                    cell.setCellValue("NO:" + (this.noinRecu != null ? this.noinRecu : ""));
                    
                     LOGGER.info("Fin de escritura de interposicion de recursos");

                    //Ajustando recursos
                    sheet.addMergedRegion(new CellRangeAddress(fila + 8, fila + 8, 1, 7));
                    sheet.addMergedRegion(new CellRangeAddress(fila + 10, fila + 10, 1, 7));

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

    private Row copyRow(Workbook workbook, Sheet worksheet, int sourceRowNum, int destinationRowNum) {
        // Get the source / new row
        Row newRow = worksheet.getRow(destinationRowNum);
        Row sourceRow = worksheet.getRow(sourceRowNum);

        // If the row exist in destination, push down all rows by 1 else create a new row
        if (newRow != null) {
            worksheet.shiftRows(destinationRowNum, worksheet.getLastRowNum(), 1);
        } else {
            newRow = worksheet.createRow(destinationRowNum);
        }

        // Loop through source columns to add to new row
        for (int i = 0; i < sourceRow.getLastCellNum(); i++) {
            // Grab a copy of the old/new cell
            Cell oldCell = sourceRow.getCell(i);
            Cell newCell = newRow.createCell(i);

            // If the old cell is null jump to next cell
            if (oldCell == null) {
                newCell = null;
                continue;
            }

            // Copy style from old cell and apply to new cell
            CellStyle newCellStyle = workbook.createCellStyle();
            newCellStyle.cloneStyleFrom(oldCell.getCellStyle());
            newCell.setCellStyle(newCellStyle);

            // Set the cell data type
            newCell.setCellType(oldCell.getCellType());

            // Set the cell data value
            switch (oldCell.getCellType()) {
                case HSSFCell.CELL_TYPE_BLANK:
                    newCell.setCellValue(oldCell.getStringCellValue());
                    break;
                case HSSFCell.CELL_TYPE_FORMULA:
                    newCell.setCellFormula(oldCell.getCellFormula());
                    //Si tenemos que modificar la formulario lo podemos hacer como string
                    //oldCell.getCellFormula().replace("A"+sourceRowNum, "A"+destinationRowNum)
                    break;
                case HSSFCell.CELL_TYPE_NUMERIC:
                    newCell.setCellValue(oldCell.getNumericCellValue());
                    break;
                case HSSFCell.CELL_TYPE_STRING:
                    newCell.setCellValue(oldCell.getRichStringCellValue());
                    break;
            }
        }
        return newRow;
    }

}
