package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cb implements ActionListener {
   // $FF: synthetic field
   final InventorySlotPanel fk;
   // $FF: synthetic field
   private final int FileWatcher;
   // $FF: synthetic field
   private final int FileWatcherThread;

   cb(InventorySlotPanel var1, int var2, int var3) {
      this.fk = var1;
      this.FileWatcher = var2;
      this.FileWatcherThread = var3;
   }

   public void actionPerformed(ActionEvent var1) {
      boolean var2 = InventorySlotPanel.d(this.fk).getState();
      InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).AboutDialog(this.FileWatcher, this.FileWatcherThread, var2);
      InventorySlotPanel.AccountPanel(this.fk);
   }
}
