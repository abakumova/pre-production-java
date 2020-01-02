package com.viktoriia_abakumova.task9.parsers;

import com.viktoriia_abakumova.task9.containers.TicketsContainer;
import com.viktoriia_abakumova.task9.entity.Ticket;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class TicketParser {

    private static final Logger LOGGER = Logger.getLogger(TicketParser.class);
    private static final Gson GSON = new Gson();

    public TicketsContainer parseXMLFile(String filepath) {
        try {
            return (TicketsContainer) JAXBContext.newInstance(TicketsContainer.class).createUnmarshaller().unmarshal(new File(filepath));
        } catch (JAXBException e) {
            LOGGER.error(String.format("Can't parse XML file by path: %s", filepath), e);
        }
        return new TicketsContainer();
    }

    public void writeIntoJsonFile(List<Ticket> tickets, String filepath) {
        try (FileWriter writer = new FileWriter(new File(filepath))) {
            GSON.toJson(tickets, writer);
        } catch (IOException e) {
            LOGGER.error(String.format("Can't write tickets into JSON file by path: %s",
                    filepath), e);
        }
    }

    public List<Ticket> parseJsonFile(String filepath) {
        try (FileReader fileReader = new FileReader(new File(filepath))) {
            Type type = new TypeToken<List<Ticket>>() {
            }.getType();
            return GSON.fromJson(fileReader, type);
        } catch (IOException e) {
            LOGGER.error(String.format("Can't parse JSON file by path: %s", filepath), e);
        }
        return Collections.emptyList();
    }

    public void writeIntoExcelFile(List<Ticket> tickets, String filepath) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Tickets");

        createSheetHeader(sheet);

        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(filepath))) {
            int rowCounter = 1;
            for (Ticket ticket : tickets) {
                XSSFRow ticketRow = sheet.createRow(rowCounter++);
                fillTicketRow(ticket, ticketRow);
            }
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            LOGGER.error(String.format("Can't save tickets into XSL file by path: %s", filepath), e);
        }
    }

    private void createSheetHeader(XSSFSheet sheet) {
        XSSFRow headerRow = sheet.createRow(0);

        XSSFCell categoryHeaderCell = headerRow.createCell(0);
        categoryHeaderCell.setCellValue("Category");

        XSSFCell dateHeaderCell = headerRow.createCell(1);
        dateHeaderCell.setCellValue("Date");

        XSSFCell idHeaderCell = headerRow.createCell(2);
        idHeaderCell.setCellValue("Id");

        XSSFCell placeHeaderCell = headerRow.createCell(3);
        placeHeaderCell.setCellValue("Place");

        XSSFCell titleHeaderCell = headerRow.createCell(4);
        titleHeaderCell.setCellValue("Title");
    }

    private void fillTicketRow(Ticket ticket, XSSFRow ticketRow) {
        XSSFCell categoryCell = ticketRow.createCell(0);
        categoryCell.setCellValue(ticket.getCategory());

        XSSFCell dateCell = ticketRow.createCell(1);
        dateCell.setCellValue(ticket.getDate().toString());

        XSSFCell idCell = ticketRow.createCell(2);
        idCell.setCellValue(ticket.getId());

        XSSFCell placeCell = ticketRow.createCell(3);
        placeCell.setCellValue(ticket.getPlace());

        XSSFCell titleCell = ticketRow.createCell(4);
        titleCell.setCellValue(ticket.getTitle());
    }
}
