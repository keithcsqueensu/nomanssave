package nomanssave;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class as implements ActionListener {
   // $FF: synthetic field
   final DiscoveryPanel cu;

   as(DiscoveryPanel var1) {
      this.cu = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      String[] var2 = p.AboutDialogCloseListener((Container)this.cu);
      boolean var3 = false;

      for(int var4 = 0; var4 < var2.length; ++var4) {
         if (!DiscoveryPanel.AboutDialog(this.cu).hasValue(var2[var4])) {
            DiscoveryPanel.AboutDialog(this.cu).f(var2[var4]);
            var3 = true;
         }
      }

      if (var3) {
         DiscoveryPanel.AboutDialogCloseListener(this.cu).sort();
         DiscoveryPanel.AccountPanel(this.cu).updateUI();
      }

   }
}
