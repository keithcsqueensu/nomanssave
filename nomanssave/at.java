package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class at implements ActionListener {
   // $FF: synthetic field
   final DiscoveryPanel cu;

   at(DiscoveryPanel var1) {
      this.cu = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      int[] var2 = DiscoveryPanel.AccountPanel(this.cu).getSelectedRows();
      boolean var3 = false;

      for(int var4 = var2.length - 1; var4 >= 0; --var4) {
         DiscoveryPanel.AboutDialog(this.cu).ac(DiscoveryPanel.AccountPanel(this.cu).convertRowIndexToModel(var2[var4]));
         var3 = true;
      }

      if (var3) {
         DiscoveryPanel.AccountPanel(this.cu).clearSelection();
         DiscoveryPanel.AboutDialogCloseListener(this.cu).sort();
         DiscoveryPanel.AccountPanel(this.cu).updateUI();
      }

   }
}
