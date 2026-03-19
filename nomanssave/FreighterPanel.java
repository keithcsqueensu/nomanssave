package nomanssave;

import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FreighterPanel extends SplitFormPanel {
   private static final double SettlementsPanel = 1000.0D;
   private static final double dF = 1000.0D;
   private ValidatedTextField dG;
   private cN dH;
   private cN dI;
   private ValidatedTextField dJ;
   private ValidatedTextField dK;
   private ValidatedTextField dL;
   private ValidatedTextField dM;
   private JTextField bm;
   private JButton bn;
   private JButton bo;
   private InventoryPanel ShipsPanel;
   private Freighter dO;

   FreighterPanel(Application var1) {
      this.k("Freighter");
      this.dG = new be(this);
      this.AboutDialog("Name", this.dG);
      this.dH = new cN(FreighterType.class);
      this.dH.AboutDialog((var1x) -> {
         if (this.dO != null) {
            this.dO.ag(var1x);
         }

      });
      this.AboutDialog("Type", this.dH);
      this.dI = new cN(ShipClass.class);
      this.dI.AboutDialog((var1x) -> {
         if (this.dO != null) {
            this.dO.aj(var1x);
         }

      });
      this.AboutDialog("Class", this.dI);
      this.dJ = new bf(this);
      this.AboutDialog("Home Seed", this.dJ);
      this.dK = new bg(this);
      this.AboutDialog("Model Seed", this.dK);
      this.k("Base Stats");
      this.dL = new bh(this);
      this.AboutDialog("Hyperdrive", this.dL);
      this.dM = new bi(this);
      this.AboutDialog("Fleet Coordination", this.dM);
      this.Y();
      this.k("Base Info");
      this.bm = new JTextField();
      this.bm.setEnabled(false);
      this.AboutDialog("Items", this.bm);
      JPanel var2 = new JPanel();
      this.bn = new JButton("Backup");
      this.bn.addActionListener(new bj(this, var1));
      var2.add(this.bn);
      this.bo = new JButton("Restore");
      this.bo.addActionListener(new bk(this, var1));
      var2.add(this.bo);
      this.AboutDialog((JComponent)var2);
      this.ShipsPanel = new InventoryPanel(var1);
      this.AboutDialogCloseListener(this.ShipsPanel);
   }

   void AppStartupRunnable() {
      this.ShipsPanel.AppStartupRunnable();
   }

   void UpdateCheckThread() {
      this.ShipsPanel.UpdateCheckThread();
   }

   void UpdateDownloadRunnable() {
      this.ShipsPanel.UpdateDownloadRunnable();
   }

   void ShowWarningRunnable() {
      this.ShipsPanel.ShowWarningRunnable();
   }

   void updateInventory(Inventory var1) {
      this.ShipsPanel.updateInventory(var1);
   }

   Freighter Z() {
      return this.dO;
   }

   void updateFreighter(Freighter var1) {
      if (var1 == null) {
         this.dO = null;
         this.dG.setText("");
         this.dH.setSelectedIndex(-1);
         this.dH.updateUI();
         this.dI.setSelectedIndex(-1);
         this.dJ.setText("");
         this.dK.setText("");
         this.dL.setText("");
         this.dM.setText("");
         this.bm.setText("");
         this.bn.setEnabled(false);
         this.bo.setEnabled(false);
         this.ShipsPanel.AboutDialog(Collections.emptyList());
      } else {
         this.dO = var1;
         this.dG.setText(var1.getName());
         this.dH.m(var1.cT());
         this.dI.m(var1.LineNumberPanel());
         this.dJ.setText(var1.cU());
         this.dK.setText(var1.cV());
         this.dL.setText(Double.toString(var1.cX()));
         this.dM.setText(Double.toString(var1.cY()));
         FreighterBase var2 = var1.cZ();
         if (var2 == null) {
            this.bm.setText("");
            this.bn.setEnabled(false);
            this.bo.setEnabled(false);
         } else {
            this.bm.setText(Integer.toString(var2.cG()));
            this.bn.setEnabled(true);
            this.bo.setEnabled(true);
         }

         this.ShipsPanel.AboutDialog(var1.cC());
      }

   }

   // $FF: synthetic method
   static Freighter access$getFreighter(FreighterPanel var0) {
      return var0.dO;
   }

   // $FF: synthetic method
   static ValidatedTextField access$getNameField(FreighterPanel var0) {
      return var0.dG;
   }

   // $FF: synthetic method
   static ValidatedTextField access$getSeedField(FreighterPanel var0) {
      return var0.dJ;
   }
}
