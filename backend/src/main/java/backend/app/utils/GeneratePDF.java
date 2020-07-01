package backend.app.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import backend.app.model.Nastavnik;
import backend.app.model.Student;

public class GeneratePDF {
	private static final Logger logger = LoggerFactory.getLogger(GeneratePDF.class);

    public static ByteArrayInputStream students(List<Student> studenti) {

        Document document = new Document();
        document.setPageSize(PageSize.A3);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ArrayList<String> columns = new ArrayList<>(Arrays.asList("ID", "Ime", "Prezime", "Br Telefona", "Drzava", "Mesto", "ulica", "Broj Ulice", "Email", "Username"));

        try {

            PdfPTable table = new PdfPTable(10);
            table.setWidthPercentage(100);
          

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            for(String column: columns) {
            	hcell = new PdfPCell(new Phrase(column, headFont));
                hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);
            }

            for (Student student : studenti) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(student.getId().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(student.getLicniPodaci().getIme()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(student.getLicniPodaci().getPrezime()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(student.getLicniPodaci().getBrTelefona()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(student.getAdresa().getMesto().getDrzava().getNaziv()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(student.getAdresa().getMesto().getIme()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(student.getAdresa().getUlica()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(student.getAdresa().getBroj()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(student.getRegistrovaniKorisnik().getEmail()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(student.getRegistrovaniKorisnik().getUsername()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
    
    public static ByteArrayInputStream nastavnici(List<Nastavnik> nastavnici) {

        Document document = new Document();
        document.setPageSize(PageSize.A3);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ArrayList<String> columns = new ArrayList<>(Arrays.asList("ID", "Ime", "Prezime", "Br Telefona", "Drzava", "Mesto", "Ulica", "Broj Ulice", "Email", "Username", "Biografija"));

        try {

            PdfPTable table = new PdfPTable(11);
            table.setWidthPercentage(100);

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            for(String column: columns) {
            	hcell = new PdfPCell(new Phrase(column, headFont));
                hcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(hcell);
            }
          

            for (Nastavnik nastavnik : nastavnici) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(nastavnik.getId().toString()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(nastavnik.getLicniPodaci().getIme()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(nastavnik.getLicniPodaci().getPrezime()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(nastavnik.getLicniPodaci().getBrTelefona()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(nastavnik.getAdresa().getMesto().getDrzava().getNaziv()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(nastavnik.getAdresa().getMesto().getIme()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(nastavnik.getAdresa().getUlica()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(nastavnik.getAdresa().getBroj()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(nastavnik.getRegistrovaniKorisnik().getEmail()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(nastavnik.getRegistrovaniKorisnik().getUsername()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
                
                cell = new PdfPCell(new Phrase(nastavnik.getBiografija()));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);
            }

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);

            document.close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
