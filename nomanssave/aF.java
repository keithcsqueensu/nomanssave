package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Stream;

class aF implements ActionListener {
   // $FF: synthetic field
   final aD cB;

   aF(aD var1) {
      this.cB = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = AppSettings.getProperty("LookAndFeel");
      aI var3 = (aI)Stream.of(aI.values()).filter((var1x) -> {
         return var1x.name().equalsIgnoreCase(var2);
      }).findFirst().orElse(aI.cN);
      aI var4 = (aI)aD.AboutDialog(this.cB).getSelectedItem();
      aD.AboutDialog(this.cB, false);
      if (var4 == null) {
         if (var3 != null) {
            AppSettings.setProperty("LookAndFeel", (String)null);
            aD.AboutDialog(this.cB, true);
         }
      } else if (var3 == null || var3 != var4) {
         AppSettings.setProperty("LookAndFeel", var4.name());
         aD.AboutDialog(this.cB, true);
      }

      double var5 = Double.parseDouble(aD.AboutDialogCloseListener(this.cB).getText());
      if (var5 != AppSettings.AboutDialog("InventoryScaling", 1.0D)) {
         AppSettings.AboutDialogCloseListener("InventoryScaling", var5);
         aD.AboutDialog(this.cB, true);
      }

      this.cB.setVisible(false);
   }
}
