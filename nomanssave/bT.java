package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bT implements ActionListener {
   // $FF: synthetic field
   final InventorySlotPanel fk;
   // $FF: synthetic field
   private final int FileWatcher;
   // $FF: synthetic field
   private final int FileWatcherThread;

   bT(InventorySlotPanel var1, int var2, int var3) {
      this.fk = var1;
      this.FileWatcher = var2;
      this.FileWatcherThread = var3;
   }

   public void actionPerformed(ActionEvent var1) {
      if (InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).dp() || en.aS()) {
         if (InventorySlotPanel.AboutDialogCloseListener(this.fk).isSelected()) {
            InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).i(this.FileWatcher, this.FileWatcherThread);
         } else {
            if (InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).f(this.FileWatcher, this.FileWatcherThread) != null) {
               InventorySlotPanel.AboutDialogCloseListener(this.fk).setSelected(true);
               InventoryPanel.AboutDialogCloseListener(InventorySlotPanel.j(this.fk)).AccountPanel("Cannot disable slots that are in use!");
               return;
            }

            InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).j(this.FileWatcher, this.FileWatcherThread);
         }

         InventorySlotPanel.AccountPanel(this.fk);
      }
   }
}
