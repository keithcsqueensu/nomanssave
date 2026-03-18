package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dS implements ActionListener {
   // $FF: synthetic field
   final ShipsPanel ia;
   // $FF: synthetic field
   private final Application bv;

   dS(ShipsPanel var1, Application var2) {
      this.ia = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      Starship var2 = this.bv.h();
      if (var2 != null) {
         Starship[] var3 = new Starship[ShipsPanel.AboutDialog(this.ia).length + 1];
         int var4 = -1;

         for(int var5 = 0; var5 < ShipsPanel.AboutDialog(this.ia).length; ++var5) {
            if (ShipsPanel.AboutDialog(this.ia)[var5].getIndex() < var2.getIndex()) {
               var3[var5] = ShipsPanel.AboutDialog(this.ia)[var5];
            } else {
               var3[var5 + 1] = ShipsPanel.AboutDialog(this.ia)[var5];
               if (var4 < 0) {
                  var4 = var5;
               }
            }
         }

         if (var4 < 0) {
            var4 = ShipsPanel.AboutDialog(this.ia).length;
         }

         var3[var4] = var2;
         ShipsPanel.AboutDialog(this.ia, var3);
         Logger.info("Imported ship: " + var2.getIndex());
         ShipsPanel.p(this.ia).setSelectedIndex(var4);
         ShipsPanel.p(this.ia).updateUI();
      }

   }
}
