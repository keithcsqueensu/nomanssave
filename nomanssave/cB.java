package nomanssave;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class cB implements DocumentListener {
   // $FF: synthetic field
   final JsonEditorDialog gg;

   cB(JsonEditorDialog var1) {
      this.gg = var1;
   }

   public void insertUpdate(DocumentEvent var1) {
      JsonEditorDialog.AboutDialog(this.gg, true);
   }

   public void removeUpdate(DocumentEvent var1) {
      JsonEditorDialog.AboutDialog(this.gg, true);
   }

   public void changedUpdate(DocumentEvent var1) {
   }
}
