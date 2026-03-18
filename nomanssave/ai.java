package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class ai implements ActionListener {
   // $FF: synthetic field
   final CompanionsPanel bV;
   // $FF: synthetic field
   private final Application bv;

   ai(CompanionsPanel var1, Application var2) {
      this.bV = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      int var2 = CompanionsPanel.k(this.bV).getSelectedIndex();
      if (var2 >= 0 && var2 < CompanionsPanel.AboutDialog(this.bV).length) {
         if (JOptionPane.showConfirmDialog(this.bV, "Are you sure you want to delete this companion?", "Delete", 2) == 0) {
            this.bv.AboutDialog(CompanionsPanel.AboutDialog(this.bV)[var2].cL(), CompanionsPanel.AboutDialog(this.bV)[var2].getIndex());
         }
      }
   }
}
