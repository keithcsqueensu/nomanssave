package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

class dq implements ActionListener {
   // $FF: synthetic field
   final MultitoolPanel GalacticAddress;
   // $FF: synthetic field
   private final Application bv;

   dq(MultitoolPanel var1, Application var2) {
      this.GalacticAddress = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      int var2 = MultitoolPanel.j(this.GalacticAddress).getSelectedIndex();
      if (var2 >= 0 && var2 < MultitoolPanel.AboutDialog(this.GalacticAddress).length) {
         if (MultitoolPanel.AboutDialog(this.GalacticAddress).length == 1) {
            this.bv.AccountPanel("You cannot delete the only multitool you have!");
         } else if (JOptionPane.showConfirmDialog(this.GalacticAddress, "Are you sure you want to delete this multitool?\nAll technology in the multitool will be lost!", "Delete", 2) == 0) {
            this.bv.h(MultitoolPanel.AboutDialog(this.GalacticAddress)[var2].getIndex());
         }
      }
   }
}
