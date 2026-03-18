package nomanssave;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class CompanionsPanel extends JPanel {
   private JComboBox bG;
   private JComboBox bH;
   private ValidatedTextField bI;
   private ValidatedTextField bJ;
   private ValidatedTextField bK;
   private ValidatedTextField bL;
   private ValidatedTextField bM;
   private JCheckBox bN;
   private cN InventoryPanel;
   private cN bP;
   private JButton bQ;
   private JButton bR;
   private JButton InventorySlotPanel;
   private Companion[] bT;

   CompanionsPanel(Application var1) {
      GridLayout var2 = new GridLayout(1, 3);
      this.setLayout(var2);
      FormPanel var3 = new FormPanel(new int[]{AppSettings.cJ, 0});
      this.add(var3);
      this.add(new JPanel());
      this.add(new JPanel());
      this.bG = new JComboBox();
      this.bG.setModel(new Y(this));
      var3.AboutDialog("Companion", true, this.bG);
      this.bH = new JComboBox();
      this.bH.setModel(new ab(this));
      this.bH.setEnabled(false);
      var3.AboutDialog("Type", (JComponent)this.bH);
      this.bI = new ac(this);
      var3.AboutDialog("Name", (JComponent)this.bI);
      this.bJ = new ad(this);
      var3.AboutDialog("Creature Seed", this.bJ);
      this.bK = new ae(this);
      var3.AboutDialog("Secondary Seed", (JComponent)this.bK);
      this.bL = new af(this);
      var3.AboutDialog("Species Seed", (JComponent)this.bL);
      this.bM = new ag(this);
      var3.AboutDialog("Genus Seed", (JComponent)this.bM);
      this.bN = new JCheckBox("Predator");
      this.bN.setEnabled(false);
      this.bN.addActionListener(new ah(this));
      var3.AboutDialog((String)null, (JComponent)this.bN);
      this.InventoryPanel = new cN(gi.class);
      this.InventoryPanel.AboutDialog((var1x) -> {
         Companion var2 = (Companion)this.bG.getSelectedItem();
         if (var2 != null) {
            var2.ae(var1x);
         }

      });
      var3.AboutDialog("Biome", (JComponent)this.InventoryPanel);
      this.bP = new cN(CompanionGenus.class);
      this.bP.AboutDialog((var1x) -> {
         Companion var2 = (Companion)this.bG.getSelectedItem();
         if (var2 != null) {
            var2.af(var1x);
         }

      });
      var3.AboutDialog("Type", (JComponent)this.bP);
      var3.Y();
      JPanel var4 = new JPanel();
      this.bQ = new JButton("Delete");
      this.bQ.addActionListener(new ai(this, var1));
      var4.add(this.bQ);
      this.bR = new JButton("Export");
      this.bR.addActionListener(new Z(this, var1));
      var4.add(this.bR);
      this.InventorySlotPanel = new JButton("Import");
      this.InventorySlotPanel.addActionListener(new aa(this, var1));
      var4.add(this.InventorySlotPanel);
      var3.AboutDialog(var4);
   }

   void AboutDialog(Companion[] var1) {
      this.bT = var1;
      if (var1.length == 0) {
         this.bG.setSelectedIndex(-1);
      } else {
         this.bG.setSelectedIndex(0);
      }

      this.bG.updateUI();
   }

   // $FF: synthetic method
   static Companion[] AboutDialog(CompanionsPanel var0) {
      return var0.bT;
   }

   // $FF: synthetic method
   static JComboBox AboutDialogCloseListener(CompanionsPanel var0) {
      return var0.bH;
   }

   // $FF: synthetic method
   static ValidatedTextField AccountPanel(CompanionsPanel var0) {
      return var0.bI;
   }

   // $FF: synthetic method
   static ValidatedTextField d(CompanionsPanel var0) {
      return var0.bJ;
   }

   // $FF: synthetic method
   static ValidatedTextField e(CompanionsPanel var0) {
      return var0.bK;
   }

   // $FF: synthetic method
   static ValidatedTextField f(CompanionsPanel var0) {
      return var0.bL;
   }

   // $FF: synthetic method
   static ValidatedTextField g(CompanionsPanel var0) {
      return var0.bM;
   }

   // $FF: synthetic method
   static JCheckBox h(CompanionsPanel var0) {
      return var0.bN;
   }

   // $FF: synthetic method
   static cN i(CompanionsPanel var0) {
      return var0.InventoryPanel;
   }

   // $FF: synthetic method
   static cN j(CompanionsPanel var0) {
      return var0.bP;
   }

   // $FF: synthetic method
   static JComboBox k(CompanionsPanel var0) {
      return var0.bG;
   }

   // $FF: synthetic method
   static void AboutDialog(CompanionsPanel var0, Companion[] var1) {
      var0.bT = var1;
   }
}
