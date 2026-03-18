package nomanssave;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

class WindowCloseListener extends WindowAdapter {
   // $FF: synthetic field
   final Application aZ;

   WindowCloseListener(Application var1) {
      this.aZ = var1;
   }

   public void windowClosing(WindowEvent var1) {
      if (Application.i(this.aZ) || Application.j(this.aZ)) {
         int var2 = JOptionPane.showConfirmDialog(Application.h(this.aZ), "Save data before closing?", "Save", 0);
         if (var2 == 0) {
            if (Application.i(this.aZ)) {
               Application.k(this.aZ);
            }

            if (Application.j(this.aZ)) {
               Application.loadSave(this.aZ);
            }
         }
      }

      if (AppSettings.T()) {
         AppSettings.U();
      }

      Application.h(this.aZ).dispose();
   }

   public void windowDeactivated(WindowEvent var1) {
      Application.e(this.aZ, true);
   }

   public void windowActivated(WindowEvent var1) {
      Application.e(this.aZ, false);
      Application.saveAccountData(this.aZ);
   }
}
