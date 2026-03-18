package nomanssave;

import javax.swing.JComponent;

class bN extends FormPanel {
   // $FF: synthetic field
   final MilestonesPanel ItemDefinition;

   bN(MilestonesPanel var1) {
      super(AppSettings.cJ, 0);
      this.ItemDefinition = var1;
   }

   void AboutDialog(String var1, gs var2) {
      this.AboutDialog(var1, (gs)var2, true, (String)null);
   }

   void AboutDialog(String var1, gs var2, boolean var3, String var4) {
      bJ var5 = new bJ(this.ItemDefinition, var2, var3);
      if (var4 != null) {
         var5.setToolTipText(var4);
      }

      this.AboutDialog(var1, (JComponent)var5);
   }

   void AboutDialog(String var1, bK var2) {
      this.AboutDialog(var1, (bK)var2, true, (String)null);
   }

   void AboutDialog(String var1, bK var2, boolean var3, String var4) {
      bL var5 = new bL(this.ItemDefinition, var2, var3);
      if (var4 != null) {
         var5.setToolTipText(var4);
      }

      this.AboutDialog(var1, (JComponent)var5);
   }
}
