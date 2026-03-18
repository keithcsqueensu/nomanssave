package nomanssave;

import java.util.Collections;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class dO implements ComboBoxModel {
   private Starship hZ;
   // $FF: synthetic field
   final ShipsPanel ia;
   // $FF: synthetic field
   private final Application bv;

   dO(ShipsPanel var1, Application var2) {
      this.ia = var1;
      this.bv = var2;
      this.hZ = null;
   }

   public int getSize() {
      return ShipsPanel.AboutDialog(this.ia) == null ? 0 : ShipsPanel.AboutDialog(this.ia).length;
   }

   public Starship ValidatedTextField(int var1) {
      return ShipsPanel.AboutDialog(this.ia)[var1];
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      this.hZ = (Starship)var1;
      if (this.hZ == null) {
         ShipsPanel.AboutDialogCloseListener(this.ia).setText("");
         ShipsPanel.AccountPanel(this.ia).setSelectedIndex(-1);
         ShipsPanel.d(this.ia).setSelectedIndex(-1);
         ShipsPanel.e(this.ia).setText("");
         ShipsPanel.f(this.ia).setSelected(false);
         ShipsPanel.f(this.ia).setEnabled(false);
         ShipsPanel.g(this.ia).setEnabled(false);
         ShipsPanel.h(this.ia).setText("");
         ShipsPanel.i(this.ia).setText("");
         ShipsPanel.j(this.ia).setText("");
         ShipsPanel.k(this.ia).setText("");
         ShipsPanel.l(this.ia).AboutDialog(Collections.emptyList());
      } else {
         ShipsPanel.AboutDialogCloseListener(this.ia).setText(this.hZ.getName());
         ShipsPanel.AccountPanel(this.ia).m(this.hZ.cT());
         ShipsPanel.d(this.ia).m(this.hZ.LineNumberPanel());
         ShipsPanel.e(this.ia).setText(this.hZ.cK());
         JsonArray var2 = this.bv.d("PlayerStateData.ShipUsesLegacyColours");
         ShipsPanel.f(this.ia).setSelected(var2 != null && var2.ab(this.hZ.getIndex()));
         ShipsPanel.f(this.ia).setEnabled(true);
         ShipsPanel.g(this.ia).setEnabled(true);
         ShipsPanel.h(this.ia).setText(Double.toString(this.hZ.dF()));
         ShipsPanel.i(this.ia).setText(Double.toString(this.hZ.SquadronPanel()));
         ShipsPanel.j(this.ia).setText(Double.toString(this.hZ.cX()));
         ShipsPanel.k(this.ia).setText(Double.toString(this.hZ.ec()));
         ShipsPanel.l(this.ia).AboutDialog(this.hZ.cC());
         ShipsPanel.m(this.ia).setEnabled(false);
         ShipsPanel.n(this.ia).setEnabled(false);
         if (ShipsPanel.o(this.ia) != null) {
            for(int var3 = 0; var3 < ShipsPanel.AboutDialog(this.ia).length; ++var3) {
               if (this.hZ == ShipsPanel.AboutDialog(this.ia)[var3] && var3 == ShipsPanel.o(this.ia).dV()) {
                  ShipsPanel.m(this.ia).setEnabled(true);
                  ShipsPanel.n(this.ia).setEnabled(true);
               }
            }
         }

      }
   }

   public Object getSelectedItem() {
      return this.hZ;
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.ValidatedTextField(var1);
   }
}
