package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class l implements ComboBoxModel {
   private ItemDefinition C;
   // $FF: synthetic field
   final h ShowErrorRunnable;

   l(h var1) {
      this.ShowErrorRunnable = var1;
      this.C = null;
   }

   public int getSize() {
      return h.i(this.ShowErrorRunnable).size();
   }

   public ItemDefinition d(int var1) {
      return (ItemDefinition)h.i(this.ShowErrorRunnable).get(var1);
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      this.C = (ItemDefinition)var1;
   }

   public Object getSelectedItem() {
      return this.C;
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.d(var1);
   }
}
