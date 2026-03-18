package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class eg implements ComboBoxModel {
   // $FF: synthetic field
   final ec ik;
   // $FF: synthetic field
   private final int il;

   eg(ec var1, int var2) {
      this.ik = var1;
      this.il = var2;
   }

   public int getSize() {
      return ShipType.values().length;
   }

   public ShipType BasesStoragePanel(int var1) {
      return ShipType.values()[var1];
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      ShipType var2 = (ShipType)var1;
      if (var2 != null && !var2.equals(SquadronPanel.AboutDialog(ec.h(this.ik))[this.il].ef())) {
         SquadronPanel.AboutDialog(ec.h(this.ik))[this.il].AboutDialog(var2);
      }

   }

   public Object getSelectedItem() {
      return SquadronPanel.AboutDialog(ec.h(this.ik))[this.il].ef();
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.BasesStoragePanel(var1);
   }
}
