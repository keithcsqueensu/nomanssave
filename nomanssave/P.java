package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class P implements ActionListener {
   // $FF: synthetic field
   final BasesStoragePanel bt;
   // $FF: synthetic field
   private final Application bv;

   P(BasesStoragePanel var1, Application var2) {
      this.bt = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      Base var2 = (Base)BasesStoragePanel.j(this.bt).getSelectedItem();
      if (var2 != null) {
         List var3 = var2.cI();
         if (var3.size() == 0) {
            this.bv.AccountPanel("Cannot move base computer.\nPlease ensure that your base has a suitable Signal Booster / Blueprint Analyser / Beacon placed where you want your base computer to be.");
         } else {
            int var4;
            if ((var4 = cY.AboutDialog(this.bv.g(), var3)) >= 0) {
               gg var5 = (gg)var3.get(var4);
               Logger.info("Attempting to swap base computer with " + var5.toString() + "...");
               if (var2.AboutDialog(var5)) {
                  Logger.info("Base computer relocated: " + var2.getName());
               } else {
                  Logger.info("Base computer not moved.");
                  this.bv.AccountPanel("An error occurred while attempting to move base computer.");
               }

            }
         }
      }
   }
}
