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
import net.illustrato.mdl.emsc.Empleado;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Esta clase permite poblar los datos de los empleados sin calificar y generar
 * un reporte HU14.
 *
 * @author adalbertdavidaroca
 */
public class CtrlEmsc implements ReporteExcel, Serializable {

    private static final Logger LOGGER = LogManager.getLogger(CtrlEmsc.class);

    /**
     * listado de empleados sin calificar
     */
    private List<Empleado> listEmpl;

    /**
     * @return the listEmpl
     */
    public List<Empleado> getListEmpl() {
        return listEmpl;
    }

    /**
     * @param listEmpl the listEmpl to set
     */
    public void setListEmpl(List<Empleado> listEmpl) {
        this.listEmpl = listEmpl;
    }

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
        final String NOMBRE_HOJA = "EVALUADOR";
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
                    sheet = workbook.getSheetAt(0);

                    fila = 2;

                    LOGGER.info("Se inicia con la escritura de empleados");

                    for (Empleado empleado : this.getListEmpl()) {

                        if (fila > 5) {

                            copyRow(workbook, sheet, fila - 1, fila);

                        }

                        LOGGER.debug("Se va actualizar la linea {} celda 0. Valor  periodo {}", fila, empleado.getPeriodo());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(0);


                        cell.setCellValue(empleado.getPeriodo());

                        LOGGER.debug("Se va actualizar la linea {} celda 1. Valor numero registro laboral evaluado {}", fila, empleado.getNumeRlev());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(1);

                        cell.setCellValue(empleado.getNumeRlev());

                        LOGGER.debug("Se va actualizar la linea {} celda 2. Valor nombre completo evaluado {}", fila, empleado.getNombCoev());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(2);

                        cell.setCellValue(empleado.getNombCoev());

                        LOGGER.debug("Se va actualizar la linea {} celda 3. Valor nombre completo evaluador {}", fila, empleado.getNombCoer());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(3);

                        cell.setCellValue(empleado.getNombCoer());

                        LOGGER.debug("Se va actualizar la linea {} celda 4. Valor cargo evaluado {}", fila, empleado.getCargEval());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(4);

                        cell.setCellValue(empleado.getCargEval());

                        LOGGER.debug("Se va actualizar la linea {} celda 5. Valor cargo evaluador {}", fila, empleado.getCargEvar());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(5);

                        cell.setCellValue(empleado.getCargEvar());

                        LOGGER.debug("Se va actualizar la linea {} celda 6. Valor Nivel jerarquico evaluado {}", fila, empleado.getNijeCaev());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(6);

                        cell.setCellValue(empleado.getNijeCaev());

                        LOGGER.debug("Se va actualizar la linea {} celda 7. Valor Gerencia evaluado {}", fila, empleado.getGereEval());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(7);

                        cell.setCellValue(empleado.getGereEval());

                        LOGGER.debug("Se va actualizar la linea {} celda 8. Valor Gerencia evaluador {}", fila, empleado.getGereEvdr());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(8);

                        cell.setCellValue(empleado.getGereEvdr());

                        LOGGER.debug("Se va actualizar la linea {} celda 9. Valor direccion evaluado {}", fila, empleado.getDireEval());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(9);

                        cell.setCellValue(empleado.getDireEval());

                        LOGGER.debug("Se va actualizar la linea {} celda 10. Valor direccion evaluador {}", fila, empleado.getDireEvdr());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(10);

                        cell.setCellValue(empleado.getDireEvdr());

                        LOGGER.debug("Se va actualizar la linea {} celda 11. Valor departamento evaluado {}", fila, empleado.getDepaEval());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(11);

                        cell.setCellValue(empleado.getDepaEval());

                        LOGGER.debug("Se va actualizar la linea {} celda 12. Valor departamento evaluador {}", fila, empleado.getDepaEvdr());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(12);

                        cell.setCellValue(empleado.getDepaEvdr());

                        LOGGER.debug("Se va actualizar la linea {} celda 13. Valor Novedad {}", fila, empleado.getNovedad());
                        row = null;
                        cell = null;

                        row = sheet.getRow(fila);
                        cell = row.getCell(13);

                        cell.setCellValue(empleado.getNovedad());

                        fila++;

                    }

                    LOGGER.info("Fin de la escritura de las oportunidades de mejora");

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
