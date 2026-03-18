package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class k implements ComboBoxModel {
   private ex WindowCloseListener;
   // $FF: synthetic field
   final h ShowErrorRunnable;

   k(h var1) {
      this.ShowErrorRunnable = var1;
      this.WindowCloseListener = null;
   }

   public int getSize() {
      return h.g(this.ShowErrorRunnable).size();
   }

   public ex AccountPanel(int var1) {
      return (ex)h.g(this.ShowErrorRunnable).get(var1);
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      this.WindowCloseListener = (ex)var1;
      h.h(this.ShowErrorRunnable);
   }

   public Object getSelectedItem() {
      return this.WindowCloseListener;
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.AccountPanel(var1);
   }
}
