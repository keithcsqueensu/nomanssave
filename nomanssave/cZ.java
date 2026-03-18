package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

class cZ implements ComboBoxModel {
   private gg ItemData;
   // $FF: synthetic field
   final cY TemplateLoader;

   cZ(cY var1) {
      this.TemplateLoader = var1;
      this.ItemData = null;
   }

   public int getSize() {
      return cY.AboutDialog(this.TemplateLoader).size();
   }

   public gg C(int var1) {
      return (gg)cY.AboutDialog(this.TemplateLoader).get(var1);
   }

   public void addListDataListener(ListDataListener var1) {
   }

   public void removeListDataListener(ListDataListener var1) {
   }

   public void setSelectedItem(Object var1) {
      this.ItemData = (gg)var1;
   }

   public Object getSelectedItem() {
      return this.ItemData;
   }

   // $FF: synthetic method
   public Object getElementAt(int var1) {
      return this.C(var1);
   }
}
