package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.util.stream.Collectors;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.Border;

public class ItemDetailsDialog extends JDialog {
   private JTextField GameMode;
   private JLabel fo;
   private JTextField fp;
   private JTextField SaveLocation;
   private JLabel AccountData;
   private JTextField SaveFile;
   private ValidatedTextField SaveSlot;
   private JLabel fu;
   private ValidatedTextField fv;
   private JTextField fw;
   private JTextField fx;
   private JTextArea fy;
   private JTextArea fz;
   private ItemDefinition PS4SaveLocation;
   private ItemData fB;
   private Integer fC;
   private Integer fD;
   public static ItemDetailsDialog fE = null;

   private ItemDetailsDialog(Frame var1) {
      super(var1);
      this.setSize(600, 480);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("Item Details");
      this.setModal(true);
      JPanel var2 = new JPanel();
      var2.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("64px"), FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormFactory.LINE_GAP_ROWSPEC}));
      var2.add(new JLabel("Type:"), "2, 2, left, center");
      this.GameMode = new JTextField();
      this.GameMode.setEditable(false);
      var2.add(this.GameMode, "4, 2, fill, default");
      this.fo = new JLabel("");
      var2.add(this.fo, "6, 2, 1, 7, center, fill");
      var2.add(new JLabel("Category:"), "2, 4, left, center");
      this.fp = new JTextField();
      this.fp.setEditable(false);
      var2.add(this.fp, "4, 4, fill, default");
      var2.add(new JLabel("Name:"), "2, 6, left, center");
      this.SaveLocation = new JTextField();
      this.SaveLocation.setEditable(false);
      var2.add(this.SaveLocation, "4, 6, fill, default");
      var2.add(new JLabel("ID:"), "2, 8, left, center");
      JPanel var3 = new JPanel();
      var3.setLayout(new FormLayout(new ColumnSpec[]{ColumnSpec.decode("default:grow"), FormFactory.DEFAULT_COLSPEC, ColumnSpec.decode("100px")}, new RowSpec[]{FormFactory.DEFAULT_ROWSPEC}));
      this.SaveFile = new JTextField();
      this.SaveFile.setEditable(false);
      var3.add(this.SaveFile, "1, 1");
      this.AccountData = new JLabel("#");
      var3.add(this.AccountData, "2, 1");
      this.SaveSlot = new ch(this);
      this.SaveSlot.setEditable(false);
      var3.add(this.SaveSlot, "3, 1");
      var2.add(var3, "4, 8, fill, default");
      this.fu = new JLabel("Quantity:");
      var2.add(this.fu, "2, 10, left, center");
      var3 = new JPanel();
      var3.setLayout(new FormLayout(new ColumnSpec[]{ColumnSpec.decode("100px"), FormFactory.DEFAULT_COLSPEC, ColumnSpec.decode("100px")}, new RowSpec[]{FormFactory.DEFAULT_ROWSPEC}));
      this.fv = new ci(this);
      this.fv.setEditable(false);
      var3.add(this.fv, "1, 1");
      var3.add(new JLabel("/"), "2, 1");
      this.fw = new JTextField();
      this.fw.setEditable(false);
      var3.add(this.fw, "3, 1");
      var2.add(var3, "4, 10, fill, default");
      var2.add(new JLabel("Subtitle:"), "2, 12, left, center");
      this.fx = new JTextField();
      this.fx.setEditable(false);
      var2.add(this.fx, "4, 12, 3, 1, fill, default");
      var2.add(new JLabel("Build Cost:"), "2, 14, left, top");
      JScrollPane var4 = new JScrollPane();
      var4.setBorder(this.fx.getBorder());
      var4.setBackground(this.fx.getBackground());
      this.fy = new JTextArea();
      this.fy.setEditable(false);
      this.fy.setBorder((Border)null);
      this.fy.setBackground((Color)null);
      this.fy.setFont(this.fx.getFont());
      var4.setViewportView(this.fy);
      var2.add(var4, "4, 14, 3, 1, fill, fill");
      var2.add(new JLabel("Description:"), "2, 16, left, top");
      this.fz = new JTextArea();
      this.fz.setEditable(false);
      this.fz.setWrapStyleWord(true);
      this.fz.setLineWrap(true);
      this.fz.setBorder(this.fx.getBorder());
      this.fz.setBackground(this.fx.getBackground());
      this.fz.setFont(this.fx.getFont());
      var2.add(this.fz, "4, 16, 3, 1, fill, fill");
      this.setContentPane(var2);
      this.getRootPane().registerKeyboardAction(new cj(this), KeyStroke.getKeyStroke(27, 0), 2);
      this.addWindowListener(new ck(this));
   }

   private void AboutDialog(ItemData var1) {
      this.fB = var1;
      Object var2 = var1.dz();
      this.PS4SaveLocation = ItemDefinition.d(var2);
      this.fC = null;
      this.fD = null;
      String var3 = this.PS4SaveLocation == null ? var1.getType() : this.PS4SaveLocation.FormPanel().toString();
      this.GameMode.setText(var3);
      this.fo.setIcon(this.PS4SaveLocation == null ? null : this.PS4SaveLocation.N(2));
      String var4;
      if (this.PS4SaveLocation != null && this.PS4SaveLocation.bb()) {
         var4 = "";
         int var6;
         if (var2 instanceof fg) {
            fg var5 = (fg)var2;
            var6 = var5.indexOf(35);
            if (var6 >= 0) {
               var4 = var5.substring(var6 + 1);
            }
         } else {
            String var8 = var2.toString();
            var6 = var8.indexOf(35);
            if (var6 >= 0) {
               var4 = var8.substring(var6 + 1);
            }
         }

         this.SaveFile.setText(this.PS4SaveLocation.getID());
         this.SaveSlot.setText(var4);
         this.AccountData.setVisible(true);
         this.SaveSlot.setVisible(true);

         try {
            int var9 = hf.AboutDialogCloseListener(var4, 0, 99999);
            this.fC = new Integer(var9);
            this.SaveSlot.setEditable(true);
         } catch (RuntimeException var7) {
            Logger.warn("Error detected in item id: " + var2);
            this.fC = null;
            this.SaveSlot.setEditable(false);
         }
      } else {
         this.SaveFile.setText(var1.ei());
         this.SaveSlot.setText("");
         this.AccountData.setVisible(false);
         this.SaveSlot.setVisible(false);
      }

      if (var3.equals("Technology") && var1.dA() >= 0 && var1.dA() < var1.dB()) {
         this.fu.setText("Charge:");
         this.fD = var1.dA();
         this.fv.setText(Integer.toString(var1.dA()));
         this.fw.setText(Integer.toString(var1.dB()));
         this.fv.setEditable(true);
      } else if ((var3.equals("Product") || var3.equals("Substance")) && var1.dB() > 1) {
         this.fu.setText("Quantity:");
         this.fD = var1.dA();
         this.fv.setText(Integer.toString(var1.dA()));
         this.fw.setText(Integer.toString(var1.dB()));
         this.fv.setEditable(true);
      } else {
         this.fu.setText("Quantity:");
         this.fv.setText("1");
         this.fw.setText("1");
         this.fv.setEditable(false);
      }

      this.SaveLocation.setText(this.PS4SaveLocation == null ? "[Unknown]" : this.PS4SaveLocation.getName());
      this.fp.setText(this.PS4SaveLocation == null ? "[Unknown]" : this.PS4SaveLocation.bc().toString());
      this.fx.setText(this.PS4SaveLocation == null ? "" : this.PS4SaveLocation.bg());
      var4 = this.PS4SaveLocation == null ? "" : (String)this.PS4SaveLocation.bk().stream().map((var0) -> {
         ItemDefinition var1 = ItemDefinition.d(var0.getID());
         return var1 != null ? var1.getName() + " (x" + var0.bo() + ")" : var0.getID() + " (x" + var0.bo() + ")";
      }).collect(Collectors.joining("\n"));
      if (var4.length() == 0) {
         var4 = "N/A";
      }

      this.fy.setText(var4);
      this.fy.setCaretPosition(0);
      this.fz.setText(this.PS4SaveLocation == null ? "" : this.PS4SaveLocation.getDescription());
      this.setLocationRelativeTo(this.getParent());
      this.setVisible(true);
   }

   public static void AboutDialog(Container var0, ItemData var1) {
      if (fE == null) {
         Frame var2 = JOptionPane.getFrameForComponent(var0);
         fE = new ItemDetailsDialog(var2);
      }

      fE.AboutDialog(var1);
   }

   // $FF: synthetic method
   static Integer AboutDialog(ItemDetailsDialog var0) {
      return var0.fC;
   }

   // $FF: synthetic method
   static ItemData AboutDialogCloseListener(ItemDetailsDialog var0) {
      return var0.fB;
   }

   // $FF: synthetic method
   static ItemDefinition AccountPanel(ItemDetailsDialog var0) {
      return var0.PS4SaveLocation;
   }

   // $FF: synthetic method
   static void AboutDialog(ItemDetailsDialog var0, Integer var1) {
      var0.fC = var1;
   }

   // $FF: synthetic method
   static Integer d(ItemDetailsDialog var0) {
      return var0.fD;
   }

   // $FF: synthetic method
   static void AboutDialogCloseListener(ItemDetailsDialog var0, Integer var1) {
      var0.fD = var1;
   }

   // $FF: synthetic method
   static ValidatedTextField e(ItemDetailsDialog var0) {
      return var0.SaveSlot;
   }

   // $FF: synthetic method
   static ValidatedTextField f(ItemDetailsDialog var0) {
      return var0.fv;
   }
}
