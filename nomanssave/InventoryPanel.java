package nomanssave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class InventoryPanel extends JPanel implements eo {
   private static final Color eE;
   private static final Color eF;
   private static final Color eG;
   private static final Color eH;
   private static final Color eI;
   private static final Color eJ;
   public static final Color eK;
   private static final Color eL;
   private static final Color eM;
   private static final Color eN;
   public static final Color eO;
   public static final Border eP;
   private static final Border eQ;
   private final Application eR;
   private final JPanel slotsPanel;
   private final JComboBox eT;
   private final JButton Race;
   private List slotPanelList;
   private Inventory eW;

   static {
      eE = Color.GRAY;
      eF = new Color(255, 240, 240);
      eG = new Color(255, 255, 240);
      eH = new Color(240, 255, 250);
      eI = new Color(240, 250, 255);
      eJ = new Color(240, 255, 255);
      eK = Color.WHITE;
      eL = Color.BLACK;
      eM = Color.YELLOW;
      eN = Color.RED;
      eO = Color.BLACK;
      eP = BorderFactory.createLineBorder(eL, 1);
      eQ = BorderFactory.createCompoundBorder(eP, BorderFactory.createLineBorder(eM, 2));
   }

   InventoryPanel(Application var1) {
      this.eR = var1;
      this.setLayout(new BorderLayout());
      JPanel var2 = new JPanel();
      var2.setLayout(new FlowLayout());
      this.slotsPanel = new JPanel();
      this.slotsPanel.setLayout(new GridBagLayout());
      int var3 = UIManager.getInt("Inventory.gridSize");
      this.setPreferredSize(new Dimension(var3 * 10 + 20, var3 * 8 + 50));
      this.add(var2, "North");
      JScrollPane var4 = new JScrollPane();
      var4.setViewportView(this.slotsPanel);
      var4.setBorder(new LineBorder(eL));
      this.add(var4, "Center");
      this.slotPanelList = Collections.emptyList();
      this.eT = new JComboBox();
      this.eT.setVisible(false);
      this.eT.setModel(new bP(this));
      this.eT.setRenderer(new bQ(this));
      var2.add(this.eT);
      this.Race = new JButton("Resize Inventory");
      this.Race.setVisible(false);
      this.Race.addActionListener(new bR(this));
      var2.add(this.Race);
      en.AboutDialog(this);
      UIManager.addPropertyChangeListener((var1x) -> {
         if ("lookAndFeel".equals(var1x.getPropertyName())) {
            EventQueue.invokeLater(this::af);
         }

      });
   }

   public void AboutDialog(boolean var1) {
      this.Race.setVisible(this.eW == null ? false : var1 || this.eW.dk());
      boolean var2 = this.eW == null ? false : var1 || this.eW.dp();
      synchronized(this.slotsPanel.getTreeLock()) {
         for(int var4 = 0; var4 < this.slotsPanel.getComponentCount(); ++var4) {
            Component var5 = this.slotsPanel.getComponent(var4);
            if (var5 instanceof InventorySlotPanel) {
               InventorySlotPanel var6 = (InventorySlotPanel)var5;
               InventorySlotPanel.AboutDialogCloseListener(var6).setEnabled(var2);
               InventorySlotPanel.g(var6).setEnabled(var2);
            }
         }

      }
   }

   void AboutDialog(Inventory var1) {
      if (this.eW == var1) {
         this.af();
      }

   }

   void AppStartupRunnable() {
      this.slotPanelList.stream().forEach((var1) -> {
         if (var1.dt() && this.eW == var1) {
            this.af();
         }

      });
   }

   void UpdateCheckThread() {
      this.slotPanelList.stream().forEach((var1) -> {
         if (var1.du() && this.eW == var1) {
            this.af();
         }

      });
   }

   void UpdateDownloadRunnable() {
      this.slotPanelList.stream().forEach((var1) -> {
         if (var1.dp() && var1.dv() && this.eW == var1) {
            this.af();
         }

      });
   }

   void ShowErrorRunnable() {
      this.slotPanelList.stream().forEach((var1) -> {
         if (var1.dq() && var1.ds() && this.eW == var1) {
            this.af();
         }

      });
   }

   void ShowWarningRunnable() {
      this.slotPanelList.stream().forEach((var1) -> {
         if (var1.dk() && var1.dl() && this.eW == var1) {
            this.af();
         }

      });
   }

   void ae() {
      int var1 = this.eT.getSelectedIndex();
      if (var1 >= 0) {
         this.eW = (Inventory)this.slotPanelList.get(var1);
         this.af();
      }

   }

   private void af() {
      synchronized(this.slotsPanel.getTreeLock()) {
         this.slotsPanel.removeAll();
         if (this.eW != null) {
            int var2 = UIManager.getInt("Inventory.gridSize");
            Dimension var3 = new Dimension(var2, var2);

            for(int var4 = 0; var4 < this.eW.getHeight(); ++var4) {
               for(int var5 = 0; var5 < this.eW.getWidth(); ++var5) {
                  InventorySlotPanel var6 = new InventorySlotPanel(this, var5, var4, (InventorySlotPanel)null);
                  var6.setMinimumSize(var3);
                  var6.setMaximumSize(var3);
                  var6.setPreferredSize(var3);
                  GridBagConstraints var7 = new GridBagConstraints();
                  var7.fill = 1;
                  var7.insets = new Insets(-1, -1, 0, 0);
                  var7.gridx = var5;
                  var7.gridy = var4;
                  this.slotsPanel.add(var6, var7);
               }
            }
         }
      }

      this.slotsPanel.revalidate();
      this.slotsPanel.updateUI();
   }

   void AboutDialog(List var1) {
      this.slotPanelList = var1;
      this.eW = null;
      this.eT.updateUI();
      if (this.slotPanelList.size() == 0) {
         this.eT.setVisible(false);
         this.Race.setVisible(false);
         this.af();
      } else {
         this.eT.setVisible(this.slotPanelList.size() != 1);
         this.Race.setVisible(false);
         this.eT.setSelectedIndex(0);
      }

   }

   private InventorySlotPanel AboutDialog(int var1, int var2) {
      synchronized(this.slotsPanel.getTreeLock()) {
         for(int var4 = 0; var4 < this.slotsPanel.getComponentCount(); ++var4) {
            Component var5 = this.slotsPanel.getComponent(var4);
            if (var5 instanceof InventorySlotPanel) {
               InventorySlotPanel var6 = (InventorySlotPanel)var5;
               if (InventorySlotPanel.h(var6) == var1 && InventorySlotPanel.i(var6) == var2) {
                  return var6;
               }
            }
         }

         return null;
      }
   }

   private void AboutDialog(InventorySlotPanel var1) {
      ItemDefinition var2 = h.AboutDialog(this, this.eW.MultitoolPanel());
      if (var2 != null) {
         this.eW.AboutDialog(InventorySlotPanel.h(var1), InventorySlotPanel.i(var1), var2);
         InventorySlotPanel.AccountPanel(var1);
      }

   }

   private void AboutDialog(gu var1, InventorySlotPanel var2) {
      ItemDefinition var3 = ItemDefinition.d(var1.dz());
      int var4;
      if (var3 == null) {
         if ("Product".equals(var1.getType())) {
            var4 = 512;
         } else {
            if (!"Substance".equals(var1.getType())) {
               this.eR.AccountPanel("Item details not found!");
               return;
            }

            var4 = 1024;
         }
      } else {
         var4 = Inventory.AboutDialog(var3.bc());
      }

      List var5 = this.eR.g(var4);
      int var6 = var5.indexOf(this.eW);
      int var7 = dd.AboutDialog(this, var5, var6);
      if (var7 != var6) {
         Inventory var8 = (Inventory)var5.get(var7);
         if (this.eW.AboutDialog(InventorySlotPanel.h(var2), InventorySlotPanel.i(var2), var8)) {
            InventorySlotPanel.AccountPanel(var2);
            this.eR.AboutDialog(var8);
         }
      }

   }

   private static String AboutDialog(Object var0) {
      return var0 instanceof fg ? "Archived Tech" : var0.toString();
   }

   // $FF: synthetic method
   static Inventory AboutDialog(InventoryPanel var0) {
      return var0.eW;
   }

   // $FF: synthetic method
   static Application AboutDialogCloseListener(InventoryPanel var0) {
      return var0.eR;
   }

   // $FF: synthetic method
   static void AccountPanel(InventoryPanel var0) {
      var0.af();
   }

   // $FF: synthetic method
   static void AboutDialog(InventoryPanel var0, InventorySlotPanel var1) {
      var0.AboutDialog(var1);
   }

   // $FF: synthetic method
   static void AboutDialog(InventoryPanel var0, gu var1, InventorySlotPanel var2) {
      var0.AboutDialog(var1, var2);
   }

   // $FF: synthetic method
   static InventorySlotPanel AboutDialog(InventoryPanel var0, int var1, int var2) {
      return var0.AboutDialog(var1, var2);
   }

   // $FF: synthetic method
   static Color ag() {
      return eE;
   }

   // $FF: synthetic method
   static Border ah() {
      return eQ;
   }

   // $FF: synthetic method
   static Color ai() {
      return eF;
   }

   // $FF: synthetic method
   static String AboutDialogCloseListener(Object var0) {
      return AboutDialog(var0);
   }

   // $FF: synthetic method
   static Color aj() {
      return eN;
   }

   // $FF: synthetic method
   static Color ak() {
      return eG;
   }

   // $FF: synthetic method
   static Color al() {
      return eH;
   }

   // $FF: synthetic method
   static Color am() {
      return eI;
   }

   // $FF: synthetic method
   static Color an() {
      return eJ;
   }

   // $FF: synthetic method
   static List d(InventoryPanel var0) {
      return var0.slotPanelList;
   }

   // $FF: synthetic method
   static void AboutDialog(InventoryPanel var0, Inventory var1) {
      var0.eW = var1;
   }

   // $FF: synthetic method
   static JButton e(InventoryPanel var0) {
      return var0.Race;
   }
}
