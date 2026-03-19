package nomanssave;

import javax.swing.JTextField;

class bL extends JTextField {
   final bK eB;
   // $FF: synthetic field
   final MilestonesPanel ItemDefinition;

   bL(MilestonesPanel var1, bK var2, boolean var3) {
      this.ItemDefinition = var1;
      this.eB = var2;
      this.setEnabled(var3);
      this.addFocusListener(new bM(this, var2));
   }

   void ac() {
      String var1;
      if (MilestonesPanel.AboutDialog(this.ItemDefinition) == null) {
         var1 = "";
      } else {
         var1 = this.eB.ab();
      }

      this.setText(var1);
   }

   // $FF: synthetic method
   static MilestonesPanel access$getMilestonesPanel(bL var0) {
      return var0.ItemDefinition;
   }
}
