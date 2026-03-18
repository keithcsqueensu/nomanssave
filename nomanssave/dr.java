package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dr implements ActionListener {
   // $FF: synthetic field
   final MultitoolPanel GalacticAddress;
   // $FF: synthetic field
   private final Application bv;

   dr(MultitoolPanel var1, Application var2) {
      this.GalacticAddress = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      int var2 = MultitoolPanel.j(this.GalacticAddress).getSelectedIndex();
      if (var2 >= 0 && var2 < MultitoolPanel.AboutDialog(this.GalacticAddress).length) {
         this.bv.AboutDialog(MultitoolPanel.AboutDialog(this.GalacticAddress)[var2]);
      }
   }
}
