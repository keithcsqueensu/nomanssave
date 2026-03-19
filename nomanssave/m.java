package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class m implements ActionListener {
   // $FF: synthetic field
   final h ShowErrorRunnable;

   m(h var1) {
      this.ShowErrorRunnable = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      h.access$setSelectedItem(this.ShowErrorRunnable, (ItemDefinition)h.j(this.ShowErrorRunnable).getSelectedItem());
      this.ShowErrorRunnable.setVisible(false);
   }
}
