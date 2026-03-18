package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class db implements ActionListener {
   // $FF: synthetic field
   final cY TemplateLoader;

   db(cY var1) {
      this.TemplateLoader = var1;
   }

   public void actionPerformed(ActionEvent var1) {
      this.TemplateLoader.setVisible(false);
   }
}
