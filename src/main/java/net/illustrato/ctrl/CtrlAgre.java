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
import net.illustrato.mdl.core.Evidenci;
import net.illustrato.mdl.core.OptuMejo;
import net.illustrato.mdl.reto.CompAsis;
import net.illustrato.mdl.reto.CompComu;
import net.illustrato.mdl.reto.CompExce;
import net.illustrato.mdl.reto.CompProf;
import net.illustrato.mdl.reto.CompTecn;
import net.illustrato.mdl.reto.CondAsoc;
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
 * Con esta clase se genera un reporte total, compuesto por varios reportes los
 * cuales se distribuyen uno por cada hoja
 *
 * @author adalbertdavidaroca
 */
public class CtrlAgre implements ReporteExcel, Serializable {

    private static final Logger LOGGER = LogManager.getLogger(CtrlAgre.class);

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
     * Compromisos con la excelencia
     */
    private CompExce compExce;

    /**
     * listado de componentes comporamentales comunes
     */
    private List<CompComu> listComus;
    
    
     /**
     * listado de componentes comporamentales Asistenciales
     */
    private List<CompAsis> listAsis;
    
    
    
     /**
     * listado de componentes comporamentales Tecnicos
     */
    private List<CompTecn> listTecn;
    
    
    
     /**
     * listado de componentes comporamentales profesionales
     */
    private List<CompProf> listPro;
    
    
    /**
     * Tipo Competencia comportamental
     */
    
    private String tipoCoco;

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
     * @return compExce compromiso de excelencia
     */
    public CompExce getCompExce() {
        return compExce;
    }

    /**
     *
     * @param compExce actualizar compromisos excelencia
     */
    public void setCompExce(CompExce compExce) {
        this.compExce = compExce;
    }

    /**
     *
     * @return listComus listado de componentes comportamentales comunes
     *
     */
    public List<CompComu> getListComus() {
        return listComus;
    }

    /**
     *
     * @param listComus actulizar componentes comportamentales comunes
     */
    public void setListComus(List<CompComu> listComus) {
        this.listComus = listComus;
    }
    
    /**
     * 
     * @return listAsis lista de compotencias comportamentales asistenciales
     */

    public List<CompAsis> getListAsis() {
        return listAsis;
    }

    /**
     * 
     * @param listAsis para actualizar la lista de compotencias comportamentales 
     * asistenciales
     */
    public void setListAsis(List<CompAsis> listAsis) {
        this.listAsis = listAsis;
    }

    
    /**
     * 
     * @return listTecn lista de competencias comportamentales tecnicas
     */
    public List<CompTecn> getListTecn() {
        return listTecn;
    }
    
    /**
     * 
     * @param listTecn para actualizar lista de competencias comportamentales
     * tecnicas
     */

    public void setListTecn(List<CompTecn> listTecn) {
        this.listTecn = listTecn;
    }

    
    /**
     * 
     * @return listPro lista de competencias comportamentales profesionales
     */
    public List<CompProf> getListPro() {
        return listPro;
    }

    /**
     * 
     * @param listPro actualizar el listado de compotencias comportamentales
     * profesionales
     */
    public void setListPro(List<CompProf> listPro) {
        this.listPro = listPro;
    }

    /**
     * 
     * @return tipoCoco tipo de competencia comportamental del evaluado
     */
    public String getTipoCoco() {
        return tipoCoco;
    }

    /**
     * 
     * @param tipoCoco actualizar el tipo de competencia comportamental del 
     * evaluado 
     */
    public void setTipoCoco(String tipoCoco) {
        this.tipoCoco = tipoCoco;
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

    private Sheet hojaConsCola(Sheet sheet) throws Exception {

        //Registra del archivo de excel
        Row row = null;
        //Celda en el archivo de excel
        Cell cell;
        //Es evaluacion definitiva
        boolean isevDefi = false;
        //Es evaluacion parcial
        boolean isevParc = false;

        // Fila y columna para 
        int fila = 0;
        int columna = 0;

        try {
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

            LOGGER.debug("Se va actualizar la linea 27 celda 18. Valor  puntos totales logrados {}", this.totaPulo);
            row = null;
            cell = null;

            row = sheet.getRow(27);
            cell = row.getCell(17);

            cell.setCellValue(this.totaPulo);

        } catch (Exception e) {

            throw new Exception("Se genero un error Compromisos Laborales [" + e.getMessage() + "]");

        }

        return sheet;

    }

    private void hojaConsResu(Workbook workbook, Sheet sheet) throws Exception {

        // Fila de archivo de excel
        Row row = null;
        //Celda en el archivo de excel
        Cell cell;

        // Fila y columna para 
        int fila = 0;
        int columna = 0;
        //Fila inicio evidencia
        int filaEvid;

        try {

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

        } catch (Exception e) {

            throw new Exception("Se presento un error hojaConsResu [" + e.getMessage() + "]");

        }

    }

    private void hojaCompExin(Workbook workbook, Sheet sheet) throws Exception {

        // Fila de archivo de excel
        Row row = null;
        //Celda en el archivo de excel
        Cell cell;

        // Fila y columna para 
        int fila = 5;
        int columna = 0;

        try {
            LOGGER.info("Se inicia la escritura de compromisos de excelencia");
            LOGGER.debug("Se va actualizar la linea {} celda 8. Valor Nombre completo {}", fila, compExce.getNombProy());
            row = null;
            cell = null;

            row = sheet.getRow(fila);
            cell = row.getCell(8);
            cell.setCellValue(compExce.getNombProy());

            fila++;
            LOGGER.debug("Se va actualizar la linea {} celda 8. Valor objetivo estrategico {}", fila, compExce.getObjeEstr());
            row = null;
            cell = null;

            row = sheet.getRow(fila);
            cell = row.getCell(8);
            cell.setCellValue(compExce.getObjeEstr());

            fila++;
            LOGGER.debug("Se va actualizar la linea {} celda 8. Valor planteamiento  problema {}", fila, compExce.getPlanProb());
            row = null;
            cell = null;

            row = sheet.getRow(fila);
            cell = row.getCell(8);
            cell.setCellValue(compExce.getPlanProb());

            fila++;
            LOGGER.debug("Se va actualizar la linea {} celda 8. Valor descripcion {}", fila, compExce.getDescripc());
            row = null;
            cell = null;

            row = sheet.getRow(fila);
            cell = row.getCell(8);
            cell.setCellValue(compExce.getDescripc());

            fila++;
            LOGGER.debug("Se va actualizar la linea {} celda 8. Valor  fundamentos y justificacion  {}", fila, compExce.getFundJust());
            row = null;
            cell = null;

            row = sheet.getRow(fila);
            cell = row.getCell(8);
            cell.setCellValue(compExce.getFundJust());

            fila++;
            LOGGER.debug("Se va actualizar la linea {} celda 8. Valor  Objetivo  {}", fila, compExce.getObjetivo());
            row = null;
            cell = null;

            row = sheet.getRow(fila);
            cell = row.getCell(8);
            cell.setCellValue(compExce.getObjetivo());

            fila++;
            LOGGER.debug("Se va actualizar la linea {} celda 8. Valor  Objetivod  {}", fila, compExce.getUbicacio());
            row = null;
            cell = null;

            row = sheet.getRow(fila);
            cell = row.getCell(8);
            cell.setCellValue(compExce.getUbicacio());

            fila++;
            LOGGER.debug("Se va actualizar la linea {} celda 8. Valor  beneficiarios  {}", fila, compExce.getBenefiac());
            row = null;
            cell = null;

            row = sheet.getRow(fila);
            cell = row.getCell(8);
            cell.setCellValue(compExce.getBenefiac());

            fila++;
            LOGGER.debug("Se va actualizar la linea {} celda 8. Valor  beneficiarios  {}", fila, compExce.getMetodolo());
            row = null;
            cell = null;

            row = sheet.getRow(fila);
            cell = row.getCell(8);
            cell.setCellValue(compExce.getMetodolo());

            fila++;
            LOGGER.debug("Se va actualizar la linea {} celda 8. Valor  Cronograma  {}", fila, compExce.getCronogra());
            row = null;
            cell = null;

            row = sheet.getRow(fila);
            cell = row.getCell(8);
            cell.setCellValue(compExce.getCronogra());

            fila++;
            LOGGER.debug("Se va actualizar la linea {} celda 8. Valor  Metas  {}", fila, compExce.getMetaIndi());
            row = null;
            cell = null;

            row = sheet.getRow(fila);
            cell = row.getCell(8);
            cell.setCellValue(compExce.getMetaIndi());

            fila++;
            LOGGER.debug("Se va actualizar la linea {} celda 8. Valor  Presupuesto  {}", fila, compExce.getPresupue());
            row = null;
            cell = null;

            row = sheet.getRow(fila);
            cell = row.getCell(8);
            cell.setCellValue(compExce.getPresupue());

            LOGGER.debug("Se va actualizar la linea 18 celda 15. Valor  calificacion excelencia  {}", compExce.getCaliExce());
            row = null;
            cell = null;

            row = sheet.getRow(18);
            cell = row.getCell(15);
            cell.setCellValue(compExce.getCaliExce());

            LOGGER.debug("Se va actualizar la linea 2 celda 1. Valor  Nombre evaluado {}", evaluado.getNombComp());
            row = null;
            cell = null;

            row = sheet.getRow(2);
            cell = row.getCell(1);
            cell.setCellValue("NOMBRE DEL TRABAJADOR OFICIAL EVALUADO: " + evaluado.getNombComp());

            LOGGER.debug("Se va actualizar la linea 2 celda 1. Valor  Cargo evaluado {}", evaluado.getCargo());
            row = null;
            cell = null;

            row = sheet.getRow(2);
            cell = row.getCell(10);
            cell.setCellValue("CARGO: " + evaluado.getCargo());

            LOGGER.debug("Se va actualizar la linea 2 celda 15. Valor  registro laboral {}", evaluado.getRegiLabo());
            row = null;
            cell = null;

            row = sheet.getRow(2);
            cell = row.getCell(15);
            cell.setCellValue("CARGO: " + evaluadr.getRegiLabo());

            LOGGER.debug("Se va actualizar la linea 3 celda 1. Valor  Nombre evaluador {}", evaluadr.getNombComp());
            row = null;
            cell = null;

            row = sheet.getRow(3);
            cell = row.getCell(1);
            cell.setCellValue("NOMBRE DEL EMPLEADO PUBLICO EVALUADOR: " + evaluadr.getNombComp());

            LOGGER.debug("Se va actualizar la linea 3 celda 10. Valor  Cargo evaluador {}", evaluadr.getCargo());
            row = null;
            cell = null;

            row = sheet.getRow(3);
            cell = row.getCell(10);
            cell.setCellValue("CARGO: " + evaluadr.getCargo());

        } catch (Exception e) {

            throw new Exception("Se genera error en la hoja compromisos Excelencia [" + e.getMessage() + "]");

        }

    }

    private void hojaCompCoco(Workbook workbook, Sheet sheet) throws Exception {

        // Fila de archivo de excel
        Row row = null;
        //Celda en el archivo de excel
        Cell cell;

        // Fila y columna para 
        int fila = 6;
        int fila2 = 6;
        int columna = 0;

        try {
            LOGGER.info("Se inicia la escritura de componentes comportamentales comunes");

            for (CompComu compComu : listComus) {
                LOGGER.debug("Se va actualizar la linea {} celda 8. Valor Nombre completo {}", fila, compComu.getEncaCocc());
                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(1);
                cell.setCellValue(compComu.getEncaCocc() + " " + compComu.getDescCocc());

                for (CondAsoc condAsoc : compComu.getListCoas()) {
                    row = null;
                    cell = null;

                    row = sheet.getRow(fila2);
                    cell = row.getCell(2);
                    cell.setCellValue(condAsoc.getDescrpci());

                    row = null;
                    cell = null;

                    row = sheet.getRow(fila2);
                    cell = row.getCell(3);
                    cell.setCellValue(condAsoc.getPuntaje());

                    fila2++;
                }

                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(4);
                cell.setCellValue(compComu.getCompCrit());

                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(5);
                cell.setCellValue(compComu.getCompAcep());

                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(6);
                cell.setCellValue(compComu.getCompDese());

                row = null;
                cell = null;

                row = sheet.getRow(fila2);
                cell = row.getCell(3);
                cell.setCellValue(compComu.getPromPunt());

                fila2 += 2;
                fila = fila2;

            }

        } catch (Exception e) {

            throw new Exception("Se genera error en la hoja componentes comportamentales comunes [" + e.getMessage() + "]");

        }

    }
    
    private void hojaCompCoas(Workbook workbook, Sheet sheet) throws Exception {

        // Fila de archivo de excel
        Row row = null;
        //Celda en el archivo de excel
        Cell cell;

        // Fila y columna para 
        int fila = 6;
        int fila2 = 6;
        int columna = 0;

        try {
            LOGGER.info("Se inicia la escritura de componentes asistenciales comunes");

            for (CompAsis compAsis : listAsis) {
                LOGGER.debug("Se va actualizar la linea {} celda 8. Valor Nombre completo {}", fila, compAsis.getEncaCocc());
                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(1);
                cell.setCellValue(compAsis.getEncaCocc() + " " + compAsis.getDescCocc());

                for (CondAsoc condAsoc : compAsis.getListCoas()) {
                    row = null;
                    cell = null;

                    row = sheet.getRow(fila2);
                    cell = row.getCell(2);
                    cell.setCellValue(condAsoc.getDescrpci());

                    row = null;
                    cell = null;

                    row = sheet.getRow(fila2);
                    cell = row.getCell(3);
                    cell.setCellValue(condAsoc.getPuntaje());

                    fila2++;
                }

                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(4);
                cell.setCellValue(compAsis.getCompCrit());

                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(5);
                cell.setCellValue(compAsis.getCompAcep());

                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(6);
                cell.setCellValue(compAsis.getCompDese());

                row = null;
                cell = null;

                row = sheet.getRow(fila2);
                cell = row.getCell(3);
                cell.setCellValue(compAsis.getPromPunt());

                fila2 += 2;
                fila = fila2;

            }

        } catch (Exception e) {

            throw new Exception("Se genera error en la hoja componentes comportamentales Asistenciales [" + e.getMessage() + "]");

        }

    }
    
    
    private void hojaCompCote(Workbook workbook, Sheet sheet) throws Exception {

        // Fila de archivo de excel
        Row row = null;
        //Celda en el archivo de excel
        Cell cell;

        // Fila y columna para 
        int fila = 6;
        int fila2 = 6;
        int columna = 0;

        try {
            LOGGER.info("Se inicia la escritura de componentes comportamentales Tecnicos");

            for (CompTecn compTecn : listTecn) {
                LOGGER.debug("Se va actualizar la linea {} celda 8. Valor Nombre completo {}", fila, compTecn.getEncaCocc());
                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(1);
                cell.setCellValue(compTecn.getEncaCocc() + " " + compTecn.getDescCocc());

                for (CondAsoc condAsoc : compTecn.getListCoas()) {
                    row = null;
                    cell = null;

                    row = sheet.getRow(fila2);
                    cell = row.getCell(2);
                    cell.setCellValue(condAsoc.getDescrpci());

                    row = null;
                    cell = null;

                    row = sheet.getRow(fila2);
                    cell = row.getCell(3);
                    cell.setCellValue(condAsoc.getPuntaje());

                    fila2++;
                }

                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(4);
                cell.setCellValue(compTecn.getCompCrit());

                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(5);
                cell.setCellValue(compTecn.getCompAcep());

                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(6);
                cell.setCellValue(compTecn.getCompDese());

                row = null;
                cell = null;

                row = sheet.getRow(fila2);
                cell = row.getCell(3);
                cell.setCellValue(compTecn.getPromPunt());

                fila2 += 2;
                fila = fila2;

            }

        } catch (Exception e) {

            throw new Exception("Se genera error en la hoja componentes comportamentales Tecnicos [" + e.getMessage() + "]");

        }

    }
    
    
    private void hojaCompCopr(Workbook workbook, Sheet sheet) throws Exception {

        // Fila de archivo de excel
        Row row = null;
        //Celda en el archivo de excel
        Cell cell;

        // Fila y columna para 
        int fila = 6;
        int fila2 = 6;
        int columna = 0;

        try {
            LOGGER.info("Se inicia la escritura de componentes comportamentales Profesionales");

            for (CompProf compProf : listPro) {
                LOGGER.debug("Se va actualizar la linea {} celda 8. Valor Nombre completo {}", fila, compProf.getEncaCocc());
                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(1);
                cell.setCellValue(compProf.getEncaCocc() + " " + compProf.getDescCocc());

                for (CondAsoc condAsoc : compProf.getListCoas()) {
                    row = null;
                    cell = null;

                    row = sheet.getRow(fila2);
                    cell = row.getCell(2);
                    cell.setCellValue(condAsoc.getDescrpci());

                    row = null;
                    cell = null;

                    row = sheet.getRow(fila2);
                    cell = row.getCell(3);
                    cell.setCellValue(condAsoc.getPuntaje());

                    fila2++;
                }

                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(4);
                cell.setCellValue(compProf.getCompCrit());

                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(5);
                cell.setCellValue(compProf.getCompAcep());

                row = null;
                cell = null;

                row = sheet.getRow(fila);
                cell = row.getCell(6);
                cell.setCellValue(compProf.getCompDese());

                row = null;
                cell = null;

                row = sheet.getRow(fila2);
                cell = row.getCell(3);
                cell.setCellValue(compProf.getPromPunt());

                fila2 += 2;
                fila = fila2;

            }

        } catch (Exception e) {

            throw new Exception("Se genera error en la hoja componentes comportamentales Tecnicos [" + e.getMessage() + "]");

        }

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

        //Hoja de excel
        Sheet sheet = null;
        //Numero de hojas en el libro de excel
        int numberOfSheets;
        
        //hoja seleccionada
        int numHoja=0;
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

                    LOGGER.info("Hoja seleccionada Compromisos laborales:{}", 0);
                    sheet = workbook.getSheetAt(numHoja);

                    hojaConsCola(sheet);

                    numHoja++;
                    LOGGER.info("Hoja seleccionada Componentes comportamentales comunes :{}", 1);
                    sheet = workbook.getSheetAt(numHoja);

                    hojaCompCoco(workbook, sheet);
                    
                    switch (this.tipoCoco) {
                        case "A":
                            
                            numHoja+=1;
                            sheet = workbook.getSheetAt(numHoja);
                            
                            hojaCompCoas(workbook, sheet);
                            workbook.removeSheetAt(numHoja+1);
                            workbook.removeSheetAt(numHoja+1);
                            break;
                        case "T":
                            numHoja+=2;
                            sheet = workbook.getSheetAt(numHoja);
                            hojaCompCote(workbook, sheet);
                            numHoja-=2;
                            break;
                        case "P":
                            numHoja+=3;
                            sheet = workbook.getSheetAt(numHoja);
                            hojaCompCopr(workbook, sheet);
                            numHoja-=2;
                            break;
                        default:
                            break;
                    }

                    numHoja++;
                    LOGGER.info("Hoja seleccionada Compromisos de excelencia e innovacion:{}", numHoja);
                    sheet = workbook.getSheetAt(numHoja);

                    hojaCompExin(workbook, sheet);

                    numHoja++;
                    LOGGER.info("Hoja seleccionada Resultados Evaluacion:{}", numHoja);
                    sheet = workbook.getSheetAt(numHoja);

                    hojaConsResu(workbook, sheet);

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
