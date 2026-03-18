package nomanssave;

import java.util.Collections;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class eq implements ComboBoxModel {
   private Vehicle iz;
   // $FF: synthetic field
   final VehiclesPanel iA;

   eq(VehiclesPanel var1) {
      this.iA = var1;
      this.iz = null;
   }

   public int getSize() {
      return VehiclesPanel.AboutDialog(this.iA) == null ? 0 : VehiclesPanel.AboutDialog(this.iA).length;
   }

   public Vehicle J(int var1) {
      return VehiclesPanel.AboutDialog(this.iA)[var1];
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      this.iz = (Vehicle)var1;
      if (this.iz == null) {
         VehiclesPanel.AboutDialogCloseListener(this.iA).AboutDialog(Collections.emptyList());
      } else {
         VehiclesPanel.AboutDialogCloseListener(this.iA).AboutDialog(this.iz.cC());
      }
   }

   public Object getSelectedItem() {
      return this.iz;
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.J(var1);
   }
}
