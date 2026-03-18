package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ar implements ActionListener {
   // $FF: synthetic field
   final DiscoveryPanel cu;

   ar(DiscoveryPanel var1) {
      this.cu = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      DiscoveryPanel.k(this.cu);
   }
}
