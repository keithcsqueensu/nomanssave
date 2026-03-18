package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class cf implements ActionListener {
   // $FF: synthetic field
   final InventorySlotPanel fk;
   // $FF: synthetic field
   private final int FileWatcher;
   // $FF: synthetic field
   private final int FileWatcherThread;

   cf(InventorySlotPanel var1, int var2, int var3) {
      this.fk = var1;
      this.FileWatcher = var2;
      this.FileWatcherThread = var3;
   }

   public void actionPerformed(ActionEvent var1) {
      gu var2 = InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).f(this.FileWatcher, this.FileWatcherThread);
      if (var2 != null) {
         var2.AccountPanel(0.0D);
         var2.e(true);
         InventorySlotPanel.AccountPanel(this.fk);
      }

   }
}
