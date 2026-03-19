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
      cY.access$setSelected(this.TemplateLoader, cY.access$getComboBox(this.TemplateLoader).getSelectedIndex());
      this.TemplateLoader.setVisible(false);
   }
}
