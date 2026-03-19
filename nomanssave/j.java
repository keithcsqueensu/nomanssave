package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class j implements ComboBoxModel {
   private eB ShowWarningRunnable;
   // $FF: synthetic field
   final h ShowErrorRunnable;

   j(h var1) {
      this.ShowErrorRunnable = var1;
      this.ShowWarningRunnable = null;
   }

   public int getSize() {
      return h.e(this.ShowErrorRunnable).size();
   }

   public eB getElementAt(int var1) {
      return (eB)h.e(this.ShowErrorRunnable).get(var1);
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      this.ShowWarningRunnable = (eB)var1;
      h.f(this.ShowErrorRunnable);
   }

   public Object getSelectedItem() {
      return this.ShowWarningRunnable;
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.getElementAt(var1);
   }
}
