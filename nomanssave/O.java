package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class O implements ActionListener {
   // $FF: synthetic field
   final BasesStoragePanel bt;
   // $FF: synthetic field
   private final Application bv;

   O(BasesStoragePanel var1, Application var2) {
      this.bt = var1;
      this.bv = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      Base var2 = (Base)BasesStoragePanel.j(this.bt).getSelectedItem();
      if (var2 != null && this.bv.AboutDialogCloseListener(var2)) {
         BasesStoragePanel.e(this.bt).setText(Integer.toString(var2.cG()));
      }

   }
}
