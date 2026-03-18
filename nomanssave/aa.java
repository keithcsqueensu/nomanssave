package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aa implements ActionListener {
   // $FF: synthetic field
   final CompanionsPanel bV;
   // $FF: synthetic field
   private final Application bv;

   aa(CompanionsPanel var1, Application var2) {
      this.bV = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      Companion var2 = this.bv.j();
      if (var2 != null) {
         int var3 = -1;
         Companion[] var4 = new Companion[CompanionsPanel.AboutDialog(this.bV).length + 1];

         for(int var5 = 0; var5 < CompanionsPanel.AboutDialog(this.bV).length; ++var5) {
            if (CompanionsPanel.AboutDialog(this.bV)[var5].getIndex() < var2.getIndex()) {
               var4[var5] = CompanionsPanel.AboutDialog(this.bV)[var5];
            } else {
               var4[var5 + 1] = CompanionsPanel.AboutDialog(this.bV)[var5];
               if (var3 < 0) {
                  var3 = var5;
               }
            }
         }

         if (var3 < 0) {
            var3 = CompanionsPanel.AboutDialog(this.bV).length;
         }

         var4[var3] = var2;
         CompanionsPanel.AboutDialog(this.bV, var4);
         Logger.info("Imported " + var2.cL().name().toLowerCase() + ": " + var2.getIndex());
         CompanionsPanel.k(this.bV).setSelectedIndex(var3);
         CompanionsPanel.k(this.bV).updateUI();
      }

   }
}
