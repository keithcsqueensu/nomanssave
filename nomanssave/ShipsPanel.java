package nomanssave;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ShipsPanel extends SplitFormPanel {
   private static final int cV = 500;
   private static final int LineNumberPanel = 200;
   private static final double gX = 1000.0D;
   private static final double hI = 1000.0D;
   private static final double SettlementsPanel = 1000.0D;
   private static final double hJ = 1000.0D;
   private JComboBox hK = new JComboBox();
   private ValidatedTextField hL;
   private cN hM;
   private cN hN;
   private ValidatedTextField hO;
   private JCheckBox hP;
   private JButton bQ;
   private JButton bR;
   private JButton InventorySlotPanel;
   private ValidatedTextField hQ;
   private ValidatedTextField hR;
   private ValidatedTextField hS;
   private ValidatedTextField hT;
   private ValidatedTextField hU;
   private ValidatedTextField hV;
   private InventoryPanel hW;
   private Starship[] hX;
   private ShipSettings hY;

   ShipsPanel(Application var1) {
      this.hK.setModel(new dO(this, var1));
      this.AboutDialog("Ship", true, this.hK);
      this.hL = new dT(this);
      this.AboutDialog((String)"Name", (JComponent)this.hL);
      this.hM = new cN(ShipType.class);
      this.hM.AboutDialog((var2x) -> {
         Starship var3 = (Starship)this.hK.getModel().getSelectedItem();
         if (var3 != null) {
            ShipType var4 = ShipType.aw(var2x);
            int var5 = JOptionPane.showConfirmDialog(var1.g(), "You are about to change a ship type to " + (var4 == null ? "Unknown" : var4.toString()) + ". Are you sure?\nNOTE: Any incompatible technology installed on the ship will be deleted.", "Change Ship Type", 0);
            if (var5 != 0) {
               this.hM.m(var3.cT());
               return;
            }

            var3.ag(var2x);
            this.hW.updateInventory(var3.cC());
            this.hK.updateUI();
         }

      });
      this.AboutDialog((String)"Type", (JComponent)this.hM);
      this.hN = new cN(ShipClass.class);
      this.hN.AboutDialog((var1x) -> {
         Starship var2 = (Starship)this.hK.getModel().getSelectedItem();
         if (var2 != null) {
            var2.aj(var1x);
         }

      });
      this.AboutDialog((String)"Class", (JComponent)this.hN);
      this.hO = new dU(this);
      this.AboutDialog((String)"Seed", (ValidatedTextField)this.hO);
      this.hP = new JCheckBox("Use Old Colours");
      this.hP.setEnabled(false);
      this.hP.addActionListener(new dV(this, var1));
      this.AboutDialog((String)null, (JComponent)this.hP);
      this.k("Base Stats");
      this.hQ = new dW(this);
      this.AboutDialog((String)"Health", (JComponent)this.hQ);
      this.hR = new dX(this);
      this.AboutDialog((String)"Shield", (JComponent)this.hR);
      this.hS = new dY(this);
      this.AboutDialog((String)"Damage", (JComponent)this.hS);
      this.hT = new dZ(this);
      this.AboutDialog((String)"Shields", (JComponent)this.hT);
      this.hU = new ea(this);
      this.AboutDialog((String)"Hyperdrive", (JComponent)this.hU);
      this.hV = new dP(this);
      this.AboutDialog((String)"Maneuverability", (JComponent)this.hV);
      this.Y();
      JPanel var2 = new JPanel();
      this.bQ = new JButton("Delete Ship");
      this.bQ.addActionListener(new dQ(this, var1));
      var2.add(this.bQ);
      this.bR = new JButton("Export");
      this.bR.addActionListener(new dR(this, var1));
      var2.add(this.bR);
      this.InventorySlotPanel = new JButton("Import");
      this.InventorySlotPanel.addActionListener(new dS(this, var1));
      var2.add(this.InventorySlotPanel);
      this.AboutDialog((JComponent)var2);
      this.hW = new InventoryPanel(var1);
      this.AboutDialogCloseListener(this.hW);
   }

   void AppStartupRunnable() {
      for(int var1 = 0; var1 < this.hX.length; ++var1) {
         this.hX[var1].cC().stream().forEach((var1x) -> {
            if (var1x.dt()) {
               Logger.info(var1x + ": technology recharged");
            }

            this.hW.updateInventory(var1x);
         });
      }

   }

   void UpdateCheckThread() {
      for(int var1 = 0; var1 < this.hX.length; ++var1) {
         this.hX[var1].cC().stream().forEach((var1x) -> {
            if (var1x.du()) {
               Logger.info(var1x + ": items refilled");
            }

            this.hW.updateInventory(var1x);
         });
      }

   }

   void UpdateDownloadRunnable() {
      for(int var1 = 0; var1 < this.hX.length; ++var1) {
         this.hX[var1].cC().stream().forEach((var1x) -> {
            if (var1x.dv()) {
               Logger.info(var1x + ": all slots enabled");
            }

            this.hW.updateInventory(var1x);
         });
      }

   }

   void ShowErrorRunnable() {
      for(int var1 = 0; var1 < this.hX.length; ++var1) {
         this.hX[var1].cC().stream().forEach((var1x) -> {
            if (var1x.ds()) {
               Logger.info(var1x + ": all slots repaired");
            }

            this.hW.updateInventory(var1x);
         });
      }

   }

   void ShowWarningRunnable() {
      for(int var1 = 0; var1 < this.hX.length; ++var1) {
         this.hX[var1].cC().stream().forEach((var1x) -> {
            if (var1x.dl()) {
               Logger.info(var1x + ": inventory expanded");
            }

            this.hW.updateInventory(var1x);
         });
      }

   }

   void updateInventory(Inventory var1) {
      this.hW.updateInventory(var1);
   }

   Starship[] aO() {
      return this.hX;
   }

   void updateShips(Starship[] var1, ShipSettings var2) {
      this.hX = var1;
      this.hY = var2;
      if (var1.length == 0) {
         this.hK.setSelectedIndex(-1);
      } else {
         int var3 = var2 == null ? 0 : var2.dV();
         if (var3 >= var1.length) {
            var3 = 0;
         }

         this.hK.setSelectedIndex(var3);
      }

      if (var2 == null) {
         this.hQ.setText("");
         this.hR.setText("");
      } else {
         this.hQ.setText(Long.toString((long)var2.dM()));
         this.hR.setText(Long.toString((long)var2.ShipsPanel()));
      }

      this.hK.updateUI();
   }

   // $FF: synthetic method
   static Starship[] access$getShips(ShipsPanel var0) {
      return var0.hX;
   }

   // $FF: synthetic method
   static ValidatedTextField access$getNameField(ShipsPanel var0) {
      return var0.hL;
   }

   // $FF: synthetic method
   static cN access$getTypeComboBox(ShipsPanel var0) {
      return var0.hM;
   }

   // $FF: synthetic method
   static cN d(ShipsPanel var0) {
      return var0.hN;
   }

   // $FF: synthetic method
   static ValidatedTextField e(ShipsPanel var0) {
      return var0.hO;
   }

   // $FF: synthetic method
   static JCheckBox f(ShipsPanel var0) {
      return var0.hP;
   }

   // $FF: synthetic method
   static JButton g(ShipsPanel var0) {
      return var0.bQ;
   }

   // $FF: synthetic method
   static ValidatedTextField h(ShipsPanel var0) {
      return var0.hS;
   }

   // $FF: synthetic method
   static ValidatedTextField i(ShipsPanel var0) {
      return var0.hT;
   }

   // $FF: synthetic method
   static ValidatedTextField j(ShipsPanel var0) {
      return var0.hU;
   }

   // $FF: synthetic method
   static ValidatedTextField k(ShipsPanel var0) {
      return var0.hV;
   }

   // $FF: synthetic method
   static InventoryPanel l(ShipsPanel var0) {
      return var0.hW;
   }

   // $FF: synthetic method
   static ValidatedTextField m(ShipsPanel var0) {
      return var0.hQ;
   }

   // $FF: synthetic method
   static ValidatedTextField n(ShipsPanel var0) {
      return var0.hR;
   }

   // $FF: synthetic method
   static ShipSettings o(ShipsPanel var0) {
      return var0.hY;
   }

   // $FF: synthetic method
   static JComboBox p(ShipsPanel var0) {
      return var0.hK;
   }

   // $FF: synthetic method
   static void access$setShips(ShipsPanel var0, Starship[] var1) {
      var0.hX = var1;
   }
}
