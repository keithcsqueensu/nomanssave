package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class da implements ActionListener {
   // $FF: synthetic field
   final cY TemplateLoader;

   da(cY var1) {
      this.TemplateLoader = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      cY.AboutDialog(this.TemplateLoader, cY.AboutDialogCloseListener(this.TemplateLoader).getSelectedIndex());
      this.TemplateLoader.setVisible(false);
   }
}
