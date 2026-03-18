package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ds implements ActionListener {
   // $FF: synthetic field
   final MultitoolPanel GalacticAddress;
   // $FF: synthetic field
   private final Application bv;

   ds(MultitoolPanel var1, Application var2) {
      this.GalacticAddress = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      Multitool var2 = this.bv.i();
      if (var2 != null) {
         Multitool[] var3 = new Multitool[MultitoolPanel.AboutDialog(this.GalacticAddress).length + 1];
         int var4 = -1;

         for(int var5 = 0; var5 < MultitoolPanel.AboutDialog(this.GalacticAddress).length; ++var5) {
            if (MultitoolPanel.AboutDialog(this.GalacticAddress)[var5].getIndex() < var2.getIndex()) {
               var3[var5] = MultitoolPanel.AboutDialog(this.GalacticAddress)[var5];
            } else {
               var3[var5 + 1] = MultitoolPanel.AboutDialog(this.GalacticAddress)[var5];
               if (var4 < 0) {
                  var4 = var5;
               }
            }
         }

         if (var4 < 0) {
            var4 = MultitoolPanel.AboutDialog(this.GalacticAddress).length;
         }

         var3[var4] = var2;
         MultitoolPanel.AboutDialog(this.GalacticAddress, var3);
         MultitoolPanel.j(this.GalacticAddress).setSelectedIndex(var4);
         MultitoolPanel.j(this.GalacticAddress).updateUI();
      }

   }
}
