package nomanssave;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Icon;
import javax.swing.JOptionPane;

class cE extends WindowAdapter {
   // $FF: synthetic field
   final JsonEditorDialog gg;

   cE(JsonEditorDialog var1) {
      this.gg = var1;
   }

   public void windowClosing(WindowEvent var1) {
      boolean var2 = true;
      if (JsonEditorDialog.g(this.gg) && JsonEditorDialog.d(this.gg) != null) {
         try {
            String var3 = JsonEditorDialog.AccountPanel(this.gg).getText().trim();
            if (var3.length() == 0 && JOptionPane.showConfirmDialog(this.gg, "The JSON data has been deleted, do you wish to apply these changes to the save file?", this.gg.getTitle(), 0) == 0) {
               JsonEditorDialog.d(this.gg).remove();
            } else if (JOptionPane.showConfirmDialog(this.gg, "The JSON data has changed, do you wish to apply these changes to the save file?", this.gg.getTitle(), 0) == 0) {
               JsonEditorDialog.d(this.gg).setText(var3);
            }
         } catch (JsonParseException var4) {
            JOptionPane.showOptionDialog(this.gg, "Error on line #" + var4.getLineNumber() + ": " + var4.getMessage(), "Error", 0, 0, (Icon)null, new Object[]{"Cancel"}, (Object)null);
            JsonEditorDialog.AccountPanel(this.gg).setCaretPosition(var4.bD());
            JsonEditorDialog.AccountPanel(this.gg).requestFocus();
            var2 = false;
         }
      }

      if (var2) {
         this.gg.setVisible(false);
      }

   }
}
