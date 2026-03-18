package nomanssave;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

class bX extends MouseAdapter {
   // $FF: synthetic field
   final InventorySlotPanel fk;
   // $FF: synthetic field
   private final int FileWatcher;
   // $FF: synthetic field
   private final int FileWatcherThread;

   bX(InventorySlotPanel var1, int var2, int var3) {
      this.fk = var1;
      this.FileWatcher = var2;
      this.FileWatcherThread = var3;
   }

   public void mouseReleased(MouseEvent var1) {
      if (InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).h(this.FileWatcher, this.FileWatcherThread) && !InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).l(this.FileWatcher, this.FileWatcherThread)) {
         int var2 = UIManager.getInt("Inventory.gridSize");
         int var3 = this.FileWatcher + (int)Math.floor((double)var1.getX() / (double)var2);
         int var4 = this.FileWatcherThread + (int)Math.floor((double)var1.getY() / (double)var2);
         if (var3 >= 0 && var3 < InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).getWidth()) {
            if (var4 >= 0 && var4 < InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).getHeight()) {
               if (var3 != this.FileWatcher || var4 != this.FileWatcherThread) {
                  InventorySlotPanel var5 = InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk), var3, var4);
                  if (var5 != null && InventorySlotPanel.e(var5) && !InventorySlotPanel.f(var5)) {
                     if (var1.isControlDown()) {
                        InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).AboutDialog(this.FileWatcher, this.FileWatcherThread, var3, var4);
                     } else {
                        InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).AboutDialogCloseListener(this.FileWatcher, this.FileWatcherThread, var3, var4);
                     }

                     InventorySlotPanel.AccountPanel(this.fk);
                     InventorySlotPanel.AccountPanel(var5);
                  }
               }
            }
         }
      }
   }

   public void mouseClicked(MouseEvent var1) {
      if (var1.getClickCount() == 2) {
         gu var2 = InventoryPanel.AboutDialog(InventorySlotPanel.j(this.fk)).f(this.FileWatcher, this.FileWatcherThread);
         if (var2 != null) {
            ItemDetailsDialog.AboutDialog((Container)InventorySlotPanel.j(this.fk), (ItemData)var2);
            InventorySlotPanel.AccountPanel(this.fk);
         }
      }

   }
}
