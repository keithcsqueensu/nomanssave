package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class ee implements ComboBoxModel {
   // $FF: synthetic field
   final ec ik;
   // $FF: synthetic field
   private final int il;

   ee(ec var1, int var2) {
      this.ik = var1;
      this.il = var2;
   }

   public int getSize() {
      return SquadronPanel.aP().length;
   }

   public NpcType H(int var1) {
      return SquadronPanel.aP()[var1];
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      NpcType var2 = (NpcType)var1;
      if (var2 != null && !var2.equals(SquadronPanel.AboutDialog(ec.h(this.ik))[this.il].ed())) {
         SquadronPanel.AboutDialog(ec.h(this.ik))[this.il].AboutDialog(var2);
      }

   }

   public Object getSelectedItem() {
      return SquadronPanel.AboutDialog(ec.h(this.ik))[this.il].ed();
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.H(var1);
   }
}
