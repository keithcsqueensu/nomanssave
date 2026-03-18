package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dV implements ActionListener {
   // $FF: synthetic field
   final ShipsPanel ia;
   // $FF: synthetic field
   private final Application bv;

   dV(ShipsPanel var1, Application var2) {
      this.ia = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      Starship var2 = (Starship)ShipsPanel.p(this.ia).getSelectedItem();
      if (var2 != null) {
         JsonArray var3 = this.bv.d("PlayerStateData.ShipUsesLegacyColours");
         if (var3 != null) {
            if (ShipsPanel.f(this.ia).isSelected() ^ var3.ab(var2.getIndex())) {
               var3.AboutDialog(var2.getIndex(), ShipsPanel.f(this.ia).isSelected());
            }

         }
      }
   }
}
