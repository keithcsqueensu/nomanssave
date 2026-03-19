package nomanssave;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

class cF extends AbstractAction {
   // $FF: synthetic field
   final JsonEditorDialog gg;

   cF(JsonEditorDialog var1) {
      this.gg = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      int var2 = JsonEditorDialog.AccountPanel(this.gg).getSelectionStart();
      int var3 = JsonEditorDialog.AccountPanel(this.gg).getSelectionEnd();
      String var4 = var3 > var2 ? JsonEditorDialog.AccountPanel(this.gg).getText().substring(var2, var3) : null;
      aW.show(this.gg, var4);
   }
}
