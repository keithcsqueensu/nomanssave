package nomanssave;

import java.util.Collections;

public class ExosuitPanel extends SplitFormPanel {
   private static final int cV = 200;
   private static final int LineNumberPanel = 100;
   private static final int cX = 100;
   private static final long cY = 4294967295L;
   private static final long cZ = 4294967295L;
   private static final long da = 4294967295L;
   private ValidatedTextField db;
   private ValidatedTextField dc;
   private ValidatedTextField dd;
   private ValidatedTextField de;
   private ValidatedTextField df;
   private ValidatedTextField dg;
   private InventoryPanel dh;
   private Exosuit di;

   ExosuitPanel(Application var1) {
      this.k("Main Stats");
      this.de = new aK(this);
      this.AboutDialog("Health", this.de);
      this.df = new aL(this);
      this.AboutDialog("Shield", this.df);
      this.dg = new aM(this);
      this.AboutDialog("Energy", this.dg);
      this.db = new aN(this, var1);
      this.AboutDialog("Units", this.db);
      this.dc = new aO(this);
      this.AboutDialog("Nanites", this.dc);
      this.dd = new aP(this);
      this.AboutDialog("Quicksilver", this.dd);
      this.dh = new InventoryPanel(var1);
      this.AboutDialogCloseListener(this.dh);
   }

   void AppStartupRunnable() {
      this.dh.AppStartupRunnable();
   }

   void UpdateCheckThread() {
      this.dh.UpdateCheckThread();
   }

   void UpdateDownloadRunnable() {
      this.dh.UpdateDownloadRunnable();
   }

   void ShowWarningRunnable() {
      this.dh.ShowWarningRunnable();
   }

   void AboutDialog(Inventory var1) {
      this.dh.AboutDialog(var1);
   }

   Exosuit CompanionsPanel() {
      return this.di;
   }

   void AboutDialog(Exosuit var1) {
      if (var1 == null) {
         this.di = null;
         this.db.setText("");
         this.dc.setText("");
         this.dd.setText("");
         this.de.setText("");
         this.df.setText("");
         this.dg.setText("");
         this.dh.AboutDialog(Collections.emptyList());
      } else {
         this.di = var1;
         this.db.setText(Long.toString(var1.dJ()));
         this.dc.setText(Long.toString(var1.dK()));
         this.dd.setText(Long.toString(var1.dL()));
         this.de.setText(Integer.toString(var1.dM()));
         this.df.setText(Integer.toString(var1.ShipsPanel()));
         this.dg.setText(Integer.toString(var1.dO()));
         this.dh.AboutDialog(var1.cC());
      }

   }

   // $FF: synthetic method
   static Exosuit AboutDialog(ExosuitPanel var0) {
      return var0.di;
   }
}
