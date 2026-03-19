package nomanssave;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.TableRowSorter;

public class p extends JDialog {
   private final JTable table;
   private final TableRowSorter rowSorter;
   private List rowList;
   private List ValidatedTextField = null;
   private static p H = null;

   private p(Frame var1) {
      super(var1);
      this.setSize(AppSettings.cI * 2, AppSettings.cI + AppSettings.cH);
      this.setResizable(false);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setModal(true);
      JPanel var2 = new JPanel();
      this.setContentPane(var2);
      var2.setLayout(new BorderLayout(0, 0));
      JScrollPane var3 = new JScrollPane();
      this.table = new JTable();
      this.table.setSelectionMode(2);
      this.table.setModel(new q(this));
      this.table.getColumnModel().getColumn(0).setMaxWidth(24);
      this.rowSorter = new TableRowSorter(this.table.getModel());
      this.rowSorter.setSortable(0, false);
      this.table.setRowSorter(this.rowSorter);
      var3.setViewportView(this.table);
      var2.add(var3);
      JPanel var4 = new JPanel();
      var4.setLayout(new FlowLayout(2));
      var2.add(var4, "South");
      JButton var5 = new JButton("Add");
      var5.addActionListener(new r(this));
      var4.add(var5);
      this.getRootPane().setDefaultButton(var5);
      JButton var6 = new JButton("Cancel");
      var6.addActionListener(new s(this));
      var4.add(var6);
      this.getRootPane().registerKeyboardAction(new t(this), KeyStroke.getKeyStroke(27, 0), 2);
   }

   private String[] d() {
      this.table.clearSelection();
      this.rowSorter.setSortKeys(Collections.emptyList());
      this.rowSorter.sort();
      this.table.updateUI();
      this.ValidatedTextField = null;
      this.setLocationRelativeTo(this.getParent());
      this.setVisible(true);
      return this.ValidatedTextField == null ? new String[0] : (String[])this.ValidatedTextField.toArray(new String[0]);
   }

   public static String[] show(Container var0) {
      if (H == null) {
         Frame var1 = JOptionPane.getFrameForComponent(var0);
         H = new p(var1);
      }

      H.rowList = ItemDefinition.FrigatesPanel();
      H.setTitle("Add Known Technologies");
      return H.d();
   }

   public static String[] showProducts(Container var0) {
      if (H == null) {
         Frame var1 = JOptionPane.getFrameForComponent(var0);
         H = new p(var1);
      }

      H.rowList = ItemDefinition.bm();
      H.setTitle("Add Known Products");
      return H.d();
   }

   // $FF: synthetic method
   static List access$getList(p var0) {
      return var0.rowList;
   }

   // $FF: synthetic method
   static JTable access$getTable(p var0) {
      return var0.table;
   }

   // $FF: synthetic method
   static void access$setList(p var0, List var1) {
      var0.ValidatedTextField = var1;
   }

   // $FF: synthetic method
   static List access$getSelectedList(p var0) {
      return var0.ValidatedTextField;
   }
}
