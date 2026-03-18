package nomanssave;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class MultitoolPanel extends SplitFormPanel {
   private static final double gX = 1000.0D;
   private static final double gY = 1000.0D;
   private static final double gZ = 1000.0D;
   private JComboBox ha = new JComboBox();
   private ValidatedTextField hb;
   private cN Logger;
   private cN hd;
   private ValidatedTextField he;
   private ValidatedTextField hf;
   private ValidatedTextField hg;
   private ValidatedTextField SpookyHash;
   private JButton bQ;
   private JButton bR;
   private JButton InventorySlotPanel;
   private InventoryPanel hi;
   private Multitool[] hj;

   MultitoolPanel(Application var1) {
      this.ha.setModel(new dk(this));
      this.AboutDialog("Multitool", true, this.ha);
      this.hb = new dl(this);
      this.AboutDialog((String)"Name", (JComponent)this.hb);
      this.Logger = new cN(MultitoolType.class);
      this.Logger.AboutDialog((var1x) -> {
         Multitool var2 = (Multitool)this.ha.getSelectedItem();
         if (var2 != null) {
            var2.ag(var1x);
         }

      });
      this.AboutDialog((String)"Type", (JComponent)this.Logger);
      this.hd = new cN(ShipClass.class);
      this.hd.AboutDialog((var1x) -> {
         Multitool var2 = (Multitool)this.ha.getSelectedItem();
         if (var2 != null) {
            var2.aj(var1x);
         }

      });
      this.AboutDialog((String)"Class", (JComponent)this.hd);
      this.he = new dm(this);
      this.AboutDialog((String)"Seed", (ValidatedTextField)this.he);
      this.k("Base Stats");
      this.hf = new dn(this);
      this.AboutDialog((String)"Damage", (JComponent)this.hf);
      this.hg = new do(this);
      this.AboutDialog((String)"Mining", (JComponent)this.hg);
      this.SpookyHash = new dp(this);
      this.AboutDialog((String)"Scan", (JComponent)this.SpookyHash);
      this.Y();
      JPanel var2 = new JPanel();
      this.bQ = new JButton("Delete Multitool");
      this.bQ.addActionListener(new dq(this, var1));
      var2.add(this.bQ);
      this.bR = new JButton("Export");
      this.bR.addActionListener(new dr(this, var1));
      var2.add(this.bR);
      this.InventorySlotPanel = new JButton("Import");
      this.InventorySlotPanel.addActionListener(new ds(this, var1));
      var2.add(this.InventorySlotPanel);
      this.AboutDialog((JComponent)var2);
      this.hi = new InventoryPanel(var1);
      this.AboutDialogCloseListener(this.hi);
   }

   void AppStartupRunnable() {
      this.hi.AppStartupRunnable();
   }

   void UpdateCheckThread() {
      this.hi.UpdateCheckThread();
   }

   void UpdateDownloadRunnable() {
      this.hi.UpdateDownloadRunnable();
   }

   void ShowErrorRunnable() {
      this.hi.ShowErrorRunnable();
   }

   void ShowWarningRunnable() {
      this.hi.ShowWarningRunnable();
   }

   void AboutDialog(Inventory var1) {
      this.hi.AboutDialog(var1);
   }

   Multitool[] aK() {
      return this.hj;
   }

   void AboutDialog(Multitool[] var1, MultitoolSettings var2) {
      this.hj = var1;
      if (var1.length == 0) {
         this.ha.setSelectedIndex(-1);
      } else {
         int var3 = var2 == null ? 0 : var2.dU();
         if (var3 >= var1.length) {
            var3 = 0;
         }

         this.ha.setSelectedIndex(var3);
      }

      this.ha.updateUI();
   }

   // $FF: synthetic method
   static Multitool[] AboutDialog(MultitoolPanel var0) {
      return var0.hj;
   }

   // $FF: synthetic method
   static ValidatedTextField AboutDialogCloseListener(MultitoolPanel var0) {
      return var0.hb;
   }

   // $FF: synthetic method
   static cN AccountPanel(MultitoolPanel var0) {
      return var0.Logger;
   }

   // $FF: synthetic method
   static cN d(MultitoolPanel var0) {
      return var0.hd;
   }

   // $FF: synthetic method
   static ValidatedTextField e(MultitoolPanel var0) {
      return var0.he;
   }

   // $FF: synthetic method
   static ValidatedTextField f(MultitoolPanel var0) {
      return var0.hf;
   }

   // $FF: synthetic method
   static ValidatedTextField g(MultitoolPanel var0) {
      return var0.hg;
   }

   // $FF: synthetic method
   static ValidatedTextField h(MultitoolPanel var0) {
      return var0.SpookyHash;
   }

   // $FF: synthetic method
   static InventoryPanel i(MultitoolPanel var0) {
      return var0.hi;
   }

   // $FF: synthetic method
   static JComboBox j(MultitoolPanel var0) {
      return var0.ha;
   }

   // $FF: synthetic method
   static void AboutDialog(MultitoolPanel var0, Multitool[] var1) {
      var0.hj = var1;
   }
}
