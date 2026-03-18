package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bZ implements ActionListener {
   // $FF: synthetic field
   final InventorySlotPanel fk;
   // $FF: synthetic field
   private final int FileWatcher;
   // $FF: synthetic field
   private final int FileWatcherThread;

   bZ(InventorySlotPanel var1, int var2, int var3) {
      this.fk = var1;
      this.FileWatcher = var2;
      this.FileWatcherThread = var3;
   }

   public void actionPerformed(ActionEvent var1) {
      if (InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).dq()) {
         if (InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).l(this.FileWatcher, this.FileWatcherThread)) {
            InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).m(this.FileWatcher, this.FileWatcherThread);
            InventorySlotPanel.AccountPanel(this.fk);
         }
      }
   }
}
