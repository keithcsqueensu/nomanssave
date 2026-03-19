package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FrigatesPanel extends JPanel implements eo {
   private static final int dQ = 50;
   private JTable dR;
   private JButton bQ;
   private JButton dS;
   private FormPanel dT;
   private ValidatedTextField dU;
   private JComboBox dV;
   private JTextField dW;
   private cN dX;
   private ValidatedTextField dY;
   private ValidatedTextField dZ;
   private ValidatedTextField[] ea;
   private FormPanel SquadronPanel;
   private JComboBox ec;
   private JComboBox ed;
   private JComboBox ee;
   private JComboBox ef;
   private JComboBox eg;
   private ValidatedTextField eh;
   private ValidatedTextField ei;
   private ValidatedTextField ej;
   private ValidatedTextField ek;
   private JLabel el;
   private JButton repairButton;
   private er[] en;
   private er[] eo;
   private Frigate[] VehiclesPanel;
   private int eq;

   FrigatesPanel(Application var1) {
      GridLayout var2 = new GridLayout(1, 3);
      this.setLayout(var2);
      JScrollPane var3 = new JScrollPane();
      var3.setMinimumSize(new Dimension(300, 0));
      var3.setMaximumSize(new Dimension(300, Integer.MAX_VALUE));
      var3.setPreferredSize(new Dimension(300, 0));
      JPanel var4 = new JPanel();
      var4.setLayout(new BorderLayout());
      var4.add(var3, "Center");
      JPanel var5 = new JPanel();
      this.bQ = new JButton("Delete");
      this.bQ.setEnabled(false);
      this.bQ.addActionListener(new bm(this, var1));
      var5.add(this.bQ);
      this.dS = new JButton("Copy");
      this.dS.setEnabled(false);
      this.dS.addActionListener(new br(this, var1));
      var5.add(this.dS);
      var4.add(var5, "South");
      this.add(var4);
      this.dR = new JTable();
      this.dR.setSelectionMode(0);
      this.dR.setModel(new bs(this));
      this.dR.getColumnModel().getColumn(2).setMaxWidth(60);
      this.dR.getSelectionModel().addListSelectionListener(new bt(this, var1));
      var3.setViewportView(this.dR);
      this.dT = new FormPanel(new int[]{AppSettings.cJ, 0});
      this.dT.setVisible(false);
      this.add(this.dT);
      this.dT.k("Frigate Info");
      this.dU = new bv(this);
      this.dT.AboutDialog("Name", (JComponent)this.dU);
      this.dV = new JComboBox();
      this.dV.setModel(new bw(this));
      this.dT.AboutDialog("Type", (JComponent)this.dV);
      this.dW = new JTextField();
      this.dW.setEditable(false);
      this.dT.AboutDialog("Class", (JComponent)this.dW);
      this.dX = new cN(NpcRace.class);
      this.dX.AboutDialog((var1x) -> {
         if (this.eq >= 0) {
            this.VehiclesPanel[this.eq].am(var1x);
         }

      });
      this.dT.AboutDialog("NPC Race", (JComponent)this.dX);
      this.dY = new bx(this);
      this.dT.AboutDialog("Home Seed", (JComponent)this.dY);
      this.dZ = new by(this);
      this.dT.AboutDialog("Model Seed", this.dZ);
      this.dT.k("Traits");
      bD var6 = new bD(this, (bD)null);
      this.ec = new JComboBox();
      this.ec.setModel(new bB(this, (bB)null));
      this.ec.setRenderer(var6);
      this.dT.AboutDialog(this.ec);
      this.ed = new JComboBox();
      this.ed.setModel(new bC(this, 1));
      this.ed.setRenderer(var6);
      this.dT.AboutDialog(this.ed);
      this.ee = new JComboBox();
      this.ee.setModel(new bC(this, 2));
      this.ee.setRenderer(var6);
      this.dT.AboutDialog(this.ee);
      this.ef = new JComboBox();
      this.ef.setModel(new bC(this, 3));
      this.ef.setRenderer(var6);
      this.dT.AboutDialog(this.ef);
      this.eg = new JComboBox();
      this.eg.setModel(new bC(this, 4));
      this.eg.setRenderer(var6);
      this.dT.AboutDialog(this.eg);
      this.dT.Y();
      JPanel var7 = new JPanel();
      var7.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.GLUE_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.GLUE_COLSPEC}, new RowSpec[]{FormFactory.DEFAULT_ROWSPEC, FormFactory.DEFAULT_ROWSPEC}));
      this.el = new JLabel("");
      var7.add(this.el, "2,1");
      this.repairButton = new JButton("Repair");
      this.repairButton.addActionListener(new bz(this));
      JPanel var8 = new JPanel();
      var8.add(this.repairButton);
      var7.add(var8, "2,2");
      this.dT.AboutDialog(var7);
      this.SquadronPanel = new FormPanel(new int[]{AppSettings.cJ, 0});
      this.SquadronPanel.setVisible(false);
      this.add(this.SquadronPanel);
      this.SquadronPanel.k("Stats");
      this.ea = new ValidatedTextField[gq.values().length];

      for(int var9 = 0; var9 < this.ea.length; ++var9) {
         this.ea[var9] = new bA(this, var9, (bA)null);
         this.SquadronPanel.AboutDialog(gq.values()[var9].toString(), (JComponent)this.ea[var9]);
      }

      this.SquadronPanel.Y();
      this.SquadronPanel.k("Totals");
      this.eh = new bn(this);
      this.SquadronPanel.AboutDialog("Expeditions", (JComponent)this.eh);
      this.ei = new bo(this);
      this.SquadronPanel.AboutDialog("Successful", (JComponent)this.ei);
      this.ej = new bp(this);
      this.SquadronPanel.AboutDialog("Failed", (JComponent)this.ej);
      this.ek = new bq(this);
      this.SquadronPanel.AboutDialog("Damaged", (JComponent)this.ek);
      nomanssave.en.AboutDialog(this);
   }

   public void setEditable(boolean var1) {
      if (this.dR.getSelectedRow() >= 0) {
         this.dS.setEnabled(this.VehiclesPanel.length < 30 || nomanssave.en.aS());
      }

   }

   void updateFrigates(Frigate[] var1) {
      this.VehiclesPanel = var1;
      this.en = null;
      this.eo = null;
      this.dR.clearSelection();
      if (var1.length > 0) {
         this.dR.setRowSelectionInterval(0, 0);
      }

      this.dR.updateUI();
   }

   // $FF: synthetic method
   static er[] access$getStatLabels(FrigatesPanel var0) {
      return var0.en;
   }

   // $FF: synthetic method
   static int access$getSelectedIndex(FrigatesPanel var0) {
      return var0.eq;
   }

   // $FF: synthetic method
   static Frigate[] access$getFrigates(FrigatesPanel var0) {
      return var0.VehiclesPanel;
   }

   // $FF: synthetic method
   static ValidatedTextField[] d(FrigatesPanel var0) {
      return var0.ea;
   }

   // $FF: synthetic method
   static JTable e(FrigatesPanel var0) {
      return var0.dR;
   }

   // $FF: synthetic method
   static er[] f(FrigatesPanel var0) {
      return var0.eo;
   }

   // $FF: synthetic method
   static void access$setFrigates(FrigatesPanel var0, Frigate[] var1) {
      var0.VehiclesPanel = var1;
   }

   // $FF: synthetic method
   static JButton g(FrigatesPanel var0) {
      return var0.dS;
   }

   // $FF: synthetic method
   static void access$setSelectedIndex(FrigatesPanel var0, int var1) {
      var0.eq = var1;
   }

   // $FF: synthetic method
   static void access$setStatLabels(FrigatesPanel var0, er[] var1) {
      var0.en = var1;
   }

   // $FF: synthetic method
   static void access$initStatLabels(FrigatesPanel var0, er[] var1) {
      var0.eo = var1;
   }

   // $FF: synthetic method
   static FormPanel h(FrigatesPanel var0) {
      return var0.dT;
   }

   // $FF: synthetic method
   static FormPanel i(FrigatesPanel var0) {
      return var0.SquadronPanel;
   }

   // $FF: synthetic method
   static ValidatedTextField j(FrigatesPanel var0) {
      return var0.dU;
   }

   // $FF: synthetic method
   static JComboBox k(FrigatesPanel var0) {
      return var0.dV;
   }

   // $FF: synthetic method
   static JTextField l(FrigatesPanel var0) {
      return var0.dW;
   }

   // $FF: synthetic method
   static cN m(FrigatesPanel var0) {
      return var0.dX;
   }

   // $FF: synthetic method
   static ValidatedTextField n(FrigatesPanel var0) {
      return var0.dY;
   }

   // $FF: synthetic method
   static ValidatedTextField o(FrigatesPanel var0) {
      return var0.dZ;
   }

   // $FF: synthetic method
   static JComboBox p(FrigatesPanel var0) {
      return var0.ec;
   }

   // $FF: synthetic method
   static JComboBox q(FrigatesPanel var0) {
      return var0.ed;
   }

   // $FF: synthetic method
   static JComboBox r(FrigatesPanel var0) {
      return var0.ee;
   }

   // $FF: synthetic method
   static JComboBox s(FrigatesPanel var0) {
      return var0.ef;
   }

   // $FF: synthetic method
   static JComboBox t(FrigatesPanel var0) {
      return var0.eg;
   }

   // $FF: synthetic method
   static ValidatedTextField u(FrigatesPanel var0) {
      return var0.eh;
   }

   // $FF: synthetic method
   static ValidatedTextField RefreshRunnable(FrigatesPanel var0) {
      return var0.ei;
   }

   // $FF: synthetic method
   static ValidatedTextField AppStartupRunnable(FrigatesPanel var0) {
      return var0.ej;
   }

   // $FF: synthetic method
   static ValidatedTextField UpdateCheckThread(FrigatesPanel var0) {
      return var0.ek;
   }

   // $FF: synthetic method
   static JLabel UpdateDownloadRunnable(FrigatesPanel var0) {
      return var0.el;
   }

   // $FF: synthetic method
   static JButton ShowErrorRunnable(FrigatesPanel var0) {
      return var0.repairButton;
   }

   // $FF: synthetic method
   static JButton ShowWarningRunnable(FrigatesPanel var0) {
      return var0.bQ;
   }
}
