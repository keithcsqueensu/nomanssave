package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class dc implements ActionListener {
   // $FF: synthetic field
   final cY TemplateLoader;

   dc(cY var1) {
      this.TemplateLoader = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.TemplateLoader.setVisible(false);
   }
}
