package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;

class ak implements ActionListener {
   // $FF: synthetic field
   final aj ItemDetailsDialog;

   ak(aj var1) {
      this.ItemDetailsDialog = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      try {
         aj.AboutDialog(this.ItemDetailsDialog, GalacticAddress.e(aj.AboutDialog(this.ItemDetailsDialog).getText().trim(), aj.AboutDialogCloseListener(this.ItemDetailsDialog).getSelectedIndex()));
         aj.AccountPanel(this.ItemDetailsDialog);
      } catch (RuntimeException var3) {
         JOptionPane.showOptionDialog(this.ItemDetailsDialog, "Invalid address value, please try again.", "Error", 0, 0, (Icon)null, new Object[]{"Cancel"}, (Object)null);
      }
   }
}
