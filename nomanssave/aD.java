package nomanssave;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class aD extends JDialog {
   private JComboBox cw;
   private JTextField cx;
   private boolean JsonEditorDialog;
   public static aD cz = null;

   private aD(Frame var1) {
      super(var1);
      this.setMinimumSize(new Dimension(400, 10));
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("Editor Settings");
      this.setModal(true);
      FormPanel var2 = new FormPanel();
      this.cw = new JComboBox();
      this.cw.setModel(new aE(this));
      var2.AboutDialog("Look & Feel", (JComponent)this.cw);
      this.cx = new JTextField();
      var2.AboutDialog("Inventory Scale", (JComponent)this.cx);
      var2.Y();
      JPanel var3 = new JPanel();
      var2.AboutDialog(var3);
      JButton var4 = new JButton("Apply");
      var4.addActionListener(new aF(this));
      var3.add(var4);
      JButton var5 = new JButton("Cancel");
      var5.addActionListener(new aG(this));
      var3.add(var5);
      this.setContentPane(var2);
      this.pack();
   }

   private boolean S() {
      String var1 = AppSettings.getProperty("LookAndFeel");
      aI var2 = (aI)Stream.of(aI.values()).filter((var1x) -> {
         return var1x.name().equalsIgnoreCase(var1);
      }).findFirst().orElse(aI.cN);
      this.cw.setSelectedItem(var2);
      this.cx.setText(Double.toString(AppSettings.AboutDialog("InventoryScaling", 1.0D)));
      this.setLocationRelativeTo(this.getParent());
      this.JsonEditorDialog = false;
      this.setVisible(true);
      return this.JsonEditorDialog;
   }

   public static boolean d(Container var0) {
      if (cz == null) {
         Frame var1 = JOptionPane.getFrameForComponent(var0);
         cz = new aD(var1);
      }

      return cz.S();
   }

   // $FF: synthetic method
   static JComboBox access$getComboBox(aD var0) {
      return var0.cw;
   }

   // $FF: synthetic method
   static void access$setFlag(aD var0, boolean var1) {
      var0.JsonEditorDialog = var1;
   }

   // $FF: synthetic method
   static JTextField access$getTextField(aD var0) {
      return var0.cx;
   }
}
