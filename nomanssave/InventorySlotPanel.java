package nomanssave;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.border.Border;

class InventorySlotPanel extends JPanel {
   private final int slotRow;
   private final int slotCol;
   private JCheckBoxMenuItem enabledMenuItem;
   private JMenuItem eZ;
   private JMenuItem fa;
   private JMenuItem fb;
   private JCheckBoxMenuItem fc;
   private JMenuItem fd;
   private JMenuItem itemDetailsMenuItem;
   private JMenuItem addItemMenuItem;
   private JMenuItem fg;
   private JMenuItem moveItemMenuItem;
   private JMenuItem fi;
   private JMenuItem JsonWriter;
   // $FF: synthetic field
   final InventoryPanel JsonParseException;

   private InventorySlotPanel(InventoryPanel var1, int var2, int var3) {
      this.JsonParseException = var1;
      this.slotRow = var2;
      this.slotCol = var3;
      this.setLayout(new GridBagLayout());
      JPopupMenu var4 = new JPopupMenu();
      this.enabledMenuItem = new JCheckBoxMenuItem("Enabled");
      this.enabledMenuItem.addActionListener(new bT(this, var2, var3));
      this.enabledMenuItem.setEnabled(InventoryPanel.AboutDialog(var1).dp() || en.aS());
      var4.add(this.enabledMenuItem);
      this.eZ = new JMenuItem("Enable All Slots");
      this.eZ.addActionListener(new bY(this));
      this.eZ.setEnabled(InventoryPanel.AboutDialog(var1).dp() || en.aS());
      var4.add(this.eZ);
      this.fa = new JMenuItem("Repair Slot");
      this.fa.addActionListener(new bZ(this, var2, var3));
      this.fa.setVisible(InventoryPanel.AboutDialog(var1).dq());
      var4.add(this.fa);
      this.fb = new JMenuItem("Repair All Slots");
      this.fb.addActionListener(new ca(this));
      this.fb.setVisible(InventoryPanel.AboutDialog(var1).dq());
      var4.add(this.fb);
      this.fc = new JCheckBoxMenuItem("Supercharged");
      this.fc.addActionListener(new cb(this, var2, var3));
      this.fc.setVisible(InventoryPanel.AboutDialog(var1).do());
      var4.add(this.fc);
      this.fd = new JMenuItem("Supercharge All Slots");
      this.fd.addActionListener(new cc(this));
      this.fd.setVisible(InventoryPanel.AboutDialog(var1).do());
      var4.add(this.fd);
      var4.addSeparator();
      this.itemDetailsMenuItem = new JMenuItem("Item Details");
      this.itemDetailsMenuItem.addActionListener(new cd(this, var2, var3));
      var4.add(this.itemDetailsMenuItem);
      this.addItemMenuItem = new JMenuItem("Add Item");
      this.addItemMenuItem.addActionListener(new ce(this, var2, var3));
      var4.add(this.addItemMenuItem);
      this.fg = new JMenuItem("Repair Item");
      this.fg.addActionListener(new cf(this, var2, var3));
      var4.add(this.fg);
      this.moveItemMenuItem = new JMenuItem("Move Item");
      this.moveItemMenuItem.addActionListener(new bU(this, var2, var3));
      var4.add(this.moveItemMenuItem);
      this.fi = new JMenuItem("Fill Stack");
      this.fi.addActionListener(new bV(this, var2, var3));
      var4.add(this.fi);
      this.JsonWriter = new JMenuItem("Delete Item");
      this.JsonWriter.addActionListener(new bW(this, var2, var3));
      var4.add(this.JsonWriter);
      this.setComponentPopupMenu(var4);
      this.setBorder(InventoryPanel.eP);
      this.addMouseListener(new bX(this, var2, var3));
      this.aq();
   }

   private boolean ao() {
      return InventoryPanel.AboutDialog(this.JsonParseException).h(this.slotRow, this.slotCol);
   }

   private boolean DiscoveryPanel() {
      return InventoryPanel.AboutDialog(this.JsonParseException).l(this.slotRow, this.slotCol);
   }

   private void aq() {
      this.removeAll();
      this.enabledMenuItem.setEnabled(InventoryPanel.AboutDialog(this.JsonParseException).dp() || en.aS());
      this.eZ.setEnabled(InventoryPanel.AboutDialog(this.JsonParseException).dp() || en.aS());
      this.fa.setVisible(InventoryPanel.AboutDialog(this.JsonParseException).dq());
      this.fb.setVisible(InventoryPanel.AboutDialog(this.JsonParseException).dq());
      if (!InventoryPanel.AboutDialog(this.JsonParseException).h(this.slotRow, this.slotCol)) {
         this.enabledMenuItem.setSelected(false);
         this.fa.setEnabled(false);
         this.itemDetailsMenuItem.setVisible(false);
         this.fg.setVisible(false);
         this.addItemMenuItem.setVisible(true);
         this.addItemMenuItem.setEnabled(false);
         this.moveItemMenuItem.setVisible(false);
         this.fi.setVisible(false);
         this.JsonWriter.setVisible(false);
         this.fc.setVisible(false);
         this.setBorder(InventoryPanel.eP);
         this.setBackground(InventoryPanel.ag());
         this.setToolTipText((String)null);
      } else {
         gu var1;
         ItemDefinition var2;
         boolean var3;
         String var4;
         if (InventoryPanel.AboutDialog(this.JsonParseException).l(this.slotRow, this.slotCol)) {
            this.enabledMenuItem.setSelected(true);
            this.fa.setEnabled(true);
            this.itemDetailsMenuItem.setVisible(false);
            this.fg.setVisible(false);
            this.addItemMenuItem.setVisible(true);
            this.addItemMenuItem.setEnabled(false);
            this.moveItemMenuItem.setVisible(false);
            this.fi.setVisible(false);
            this.JsonWriter.setVisible(false);
            this.fc.setVisible(InventoryPanel.AboutDialog(this.JsonParseException).do());
            if (InventoryPanel.AboutDialog(this.JsonParseException).k(this.slotRow, this.slotCol)) {
               this.setBorder(InventoryPanel.ah());
               this.fc.setState(true);
            } else {
               this.setBorder(InventoryPanel.eP);
               this.fc.setState(false);
            }

            this.setBackground(InventoryPanel.ai());
            var1 = InventoryPanel.AboutDialog(this.JsonParseException).f(this.slotRow, this.slotCol);
            if (var1 == null) {
               this.setToolTipText((String)null);
            } else {
               var2 = ItemDefinition.d(var1.dz());
               var3 = var2 instanceof eQ && var1.dC() != 0.0D;
               var4 = var2 == null ? InventoryPanel.AboutDialogCloseListener(var1.dz()) : var2.getName();
               int var5 = UIManager.getInt("Inventory.iconSize");
               ImageIcon var6 = var2 == null ? null : var2.AccountPanel(var5, var5);
               int var7 = 0;
               if (var6 != null) {
                  this.paintIcon(var6, var5, var7++);
               }

               Color var8 = var3 ? InventoryPanel.aj() : InventoryPanel.eO;
               this.paintText(var4, var7++, var8);
               this.paintText(var1.dA() < 0 ? "" : var1.dA() + "/" + var1.dB(), var7++, var8);
               this.setToolTipText(var4);
            }
         } else {
            this.enabledMenuItem.setSelected(true);
            this.fa.setEnabled(false);
            this.fc.setVisible(InventoryPanel.AboutDialog(this.JsonParseException).do());
            if (InventoryPanel.AboutDialog(this.JsonParseException).k(this.slotRow, this.slotCol)) {
               this.setBorder(InventoryPanel.ah());
               this.fc.setState(true);
            } else {
               this.setBorder(InventoryPanel.eP);
               this.fc.setState(false);
            }

            var1 = InventoryPanel.AboutDialog(this.JsonParseException).f(this.slotRow, this.slotCol);
            if (var1 == null) {
               this.itemDetailsMenuItem.setVisible(false);
               this.fg.setVisible(false);
               this.addItemMenuItem.setVisible(true);
               this.addItemMenuItem.setEnabled(true);
               this.moveItemMenuItem.setVisible(false);
               this.fi.setVisible(false);
               this.JsonWriter.setVisible(false);
               this.setBackground(InventoryPanel.eK);
               this.setToolTipText((String)null);
            } else {
               var2 = ItemDefinition.d(var1.dz());
               var3 = var2 instanceof eQ && var1.dC() != 0.0D;
               this.itemDetailsMenuItem.setVisible(true);
               this.fg.setVisible(var3);
               this.addItemMenuItem.setVisible(false);
               this.addItemMenuItem.setEnabled(false);
               this.moveItemMenuItem.setVisible(true);
               this.fi.setVisible(false);
               this.JsonWriter.setVisible(true);
               var4 = var1.getType();
               if (var4.equals("Technology")) {
                  this.setBackground(InventoryPanel.ak());
                  if (var1.dA() >= 0 && var1.dA() < var1.dB()) {
                     this.fi.setText("Recharge");
                     this.fi.setVisible(true);
                  }
               } else if (var4.equals("Product")) {
                  this.setBackground(InventoryPanel.al());
                  if (var1.dB() > 1) {
                     this.fi.setText("Fill Stack");
                     this.fi.setVisible(true);
                  }
               } else if (var4.equals("Substance")) {
                  this.setBackground(InventoryPanel.am());
                  if (var1.dB() > 1) {
                     this.fi.setText("Fill Stack");
                     this.fi.setVisible(true);
                  }
               } else {
                  this.setBackground(InventoryPanel.an());
               }

               this.itemDetailsMenuItem.setEnabled(var2 != null);
               String var10 = var2 == null ? InventoryPanel.AboutDialogCloseListener(var1.dz()) : var2.getName();
               int var11 = UIManager.getInt("Inventory.iconSize");
               ImageIcon var13 = var2 == null ? null : var2.AccountPanel(var11, var11);
               int var12 = 0;
               if (var13 != null) {
                  this.paintIcon(var13, var11, var12++);
               }

               Color var9 = var3 ? InventoryPanel.aj() : InventoryPanel.eO;
               this.paintText(var10, var12++, var9);
               this.paintText(var1.dA() < 0 ? " " : var1.dA() + "/" + var1.dB(), var12++, var9);
               this.setToolTipText(var10);
            }
         }
      }

      this.revalidate();
      this.updateUI();
   }

   private void paintIcon(ImageIcon var1, int var2, int var3) {
      JLabel var4 = new JLabel(var1);
      var4.setPreferredSize(new Dimension(var2, var2));
      GridBagConstraints var5 = new GridBagConstraints();
      var5.anchor = 10;
      var5.fill = 0;
      var5.insets = new Insets(5, 0, 5, 0);
      var5.gridx = 0;
      var5.gridy = var3;
      this.add(var4, var5);
   }

   private void paintText(String var1, int var2, Color var3) {
      JLabel var4 = new JLabel();
      var4.setFont(UIManager.getFont("Inventory.font"));
      var4.setBackground((Color)null);
      var4.setBorder((Border)null);
      var4.setText(var1);
      var4.setForeground(var3);
      GridBagConstraints var5 = new GridBagConstraints();
      var5.anchor = 10;
      var5.fill = 0;
      int var6 = UIManager.getInt("Inventory.iconSize");
      var5.insets = new Insets(var2 == 0 ? var6 + 10 : 0, 0, 0, 0);
      var5.gridx = 0;
      var5.gridy = var2;
      this.add(var4, var5);
   }

   // $FF: synthetic method
   static JCheckBoxMenuItem access$getEnabledMenuItem(InventorySlotPanel var0) {
      return var0.enabledMenuItem;
   }

   // $FF: synthetic method
   static void access$repaint(InventorySlotPanel var0) {
      var0.aq();
   }

   // $FF: synthetic method
   static JCheckBoxMenuItem d(InventorySlotPanel var0) {
      return var0.fc;
   }

   // $FF: synthetic method
   static boolean e(InventorySlotPanel var0) {
      return var0.ao();
   }

   // $FF: synthetic method
   static boolean f(InventorySlotPanel var0) {
      return var0.DiscoveryPanel();
   }

   // $FF: synthetic method
   static JMenuItem g(InventorySlotPanel var0) {
      return var0.eZ;
   }

   // $FF: synthetic method
   InventorySlotPanel(InventoryPanel var1, int var2, int var3, InventorySlotPanel var4) {
      this(var1, var2, var3);
   }

   // $FF: synthetic method
   static int h(InventorySlotPanel var0) {
      return var0.slotRow;
   }

   // $FF: synthetic method
   static int i(InventorySlotPanel var0) {
      return var0.slotCol;
   }

   // $FF: synthetic method
   static InventoryPanel j(InventorySlotPanel var0) {
      return var0.JsonParseException;
   }
}
