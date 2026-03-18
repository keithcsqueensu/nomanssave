package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;

class cC implements ActionListener {
   // $FF: synthetic field
   final JsonEditorDialog gg;

   cC(JsonEditorDialog var1) {
      this.gg = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = JsonEditorDialog.AccountPanel(this.gg).getText().trim();

      try {
         JsonEditorDialog.d(this.gg).setText(var2);
         ((cI)JsonEditorDialog.e(this.gg).getModel()).AboutDialog(JsonEditorDialog.d(this.gg));
         JsonEditorDialog.e(this.gg).setSelectionRow(0);
         JsonEditorDialog.e(this.gg).setVisible(true);
         JsonEditorDialog.f(this.gg).setVisible(false);
      } catch (JsonParseException var4) {
         JOptionPane.showOptionDialog(this.gg, "Error on line #" + var4.getLineNumber() + ": " + var4.getMessage(), "Error", 0, 0, (Icon)null, new Object[]{"Cancel"}, (Object)null);
         JsonEditorDialog.AccountPanel(this.gg).setCaretPosition(var4.bD());
         JsonEditorDialog.AccountPanel(this.gg).requestFocus();
      }

   }
}
