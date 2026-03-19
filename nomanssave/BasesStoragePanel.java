package nomanssave;

import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BasesStoragePanel extends SplitFormPanel {
   private JComboBox bh = new JComboBox();
   private JTextField bi;
   private ValidatedTextField bj;
   private JComboBox bk;
   private ValidatedTextField FrigatesPanel;
   private JTextField bm;
   private JButton bn;
   private JButton bo;
   private JButton bp;
   private InventoryPanel bq;
   private Settlement br;

   BasesStoragePanel(Application var1) {
      this.bh.setModel(new J(this));
      this.AboutDialog("Base NPC", true, this.bh);
      this.bi = new JTextField();
      this.bi.setEnabled(false);
      this.AboutDialog("Race", this.bi);
      this.bj = new K(this);
      this.bj.setEnabled(false);
      this.AboutDialog("Seed", this.bj);
      this.Y();
      this.bk = new JComboBox();
      this.bk.setModel(new L(this));
      this.AboutDialog("Base Info", true, this.bk);
      this.FrigatesPanel = new M(this);
      this.AboutDialog("Name", this.FrigatesPanel);
      this.bm = new JTextField();
      this.bm.setEnabled(false);
      this.AboutDialog("Items", this.bm);
      JPanel var2 = new JPanel();
      this.bn = new JButton("Backup");
      this.bn.addActionListener(new N(this, var1));
      var2.add(this.bn);
      this.bo = new JButton("Restore");
      this.bo.addActionListener(new O(this, var1));
      var2.add(this.bo);
      this.bp = new JButton("Move Base Computer");
      this.bp.addActionListener(new P(this, var1));
      var2.add(this.bp);
      this.AboutDialog((JComponent)var2);
      this.bq = new InventoryPanel(var1);
      this.AboutDialogCloseListener(this.bq);
   }

   void AppStartupRunnable() {
      this.bq.AppStartupRunnable();
   }

   void UpdateCheckThread() {
      this.bq.UpdateCheckThread();
   }

   void UpdateDownloadRunnable() {
      this.bq.UpdateDownloadRunnable();
   }

   void ShowWarningRunnable() {
      this.bq.ShowWarningRunnable();
   }

   void updateInventory(Inventory var1) {
      this.bq.updateInventory(var1);
   }

   Settlement O() {
      return this.br;
   }

   void updateSettlement(Settlement var1) {
      this.br = var1;
      List var2;
      if (var1 == null) {
         var2 = Collections.emptyList();
         this.bh.setSelectedIndex(-1);
         this.bk.setSelectedIndex(-1);
      } else {
         var2 = var1.cC();
         this.bh.setSelectedIndex(var1.cD().size() == 0 ? -1 : 0);
         this.bk.setSelectedIndex(var1.cE().size() == 0 ? -1 : 0);
      }

      this.bh.updateUI();
      this.bk.updateUI();
      this.bq.updateInventory(var2);
   }

   // $FF: synthetic method
   static Settlement access$getSettlement(BasesStoragePanel var0) {
      return var0.br;
   }

   // $FF: synthetic method
   static JTextField access$getNameField(BasesStoragePanel var0) {
      return var0.bi;
   }

   // $FF: synthetic method
   static ValidatedTextField access$getStorageField(BasesStoragePanel var0) {
      return var0.bj;
   }

   // $FF: synthetic method
   static JComboBox d(BasesStoragePanel var0) {
      return var0.bh;
   }

   // $FF: synthetic method
   static JTextField e(BasesStoragePanel var0) {
      return var0.bm;
   }

   // $FF: synthetic method
   static ValidatedTextField f(BasesStoragePanel var0) {
      return var0.FrigatesPanel;
   }

   // $FF: synthetic method
   static JButton g(BasesStoragePanel var0) {
      return var0.bn;
   }

   // $FF: synthetic method
   static JButton h(BasesStoragePanel var0) {
      return var0.bo;
   }

   // $FF: synthetic method
   static JButton i(BasesStoragePanel var0) {
      return var0.bp;
   }

   // $FF: synthetic method
   static JComboBox j(BasesStoragePanel var0) {
      return var0.bk;
   }
}
