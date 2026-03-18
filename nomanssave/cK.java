package nomanssave;

import javax.swing.JFileChooser;

public class cK extends JFileChooser {
   private static cK CompanionGenus = null;
   private static final String name = "JSON File";

   public static cK aA() {
      if (CompanionGenus == null) {
         CompanionGenus = new cK();
      }

      return CompanionGenus;
   }

   private cK() {
      this.setFileSelectionMode(0);
      this.setAcceptAllFileFilterUsed(false);
      this.setFileView(new cL(this));
      this.setFileFilter(new cM(this));
      this.setDialogTitle("Choose JSON File");
   }
}
