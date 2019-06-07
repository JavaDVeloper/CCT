/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barpiotr.printing.DailyRoster;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PiotrB. CCT - sb17018
 */
public class Printer extends HttpServlet {

    public void writeUsingIText(List<DayRoster> roster, HttpServletRequest request, HttpServletResponse response) throws DocumentException {

        Rectangle rect = new Rectangle(842, 595);

        response.setContentType("application/pdf");
        Document document = new Document(rect);

        try {

            PdfWriter.getInstance(document, response.getOutputStream());

            //open
            document.open();

            Font f = new Font();
            f.setStyle(Font.BOLD);

            String s = "";

            f.setSize(14);

            Paragraph mh = new Paragraph(s, f);
            mh.add("Scheduled on: " + roster.get(0).getServiceDate());
            mh.setAlignment(Element.ALIGN_CENTER);
            document.add(mh);

            Paragraph blank = new Paragraph(" ", f);
            document.add(blank);

            // Creating a table object 
            PdfPTable table = new PdfPTable(10);
            table.setWidthPercentage(100);
            float[] columnWidths = new float[]{5f, 8f, 8f, 10f, 20f, 8f, 20f, 10f, 15f, 10f};
            table.setTotalWidth(columnWidths);
            // for(int aw = 0; aw < 10; aw++){
            PdfPCell cell = new PdfPCell();
            Font head = new Font();
            head.setStyle(Font.BOLD);
            head.setSize(12);
            cell.setPadding(5);
            cell.setMinimumHeight(3f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            String[] headerCells = {"NO.", "START", "FINISH", "TYPE", "MECHANIC", "TYPE", "MODEL", "ENGINE", "REGISTRATION", "COLOUR"};

            for (int i = 0; i < headerCells.length; i++) {
                cell.setPhrase(new Phrase(headerCells[i], head));
                table.addCell(cell);
            }

            Font bd = new Font();
            bd.setStyle(Font.NORMAL);
            bd.setSize(10);

            for (int i = 0; i < roster.size(); i++) {

                cell.setPhrase(new Phrase(roster.get(i).getServiceId(), bd));
                table.addCell(cell);
                cell.setPhrase(new Phrase(roster.get(i).getServiceStart(), bd));
                table.addCell(cell);
                cell.setPhrase(new Phrase(roster.get(i).getServiceFinish(), bd));
                table.addCell(cell);
                cell.setPhrase(new Phrase(roster.get(i).getServiceType(), bd));
                table.addCell(cell);
                cell.setPhrase(new Phrase(roster.get(i).getMechanicFirstName() + " " + roster.get(i).getMechanicLastName(), bd));
                table.addCell(cell);
                cell.setPhrase(new Phrase(roster.get(i).getServiceVehType(), bd));
                table.addCell(cell);
                cell.setPhrase(new Phrase(roster.get(i).getServiceVehMake() + " " + roster.get(i).getServiceVehModel(), bd));
                table.addCell(cell);
                cell.setPhrase(new Phrase(roster.get(i).getServiceEngineType(), bd));
                table.addCell(cell);
                cell.setPhrase(new Phrase(roster.get(i).getServiceVehRegistration(), bd));
                table.addCell(cell);
                cell.setPhrase(new Phrase(roster.get(i).getServiceVehColor(), bd));
                table.addCell(cell);
            }

            document.add(table);
            //close
            document.close();

            System.out.println("Done");

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
