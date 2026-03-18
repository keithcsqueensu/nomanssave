package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

class az implements ActionListener {
   // $FF: synthetic field
   final DiscoveryPanel cu;

   az(DiscoveryPanel var1) {
      this.cu = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      Iterator var4 = AlienWord.by().iterator();

      while(var4.hasNext()) {
         AlienWord var3 = (AlienWord)var4.next();
         gA var2 = DiscoveryPanel.i(this.cu).AboutDialog(var3);
         var2.AboutDialog(Race.kr, false);
         var2.AboutDialog(Race.ks, false);
         var2.AboutDialog(Race.kt, false);
         var2.AboutDialog(Race.kv, false);
         var2.AboutDialog(Race.kz, false);
      }

      DiscoveryPanel.j(this.cu).updateUI();
   }
}
