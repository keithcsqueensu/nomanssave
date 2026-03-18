package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

class ay implements ActionListener {
   // $FF: synthetic field
   final DiscoveryPanel cu;

   ay(DiscoveryPanel var1) {
      this.cu = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      Iterator var4 = AlienWord.by().iterator();

      while(var4.hasNext()) {
         AlienWord var3 = (AlienWord)var4.next();
         gA var2 = DiscoveryPanel.i(this.cu).AboutDialog(var3);
         if (var3.AboutDialog(Race.kr)) {
            var2.AboutDialog(Race.kr, true);
         }

         if (var3.AboutDialog(Race.ks)) {
            var2.AboutDialog(Race.ks, true);
         }

         if (var3.AboutDialog(Race.kt)) {
            var2.AboutDialog(Race.kt, true);
         }

         if (var3.AboutDialog(Race.kv)) {
            var2.AboutDialog(Race.kv, true);
         }

         if (var3.AboutDialog(Race.kz)) {
            var2.AboutDialog(Race.kz, true);
         }
      }

      DiscoveryPanel.j(this.cu).updateUI();
   }
}
