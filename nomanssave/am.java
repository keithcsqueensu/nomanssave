package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;

class am implements ActionListener {
   // $FF: synthetic field
   final aj ItemDetailsDialog;

   am(aj var1) {
      this.ItemDetailsDialog = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      int var2 = aj.AboutDialogCloseListener(this.ItemDetailsDialog).getSelectedIndex();
      if (var2 < 0) {
         JOptionPane.showOptionDialog(this.ItemDetailsDialog, "Invalid galaxy selected, please try again.", "Error", 0, 0, (Icon)null, new Object[]{"Cancel"}, (Object)null);
      } else {
         if (JOptionPane.showOptionDialog(this.ItemDetailsDialog, "This will warp your character and ship to the specified system (not the portal itself).", "Confirm", 2, 1, (Icon)null, new String[]{"OK", "Cancel"}, (Object)null) == 0) {
            aj.AboutDialog(this.ItemDetailsDialog, true);
            this.ItemDetailsDialog.setVisible(false);
         }

      }
   }
}
