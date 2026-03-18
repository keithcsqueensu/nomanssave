package nomanssave;

import java.awt.Rectangle;
import javax.swing.text.BadLocationException;

class cX implements Runnable {
   // $FF: synthetic field
   final LineNumberPanel ShipType;

   cX(LineNumberPanel var1) {
      this.ShipType = var1;
   }

   public void run() {
      try {
         int var1 = LineNumberPanel.AboutDialog(this.ShipType).getDocument().getLength();
         Rectangle var2 = LineNumberPanel.AboutDialog(this.ShipType).modelToView(var1);
         if (var2 != null && var2.UpdateDownloadRunnable != LineNumberPanel.AboutDialogCloseListener(this.ShipType)) {
            LineNumberPanel.AccountPanel(this.ShipType);
            this.ShipType.repaint();
            LineNumberPanel.AboutDialog(this.ShipType, var2.UpdateDownloadRunnable);
         }
      } catch (BadLocationException var3) {
      }

   }
}
