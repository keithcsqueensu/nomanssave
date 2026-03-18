package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class aX implements ActionListener {
   // $FF: synthetic field
   final aW dy;
   // $FF: synthetic field
   private final JsonEditorDialog dz;

   aX(aW var1, JsonEditorDialog var2) {
      this.dy = var1;
      this.dz = var2;
   }

   public void actionPerformed(ActionEvent var1) {
      String var2 = aW.AboutDialog(this.dy).getText();
      if (var2.length() > 0) {
         this.dz.AboutDialog(var2, aW.AboutDialogCloseListener(this.dy).isSelected(), aW.AccountPanel(this.dy).isSelected(), aW.d(this.dy).isSelected());
      }

   }
}
