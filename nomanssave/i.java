package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;

class i implements ActionListener {
   // $FF: synthetic field
   final h ShowErrorRunnable;

   i(h var1) {
      this.ShowErrorRunnable = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = h.access$getTextField(this.ShowErrorRunnable).getText();
      h.access$setSelectedItem(this.ShowErrorRunnable, ItemDefinition.findByAmmoType(h.access$getTypeFilter(this.ShowErrorRunnable), var2));
      h.access$refreshCategoryFilter(this.ShowErrorRunnable);
      if (h.d(this.ShowErrorRunnable).size() == 0) {
         JOptionPane.showOptionDialog(this.ShowErrorRunnable, "Item not found.", "Warning", 0, 2, (Icon)null, new Object[]{"OK"}, (Object)null);
      }

   }
}
