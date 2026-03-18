package nomanssave;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cd implements ActionListener {
   // $FF: synthetic field
   final InventorySlotPanel fk;
   // $FF: synthetic field
   private final int FileWatcher;
   // $FF: synthetic field
   private final int FileWatcherThread;

   cd(InventorySlotPanel var1, int var2, int var3) {
      this.fk = var1;
      this.FileWatcher = var2;
      this.FileWatcherThread = var3;
   }

   public void actionPerformed(ActionEvent var1) {
      gu var2 = InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).f(this.FileWatcher, this.FileWatcherThread);
      if (var2 != null) {
         ItemDetailsDialog.AboutDialog((Container)InventorySlotPanel.j(this.fk), (ItemData)var2);
         InventorySlotPanel.AccountPanel(this.fk);
      }

   }
}
