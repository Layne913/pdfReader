package pfdReader;

import java.awt.LayoutManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.pdfbox.pdfviewer.PDFPagePanel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.util.PDFTextStripper;

import com.ibm.icu.text.DateTimePatternGenerator.VariableField;

public class readTesting {

	public static void main(String args[]) throws FileNotFoundException,
			IOException {
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		File file = new File("./CoveringLetter.pdf");
		pdDoc = PDDocument.load(file);
		createFrame(pdDoc);
		// pdfStripper = new PDFTextStripper();
		// pdfStripper.setStartPage(1);
		// pdfStripper.setEndPage(5);
		// String parsedText = pdfStripper.getText(pdDoc);
		// System.out.println(parsedText);

	}

	public static void createFrame(PDDocument pdDoc) throws IOException {
		JFrame frame = new JFrame("PDF");
		JPanel pdfPanel = createPanelWithAllPages(pdDoc);
		frame.setVisible(true);
		frame.setSize(1300, 800);
		frame.add(pdfPanel);
	}

	public static JPanel createPanelWithAllPages(PDDocument pdfDoc)
			throws IOException {
		JPanel docPanel = new JPanel();
		docPanel.setLayout((LayoutManager) new BoxLayout(docPanel,
				BoxLayout.Y_AXIS));
		List<PDPage> docPages = pdfDoc.getDocumentCatalog().getAllPages();

		for (PDPage page : docPages) {
			PDFPagePanel pagePanel = new PDFPagePanel();
			pagePanel.setPage(page);

			docPanel.add(pagePanel);
		}

		return docPanel;
	}

}
