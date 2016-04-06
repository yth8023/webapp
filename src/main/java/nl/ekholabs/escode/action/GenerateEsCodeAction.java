package nl.ekholabs.escode.action;

import nl.ekholabs.escode.web.EsCode;
import nl.ekholabs.escode.core.EsCodeGenerator;
import nl.ekholabs.escode.graphics.EsCodeColour;
import nl.ekholabs.escode.graphics.GeneratedCanvas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GenerateEsCodeAction {

  
  private final File selectedFile;

  public GenerateEsCodeAction(File selectedFile) {
    this.selectedFile = selectedFile;
  }

  public void generateFile() {
    final EsCodeGenerator esCodeGenerator = new EsCodeGenerator();

    List<EsCodeColour> colours;
    try {
      colours = esCodeGenerator.generateEsColours(selectedFile.getAbsolutePath());

      final BufferedImage generateImage = esCodeGenerator.createImage(colours);
      esCodeGenerator.drawGraphics(colours, generateImage.getGraphics());
      esCodeGenerator.persistImage(generateImage, selectedFile.getParent());

      
      
    } catch (final IOException e) {
      
    }
  }
}