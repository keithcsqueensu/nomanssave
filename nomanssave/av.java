package nomanssave;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class av implements ActionListener {
   // $FF: synthetic field
   final DiscoveryPanel cu;

   av(DiscoveryPanel var1) {
      this.cu = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      String[] var2 = p.AccountPanel((Container)this.cu);
      boolean var3 = false;

      for(int var4 = 0; var4 < var2.length; ++var4) {
         ItemDefinition var5 = ItemDefinition.d(var2[var4]);
         if (!DiscoveryPanel.d(this.cu).contains(var2[var4])) {
            if (var5.be()) {
               DiscoveryPanel.e(this.cu).f(var2[var4]);
            }

            if (var5.FreighterPanel()) {
               DiscoveryPanel.f(this.cu).f(var2[var4]);
            }

            DiscoveryPanel.d(this.cu).add(var2[var4]);
            var3 = true;
         }
      }

      if (var3) {
         DiscoveryPanel.g(this.cu).sort();
         DiscoveryPanel.h(this.cu).updateUI();
      }

   }
}
