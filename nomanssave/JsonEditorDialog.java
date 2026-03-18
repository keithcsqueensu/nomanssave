package nomanssave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;
import javax.swing.text.DefaultHighlighter.DefaultHighlightPainter;

public class JsonEditorDialog extends JDialog implements TreeSelectionListener {
   private String fS;
   private JsonObject XboxSaveLocation = null;
   private JButton fU;
   private JTree fV;
   private JScrollPane fW;
   private JTextArea XboxContainerWriter;
   private JScrollPane fY;
   private cJ fZ;
   private boolean ga;
   private boolean gb;
   private static final String gc = "0123456789ABCDEFabcdef";
   private static JsonEditorDialog NpcRace = null;
   private boolean Settlement = true;
   private String Base = "";

   private JsonEditorDialog(Application var1) {
      super(var1.g());
      Rectangle var2 = new Rectangle(100, 100, 1000, 700);
      Point var3 = var1.g().getLocation();
      var2.UpdateCheckThread = AppSettings.AboutDialog("JSONEditor.X", var3.UpdateCheckThread + 10);
      var2.UpdateDownloadRunnable = AppSettings.AboutDialog("JSONEditor.Y", var3.UpdateDownloadRunnable + 10);
      var2.width = AppSettings.AboutDialog("JSONEditor.Width", 1000);
      var2.height = AppSettings.AboutDialog("JSONEditor.Height", 700);
      this.setBounds(var2);
      this.setDefaultCloseOperation(0);
      this.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
      this.setTitle("JSON Editor (Advanced Users Only)");
      this.setModal(true);
      this.addComponentListener(new cz(this));
      this.fV = new JTree();
      this.fV.setModel(new cI(this, (cI)null));
      this.fV.setCellRenderer(new cA(this));
      this.fV.addTreeSelectionListener(this);
      this.fW = new JScrollPane();
      this.fW.setViewportView(this.fV);
      this.XboxContainerWriter = new JTextArea();
      this.XboxContainerWriter.putClientProperty("FlatLaf.styleClass", "monospaced");
      this.XboxContainerWriter.setEditable(false);
      this.XboxContainerWriter.setTabSize(4);
      this.XboxContainerWriter.getActionMap().put("copy-to-clipboard", new cG(this));
      this.XboxContainerWriter.getActionMap().put("paste-from-clipboard", new cH(this));
      this.XboxContainerWriter.getDocument().addDocumentListener(new cB(this));
      this.fY = new JScrollPane();
      this.fY.setRowHeaderView(new LineNumberPanel(this.XboxContainerWriter));
      this.fY.setViewportView(this.XboxContainerWriter);
      JPanel var4 = new JPanel();
      var4.setLayout(new BorderLayout());
      this.fU = new JButton("Validate");
      this.fU.addActionListener(new cC(this));
      var4.add(this.fU, "North");
      var4.add(this.fW, "Center");
      JSplitPane var5 = new JSplitPane(1, var4, this.fY);
      var5.setDividerLocation(AppSettings.AboutDialog("JSONEditor.Divider", 280));
      var5.addPropertyChangeListener("dividerLocation", new cD(this));
      this.setContentPane(var5);
      this.addWindowListener(new cE(this));
      cF var6 = new cF(this);
      this.fV.getInputMap().put(KeyStroke.getKeyStroke(70, 2), "find");
      this.fV.getActionMap().put("find", var6);
      this.XboxContainerWriter.getInputMap().put(KeyStroke.getKeyStroke(70, 2), "find");
      this.XboxContainerWriter.getActionMap().put("find", var6);
   }

   private boolean AboutDialog(String var1, JsonObject var2) {
      this.setTitle("JSON Editor (Advanced Users Only)");
      this.fS = var1;
      this.XboxSaveLocation = var2;
      this.XboxContainerWriter.setText("");
      this.ga = false;
      this.fZ = null;
      this.fV.updateUI();
      int var3 = 0;
      int var4 = 0;
      Iterator var6 = var2.names().iterator();

      while(var6.hasNext()) {
         String var5 = (String)var6.next();
         ++var4;
         if (var2.get(var5) instanceof JsonObject) {
            var3 = var4;
            break;
         }
      }

      this.fV.setSelectionRow(var3);
      this.gb = false;
      this.fV.setVisible(true);
      this.fU.setVisible(false);
      this.setVisible(true);
      return this.gb;
   }

   private static String ay() {
      String var0;
      try {
         var0 = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
      } catch (IOException | UnsupportedFlavorException var4) {
         Logger.error("Could not retrieve clipboard contents", var4);
         return "";
      }

      StringBuffer var1 = new StringBuffer();
      char[] var2 = var0.toCharArray();

      for(int var3 = 0; var3 < var2.length; ++var3) {
         if (var2[var3] != '\r' && var2[var3] != '\n' && var2[var3] != '\t') {
            if (var2[var3] == '\f') {
               var1.append("\\f");
            } else if (var2[var3] == '\b') {
               var1.append("\\b");
            } else if (var2[var3] == 11) {
               var1.append("\\v");
            } else if (var2[var3] == 0) {
               var1.append("\\0");
            } else if (var2[var3] >= ' ' && var2[var3] < 128) {
               var1.append(var2[var3]);
            } else {
               var1.append("\\u");
               var1.append("0123456789ABCDEFabcdef".charAt(var2[var3] >> 12 & 15));
               var1.append("0123456789ABCDEFabcdef".charAt(var2[var3] >> 8 & 15));
               var1.append("0123456789ABCDEFabcdef".charAt(var2[var3] >> 4 & 15));
               var1.append("0123456789ABCDEFabcdef".charAt(var2[var3] & 15));
            }
         } else {
            var1.append(var2[var3]);
         }
      }

      return var1.toString();
   }

   private static int AboutDialog(char var0) {
      int var1 = "0123456789ABCDEFabcdef".indexOf(var0);
      if (var1 < 0) {
         throw new RuntimeException("Error decoding hex");
      } else {
         if (var1 >= 16) {
            var1 -= 6;
         }

         return var1;
      }
   }

   private static void AboutDialog(String var0, ClipboardOwner var1) {
      StringBuffer var2 = new StringBuffer();
      char[] var3 = var0.toCharArray();

      for(int var5 = 0; var5 < var3.length; ++var5) {
         if (var3[var5] == '\\' && var5 + 5 < var3.length && var3[var5 + 1] == 'u') {
            try {
               int var4 = AboutDialog(var3[var5 + 2]) << 12 | AboutDialog(var3[var5 + 3]) << 8 | AboutDialog(var3[var5 + 4]) << 4 | AboutDialog(var3[var5 + 5]);
               if (var4 < 32) {
                  var2.append(var3[var5]);
                  var2.append(var3[var5 + 1]);
                  var2.append(var3[var5 + 2]);
                  var2.append(var3[var5 + 3]);
                  var2.append(var3[var5 + 4]);
                  var2.append(var3[var5 + 5]);
               } else {
                  var2.append((char)var4);
               }

               var5 += 5;
            } catch (RuntimeException var7) {
            }
         } else {
            var2.append(var3[var5]);
         }
      }

      StringSelection var8 = new StringSelection(var2.toString());
      Clipboard var6 = Toolkit.getDefaultToolkit().getSystemClipboard();
      var6.setContents(var8, var1);
   }

   public static boolean AboutDialog(Application var0, String var1, JsonObject var2) {
      if (NpcRace == null) {
         NpcRace = new JsonEditorDialog(var0);
      }

      return NpcRace.AboutDialog(var1, var2);
   }

   public void valueChanged(TreeSelectionEvent var1) {
      if (this.Settlement) {
         if (this.ga && this.fZ != null) {
            try {
               String var2 = this.XboxContainerWriter.getText().trim();
               if (var2.length() == 0 && JOptionPane.showConfirmDialog(this, "The JSON data has been deleted, do you wish to apply these changes to the save file?", this.getTitle(), 0) == 0) {
                  this.fZ.remove();
                  ((cI)this.fV.getModel()).AboutDialog(this.fZ.gi);
               } else if (JOptionPane.showConfirmDialog(this, "The JSON data has changed, do you wish to apply these changes to the save file?", this.getTitle(), 0) == 0) {
                  this.fZ.setText(var2);
                  ((cI)this.fV.getModel()).AboutDialog(this.fZ);
               }
            } catch (JsonParseException var3) {
               JOptionPane.showOptionDialog(this, "Error on line #" + var3.getLineNumber() + ": " + var3.getMessage(), "Error", 0, 0, (Icon)null, new Object[]{"Cancel"}, (Object)null);
               this.XboxContainerWriter.setCaretPosition(var3.bD());
               this.XboxContainerWriter.requestFocus();
               return;
            }
         }

         this.fZ = (cJ)this.fV.getLastSelectedPathComponent();
         if (this.fZ == null) {
            this.XboxContainerWriter.setText("");
            this.XboxContainerWriter.setEditable(false);
         } else {
            this.XboxContainerWriter.setText(this.fZ.getText());
            this.XboxContainerWriter.setEditable(true);
         }

         this.ga = false;
         this.XboxContainerWriter.setCaretPosition(0);
         this.XboxContainerWriter.requestFocus();
      }
   }

   void AboutDialog(String var1, boolean var2, boolean var3, boolean var4) {
      String var5 = this.XboxContainerWriter.getText();
      if (!this.Base.equals(var1)) {
         Highlighter var6 = this.XboxContainerWriter.getHighlighter();
         var6.removeAllHighlights();
         Color var7 = UIManager.getColor("JSONEditor.hiliteColor");
         DefaultHighlightPainter var8 = new DefaultHighlightPainter(var7);
         int var9 = -1;

         while((var9 = var5.indexOf(var1, var9 + 1)) >= 0) {
            try {
               var6.addHighlight(var9, var9 + var1.length(), var8);
            } catch (BadLocationException var11) {
            }
         }
      }

      if (!var3) {
         var5 = var5.toUpperCase();
         var1 = var1.toUpperCase();
      }

      int var12 = this.XboxContainerWriter.getCaretPosition();
      int var13 = -1;
      if (var2) {
         if (var12 > var1.length()) {
            var13 = var5.lastIndexOf(var1, var12 - var1.length() - 1);
         }

         if (var13 < 0 && var4) {
            var13 = var5.lastIndexOf(var1);
         }
      } else {
         if (var12 < var5.length() - 1) {
            var13 = var5.indexOf(var1, var12 + 1);
         }

         if (var13 < 0 && var4) {
            var13 = var5.indexOf(var1);
         }
      }

      if (var13 < 0) {
         JOptionPane.showMessageDialog(this, "Text not found!");
      } else {
         this.XboxContainerWriter.setCaretPosition(var13);
         this.XboxContainerWriter.setSelectionStart(var13);
         this.XboxContainerWriter.setSelectionEnd(var13 + var1.length());
      }

   }

   // $FF: synthetic method
   static String az() {
      return ay();
   }

   // $FF: synthetic method
   static void AboutDialogCloseListener(String var0, ClipboardOwner var1) {
      AboutDialog(var0, var1);
   }

   // $FF: synthetic method
   static String AboutDialog(JsonEditorDialog var0) {
      return var0.fS;
   }

   // $FF: synthetic method
   static JsonObject AboutDialogCloseListener(JsonEditorDialog var0) {
      return var0.XboxSaveLocation;
   }

   // $FF: synthetic method
   static void AboutDialog(JsonEditorDialog var0, boolean var1) {
      var0.ga = var1;
   }

   // $FF: synthetic method
   static void AboutDialogCloseListener(JsonEditorDialog var0, boolean var1) {
      var0.gb = var1;
   }

   // $FF: synthetic method
   static JTextArea AccountPanel(JsonEditorDialog var0) {
      return var0.XboxContainerWriter;
   }

   // $FF: synthetic method
   static cJ d(JsonEditorDialog var0) {
      return var0.fZ;
   }

   // $FF: synthetic method
   static JTree e(JsonEditorDialog var0) {
      return var0.fV;
   }

   // $FF: synthetic method
   static JButton f(JsonEditorDialog var0) {
      return var0.fU;
   }

   // $FF: synthetic method
   static boolean g(JsonEditorDialog var0) {
      return var0.ga;
   }
}
