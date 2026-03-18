package nomanssave;

import javax.swing.JComboBox;

public class VehiclesPanel extends SplitFormPanel {
   private JComboBox iw = new JComboBox();
   private InventoryPanel ix;
   private Vehicle[] iy;

   VehiclesPanel(Application var1) {
      this.iw.setModel(new eq(this));
      this.AboutDialog("Vehicle", true, this.iw);
      this.ix = new InventoryPanel(var1);
      this.AboutDialogCloseListener(this.ix);
   }

   void AppStartupRunnable() {
      this.ix.AppStartupRunnable();
   }

   void UpdateCheckThread() {
      this.ix.UpdateCheckThread();
   }

   void UpdateDownloadRunnable() {
      this.ix.UpdateDownloadRunnable();
   }

   void ShowWarningRunnable() {
      this.ix.ShowWarningRunnable();
   }

   void AboutDialog(Inventory var1) {
      this.ix.AboutDialog(var1);
   }

   Vehicle[] aT() {
      return this.iy;
   }

   void AboutDialog(Vehicle[] var1) {
      if (var1.length == 0) {
         this.iy = new Vehicle[0];
         this.iw.setSelectedIndex(-1);
      } else {
         this.iy = var1;
         this.iw.setSelectedIndex(0);
      }

      this.iw.updateUI();
   }

   // $FF: synthetic method
   static Vehicle[] AboutDialog(VehiclesPanel var0) {
      return var0.iy;
   }

   // $FF: synthetic method
   static InventoryPanel AboutDialogCloseListener(VehiclesPanel var0) {
      return var0.ix;
   }
}
