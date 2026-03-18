package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aw implements ActionListener {
   // $FF: synthetic field
   final DiscoveryPanel cu;

   aw(DiscoveryPanel var1) {
      this.cu = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      int[] var2 = DiscoveryPanel.h(this.cu).getSelectedRows();
      boolean var3 = false;

      for(int var4 = var2.length - 1; var4 >= 0; --var4) {
         int var5 = DiscoveryPanel.h(this.cu).convertRowIndexToModel(var2[var4]);
         String var6 = (String)DiscoveryPanel.d(this.cu).get(var5);
         DiscoveryPanel.d(this.cu).remove(var5);

         while((var5 = DiscoveryPanel.e(this.cu).indexOf(var6)) >= 0) {
            DiscoveryPanel.e(this.cu).ac(var5);
         }

         while((var5 = DiscoveryPanel.f(this.cu).indexOf(var6)) >= 0) {
            DiscoveryPanel.f(this.cu).ac(var5);
         }

         var3 = true;
      }

      if (var3) {
         DiscoveryPanel.h(this.cu).clearSelection();
         DiscoveryPanel.g(this.cu).sort();
         DiscoveryPanel.h(this.cu).updateUI();
      }

   }
}
