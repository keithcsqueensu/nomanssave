package nomanssave;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class SplitFormPanel extends JPanel {
   private final FormPanel it;

   SplitFormPanel() {
      GridBagLayout var1 = new GridBagLayout();
      var1.columnWidths = new int[]{AppSettings.cI, 0, 0};
      var1.rowHeights = new int[1];
      var1.columnWeights = new double[]{0.0D, 1.0D, Double.MIN_VALUE};
      var1.rowWeights = new double[]{1.0D};
      this.setLayout(var1);
      this.it = new FormPanel();
      GridBagConstraints var2 = new GridBagConstraints();
      var2.insets = new Insets(0, 0, 0, 0);
      var2.fill = 1;
      var2.gridx = 0;
      var2.gridy = 0;
      this.add(this.it, var2);
   }

   void setRightComponent(JComponent var1) {
      GridBagConstraints var2 = new GridBagConstraints();
      var2.fill = 1;
      var2.gridx = 1;
      var2.gridy = 0;
      this.add(var1, var2);
   }

   void k(String var1) {
      this.it.k(var1);
   }

   void addRow(String var1, ValidatedTextField var2) {
      this.it.addRow(var1, var2);
   }

   void addRow(String var1, JComponent var2) {
      this.it.addRow(var1, var2);
   }

   void addRow(String var1, boolean var2, JComponent var3) {
      this.it.addRow(var1, var2, var3);
   }

   void addRow(JComponent var1) {
      this.it.addRow(var1);
   }

   void Y() {
      this.it.Y();
   }
}
