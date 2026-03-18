package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class r implements ActionListener {
   // $FF: synthetic field
   final p BasesStoragePanel;

   r(p var1) {
      this.BasesStoragePanel = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      int[] var2 = p.AboutDialogCloseListener(this.BasesStoragePanel).getSelectedRows();
      p.AboutDialog(this.BasesStoragePanel, new ArrayList());

      for(int var4 = 0; var4 < var2.length; ++var4) {
         int var3 = p.AboutDialogCloseListener(this.BasesStoragePanel).convertRowIndexToModel(var2[var4]);
         p.AccountPanel(this.BasesStoragePanel).add((String)p.AboutDialogCloseListener(this.BasesStoragePanel).getModel().getValueAt(var3, 3));
      }

      this.BasesStoragePanel.setVisible(false);
   }
}
