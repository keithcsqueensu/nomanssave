package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class bz implements ActionListener {
   // $FF: synthetic field
   final FrigatesPanel er;

   bz(FrigatesPanel var1) {
      this.er = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      if (FrigatesPanel.AboutDialogCloseListener(this.er) >= 0) {
         Logger.info("Repairing frigate damage");
         FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].aw(0);
         FrigatesPanel.AccountPanel(this.er)[FrigatesPanel.AboutDialogCloseListener(this.er)].ax(0);
         FrigatesPanel.UpdateDownloadRunnable(this.er).setText("");
         FrigatesPanel.ShowErrorRunnable(this.er).setVisible(false);
      }
   }
}
