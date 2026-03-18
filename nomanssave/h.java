package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class h extends JDialog {
   private ItemDefinition l = null;
   private JTextField m;
   private JButton n;
   private JComboBox o;
   private JComboBox p;
   private JComboBox q;
   private int r;
   private List s = new ArrayList();
   private List t = new ArrayList();
   private List u = new ArrayList();
   private List RefreshRunnable = new ArrayList();
   private static h AppStartupRunnable = null;

   private h(Frame var1) {
      super(var1);
      this.setResizable(false);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("Add Item");
      this.setModal(true);
      JPanel var2 = new JPanel();
      this.setContentPane(var2);
      var2.setLayout(new BorderLayout(0, 0));
      JPanel var3 = new JPanel();
      var3.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("280px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC}));
      JLabel var4 = new JLabel("Search:");
      var3.add(var4, "2, 2, left, center");
      JPanel var5 = new JPanel();
      var5.setLayout(new BorderLayout(0, 0));
      this.m = new JTextField();
      this.m.setText("");
      var5.add(this.m, "Center");
      this.n = new JButton("Search");
      this.n.addActionListener(new i(this));
      var5.add(this.n, "East");
      var3.add(var5, "4, 2, fill, default");
      JLabel var6 = new JLabel("Type:");
      var3.add(var6, "2, 4, left, center");
      this.o = new JComboBox();
      this.o.setModel(new j(this));
      var3.add(this.o, "4, 4, fill, default");
      JLabel var7 = new JLabel("Category:");
      var3.add(var7, "2, 6, left, center");
      this.p = new JComboBox();
      this.p.setModel(new k(this));
      var3.add(this.p, "4, 6, fill, default");
      JLabel var8 = new JLabel("Item:");
      var3.add(var8, "2, 8, left, center");
      this.q = new JComboBox();
      this.q.setModel(new l(this));
      var3.add(this.q, "4, 8, fill, default");
      var2.add(var3, "Center");
      JPanel var9 = new JPanel();
      var9.setLayout(new FlowLayout(2));
      var2.add(var9, "South");
      JButton var10 = new JButton("Save");
      var10.addActionListener(new m(this));
      var9.add(var10);
      this.getRootPane().setDefaultButton(var10);
      JButton var11 = new JButton("Cancel");
      var11.addActionListener(new n(this));
      var9.add(var11);
      this.getRootPane().registerKeyboardAction(new o(this), KeyStroke.getKeyStroke(27, 0), 2);
      this.pack();
   }

   private void AboutDialog() {
      this.t = (List)this.s.stream().map(ItemDefinition::FormPanel).distinct().sorted((var0, var1) -> {
         return var0.name().compareTo(var1.name());
      }).collect(Collectors.toList());
      this.o.setSelectedIndex(this.t.size() == 1 ? 0 : -1);
      this.o.updateUI();
      this.AboutDialogCloseListener();
   }

   private void AboutDialogCloseListener() {
      eB var1 = (eB)this.o.getSelectedItem();
      this.u = (List)this.s.stream().filter((var1x) -> {
         return var1x.FormPanel() == var1;
      }).map(ItemDefinition::bc).distinct().sorted((var0, var1x) -> {
         return var0.name().compareTo(var1x.name());
      }).collect(Collectors.toList());
      this.p.setSelectedIndex(this.u.size() == 1 ? 0 : -1);
      this.p.updateUI();
      this.AccountPanel();
   }

   private void AccountPanel() {
      eB var1 = (eB)this.o.getSelectedItem();
      ex var2 = (ex)this.p.getSelectedItem();
      this.RefreshRunnable = (List)this.s.stream().filter((var2x) -> {
         return var2x.FormPanel() == var1 && var2x.bc() == var2 && (var2 != ex.iZ || !var2x.be());
      }).sorted((var0, var1x) -> {
         return var0.getName().compareTo(var1x.getName());
      }).collect(Collectors.toList());
      this.q.setSelectedIndex(this.RefreshRunnable.size() == 1 ? 0 : -1);
      this.q.updateUI();
   }

   private ItemDefinition AboutDialog(int var1) {
      this.r = var1;
      this.s = ItemDefinition.AboutDialogCloseListener(var1, this.m.getText());
      this.AboutDialog();
      this.l = null;
      this.setLocationRelativeTo(this.getParent());
      this.setVisible(true);
      return this.l;
   }

   public static ItemDefinition AboutDialog(Container var0, int var1) {
      if (AppStartupRunnable == null) {
         Frame var2 = JOptionPane.getFrameForComponent(var0);
         AppStartupRunnable = new h(var2);
      }

      return AppStartupRunnable.AboutDialog(var1);
   }

   // $FF: synthetic method
   static JTextField AboutDialog(h var0) {
      return var0.m;
   }

   // $FF: synthetic method
   static int AboutDialogCloseListener(h var0) {
      return var0.r;
   }

   // $FF: synthetic method
   static void AboutDialog(h var0, List var1) {
      var0.s = var1;
   }

   // $FF: synthetic method
   static void AccountPanel(h var0) {
      var0.AboutDialog();
   }

   // $FF: synthetic method
   static List d(h var0) {
      return var0.s;
   }

   // $FF: synthetic method
   static List e(h var0) {
      return var0.t;
   }

   // $FF: synthetic method
   static void f(h var0) {
      var0.AboutDialogCloseListener();
   }

   // $FF: synthetic method
   static List g(h var0) {
      return var0.u;
   }

   // $FF: synthetic method
   static void h(h var0) {
      var0.AccountPanel();
   }

   // $FF: synthetic method
   static List i(h var0) {
      return var0.RefreshRunnable;
   }

   // $FF: synthetic method
   static JComboBox j(h var0) {
      return var0.q;
   }

   // $FF: synthetic method
   static void AboutDialog(h var0, ItemDefinition var1) {
      var0.l = var1;
   }
}
