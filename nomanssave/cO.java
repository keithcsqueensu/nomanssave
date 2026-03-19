package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListDataListener;

class cO implements ComboBoxModel {
   // $FF: synthetic field
   final cN Inventory;
   // $FF: synthetic field
   private final Class gu;

   cO(cN var1, Class var2) {
      this.Inventory = var1;
      this.gu = var2;
   }

   public int getSize() {
      return ((Enum[])this.gu.getEnumConstants()).length + cN.access$getItems(this.Inventory).size();
   }

   public Object getElementAt(int var1) {
      return var1 < ((Enum[])this.gu.getEnumConstants()).length ? ((Enum[])this.gu.getEnumConstants())[var1] : cN.access$getItems(this.Inventory).get(var1 - ((Enum[])this.gu.getEnumConstants()).length);
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      Object var2 = cN.access$getSelectedItem(this.Inventory);
      cN.access$setSelectedItem(this.Inventory, var1);
      if (cN.access$getChangeListener(this.Inventory) != null) {
         SwingUtilities.invokeLater(() -> {
            if (cN.access$getSelectedItem(this.Inventory) == null) {
               if (var2 != null) {
                  cN.access$getChangeListener(this.Inventory).setSelectedValue((String)null);
               }
            } else if (var2 == null || !cN.access$getSelectedItem(this.Inventory).equals(var2)) {
               if (cN.d(this.Inventory)) {
                  cN.access$getChangeListener(this.Inventory).setSelectedValue(((gD)cN.access$getSelectedItem(this.Inventory)).K());
               } else if (cN.access$getSelectedItem(this.Inventory) instanceof Enum) {
                  cN.access$getChangeListener(this.Inventory).setSelectedValue(((Enum)cN.access$getSelectedItem(this.Inventory)).name());
               } else {
                  cN.access$getChangeListener(this.Inventory).setSelectedValue(cN.access$getSelectedItem(this.Inventory).toString());
               }
            }

         });
      }

   }

   public Object getSelectedItem() {
      return cN.access$getSelectedItem(this.Inventory);
   }
}
