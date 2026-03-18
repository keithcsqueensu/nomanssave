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
      return ((Enum[])this.gu.getEnumConstants()).length + cN.AboutDialog(this.Inventory).size();
   }

   public Object getElementAt(int var1) {
      return var1 < ((Enum[])this.gu.getEnumConstants()).length ? ((Enum[])this.gu.getEnumConstants())[var1] : cN.AboutDialog(this.Inventory).get(var1 - ((Enum[])this.gu.getEnumConstants()).length);
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      Object var2 = cN.AboutDialogCloseListener(this.Inventory);
      cN.AboutDialog(this.Inventory, var1);
      if (cN.AccountPanel(this.Inventory) != null) {
         SwingUtilities.invokeLater(() -> {
            if (cN.AboutDialogCloseListener(this.Inventory) == null) {
               if (var2 != null) {
                  cN.AccountPanel(this.Inventory).setSelectedValue((String)null);
               }
            } else if (var2 == null || !cN.AboutDialogCloseListener(this.Inventory).equals(var2)) {
               if (cN.d(this.Inventory)) {
                  cN.AccountPanel(this.Inventory).setSelectedValue(((gD)cN.AboutDialogCloseListener(this.Inventory)).K());
               } else if (cN.AboutDialogCloseListener(this.Inventory) instanceof Enum) {
                  cN.AccountPanel(this.Inventory).setSelectedValue(((Enum)cN.AboutDialogCloseListener(this.Inventory)).name());
               } else {
                  cN.AccountPanel(this.Inventory).setSelectedValue(cN.AboutDialogCloseListener(this.Inventory).toString());
               }
            }

         });
      }

   }

   public Object getSelectedItem() {
      return cN.AboutDialogCloseListener(this.Inventory);
   }
}
