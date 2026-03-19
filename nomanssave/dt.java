package nomanssave;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class dt extends FormPanel {
   private final Application eR;
   private final JPanel AlienWord;

   dt(Application var1) {
      super(AppSettings.cJ, 0);
      this.eR = var1;
      this.k("Production");
      this.AlienWord = new JPanel();
      this.AlienWord.setLayout(new GridBagLayout());
      this.addField((JComponent)this.AlienWord);
      UIManager.addPropertyChangeListener((var1x) -> {
         if ("lookAndFeel".equals(var1x.getPropertyName())) {
            EventQueue.invokeLater(this::aL);
         }

      });
   }

   private void aL() {
      synchronized(this.AlienWord.getTreeLock()) {
         Component[] var5;
         int var4 = (var5 = this.AlienWord.getComponents()).length;
         int var3 = 0;

         while(true) {
            if (var3 >= var4) {
               break;
            }

            Component var2 = var5[var3];
            du var6 = (du)var2;
            du.access$refreshUI(var6);
            ++var3;
         }
      }

      this.AlienWord.revalidate();
      this.AlienWord.updateUI();
   }

   public void updateAlienWords(gF[] var1) {
      synchronized(this.AlienWord.getTreeLock()) {
         this.AlienWord.removeAll();
         int var3 = 0;

         while(true) {
            if (var3 >= var1.length) {
               break;
            }

            du var4 = new du(this, var1[var3], (du)null);
            GridBagConstraints var5 = new GridBagConstraints();
            var5.fill = 1;
            var5.insets = new Insets(10, 10, 10, 10);
            var5.gridx = var3 % 3;
            var5.gridy = var3 / 3;
            this.AlienWord.add(var4, var5);
            ++var3;
         }
      }

      this.AlienWord.revalidate();
      this.AlienWord.updateUI();
   }

   private void pickItemForSlot(du var1) {
      ItemDefinition var2 = h.show(this, 28160);
      if (var2 != null) {
         var1.hm.m(var2.aZ());
         var1.hm.aA(0);
         du.access$refreshUI(var1);
      }

   }

   private void moveItemToInventory(du var1) {
      ItemDefinition var2 = ItemDefinition.d(var1.hm.dz());
      if (var2 == null) {
         this.eR.AccountPanel("Item details not found!");
      } else {
         List var3 = this.eR.g(3584);
         int var4 = dd.show(this, var3, -1);
         if (var4 != -1) {
            Inventory var5 = (Inventory)var3.get(var4);
            int var6 = var1.hm.dA();
            ItemDefinition var7 = ItemDefinition.d(var1.hm.dz());
            var6 = var5.AboutDialog(var7, var6);
            var1.hm.aA(var6);
            du.access$refreshUI(var1);
            this.eR.AboutDialog(var5);
         }

      }
   }

   // $FF: synthetic method
   static void access$pickItem(dt var0, du var1) {
      var0.pickItemForSlot(var1);
   }

   // $FF: synthetic method
   static void access$moveItem(dt var0, du var1) {
      var0.moveItemToInventory(var1);
   }
}
