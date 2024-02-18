package com.excel_upload.Excel_Api.helper;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.excel_upload.Excel_Api.model.Tutorial;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfGenerator {
    public void generate(List <Tutorial> studentList, HttpServletResponse response) throws DocumentException, IOException {
        // Creating the Object of Document
        Document document = new Document(PageSize.A4);
        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response.getOutputStream());
        // Opening the created document to change it
        document.open();
        // Creating font
        // Setting font style and size
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);
        // Creating paragraph
        Paragraph paragraph1 = new Paragraph("List of the Students", fontTiltle);
        // Aligning the paragraph in the document
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
        // Adding the created paragraph in the document
        document.add(paragraph1);
        // Creating a table of the 4 columns
        PdfPTable table = new PdfPTable(4);
        table.getDefaultCell().setBorderColor(Color.BLUE);
        // Setting width of the table, its columns and spacing
        table.setWidthPercentage(100);
        table.setWidths(new int[] {1,5,3,3});
        table.setSpacingBefore(5);

        // Create Table Cells for the table header
        PdfPCell cell = new PdfPCell();
        // Setting the background color and padding of the table cell
        cell.setBackgroundColor(CMYKColor.BLUE);
        cell.setPadding(5);

        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);
        // Adding headings in the created table cell or  header
        // Adding Cell to table
        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Student Name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Mobile No", font));
        table.addCell(cell);


        // Iterating the list of students
        for (Tutorial student: studentList) {
            // Adding student id

            table.addCell(String.valueOf(student.getId()));
            // Adding student name
            table.addCell(student.getTitle());
            // Adding student email
            table.addCell(student.getDescription());
            // Adding student mobile
            table.addCell(student.getPublished());

        }

//        document.add(img);



        table.addCell("");
        table.addCell("");
//        table.addCell("");
//        cell.setRowspan(3);


        Image img  = Image.getInstance("C:\\Users\\sahbr\\Desktop\\Photo&Sign\\PHOTO (2).jpg");
        img.scaleAbsolute(80,100);

        cell.setPadding(2f);
        cell.setColspan(2);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

        table.addCell(img);
//        cell.setColspan(3);



        // Adding the created table to the document
        document.add(table);



        // Closing the document
        document.close();
    }
}