package nomanssave;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Application {
   public static final String VERSION = "1.19.14";
   public static final String RELEASE = "BREACH";
   private static final String J = "https://github.com/goatfungus/NMSSaveEditor";
   private static final String K = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_";
   private static Application instance;
   private static HashMap iconCache = new HashMap();
   private JFrame mainWindow;
   private JTabbedPane tabbedPane;
   private JLabel storageLabel;
   private JLabel savePathLabel;
   private JComboBox slotComboBox;
   private JComboBox fileComboBox;
   private JLabel modifiedLabel;
   private JLabel saveNameLabel;
   private JLabel descriptionLabel;
   private JButton reloadButton;
   private JButton CompanionsPanel;
   private JButton saveAsButton;
   private JMenuItem reloadMenuItem;
   private JMenuItem saveMenuItem;
   private JMenuItem saveAsMenuItem;
   private List editMenuItems;
   private JMenuItem editAccountJsonMenuItem;
   private static final int ae = 0;
   private static final int af = 1;
   private static final int ag = 2;
   private static final int ah = 3;
   private static final int ai = 4;
   private static final int aj = 5;
   private static final int ak = 6;
   private static final int al = 7;
   private static final int am = 8;
   private static final int an = 9;
   private static final int ao = 10;
   private static final int DiscoveryPanel = 11;
   private static final int aq = 12;
   private static final int ar = 13;
   private ExosuitPanel exosuitPanel;
   private MultitoolPanel multitoolPanel;
   private ShipsPanel shipsPanel;
   private SquadronPanel squadronPanel;
   private FreighterPanel freighterPanel;
   private FrigatesPanel frigatesPanel;
   private VehiclesPanel vehiclesPanel;
   private CompanionsPanel companionsPanel;
   private BasesStoragePanel basesStoragePanel;
   private SettlementsPanel settlementsPanel;
   private DiscoveryPanel discoveryPanel;
   private MilestonesPanel milestonesPanel;
   private AccountPanel accountPanel;
   private SaveLocation saveLocation;
   private SaveSlot[] saveSlots;
   private int AppSettings;
   private SaveFile[] saveFiles;
   private int ExosuitPanel;
   private JsonObject currentSave;
   private boolean saveModified;
   private AccountData accountData;
   private JsonObject accountJson;
   private boolean accountModified;
   private boolean aP;
   private boolean aQ;
   private boolean aR;
   private boolean aS;
   private boolean aT;
   private boolean aU;
   private PropertyChangeListener accountChangeListener;
   private PropertyChangeListener saveChangeListener;
   private SaveChangeListener fileChangeHandler;
   // $FF: synthetic field
   private static int[] aY;

   public static String formatDateTime(long var0) {
      SimpleDateFormat var2 = new SimpleDateFormat("h:mm a, E MMM d, yyyy");
      return var2.format(new Date(var0));
   }

   public static String formatDateShort(long var0) {
      SimpleDateFormat var2 = new SimpleDateFormat("MMM d, HH:mm");
      return var2.format(new Date(var0));
   }

   private static String sanitizeFileName(String var0, String var1) {
      if (var0 == null) {
         return var1;
      } else {
         StringBuffer var2 = new StringBuffer();

         for(int var4 = 0; var4 < var0.length(); ++var4) {
            char var3 = var0.charAt(var4);
            if ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_".indexOf(var3) >= 0) {
               var2.append(var3);
            } else if (Character.isWhitespace(var3)) {
               var2.append('_');
            }
         }

         return var2.length() != 0 ? var2.toString() : var1;
      }
   }

   public static Application getInstance() {
      return instance;
   }

   public static void main(String[] var0) {
      byte var1 = 0;
      boolean var2;
      if (var0.length > var1 && var0[var1].equals("-autoupdate")) {
         int var3 = var1 + 1;
         var2 = true;
      } else {
         var2 = false;
      }

      nomanssave.AppSettings.init(!var2);
      Logger.info("Starting Editor...");
      (new Thread(() -> {
         cK.basesStoragePanel();
      })).start();
      EventQueue.invokeLater(new AppStartupRunnable(var2));
   }

   public static ImageIcon loadIcon(String var0) {
      BufferedImage var1 = (BufferedImage)iconCache.get(var0);
      if (var1 == null) {
         InputStream var2 = Application.class.getResourceAsStream("icons/" + var0);
         if (var2 != null) {
            try {
               var1 = ImageIO.read(var2);
               iconCache.put(var0, var1);
            } catch (IOException var4) {
               Logger.info("Error loading icon: " + var0);
            } catch (RuntimeException var5) {
               Logger.info("Error loading icon: " + var0);
            }
         }
      }

      return var1 == null ? null : new ImageIcon(var1);
   }

   public static ImageIcon loadScaledIcon(String var0, int var1, int var2) {
      BufferedImage var3 = (BufferedImage)iconCache.get(var0);
      if (var3 == null) {
         InputStream var4 = Application.class.getResourceAsStream("icons/" + var0);
         if (var4 != null) {
            try {
               var3 = ImageIO.read(var4);
               iconCache.put(var0, var3);
            } catch (IOException var6) {
               Logger.info("Error loading icon: " + var0);
            } catch (RuntimeException var7) {
               Logger.info("Error loading icon: " + var0);
            }
         }
      }

      return var3 == null ? null : new ImageIcon(var3.getScaledInstance(var1, var2, 4));
   }

   private void checkExternalChanges() {
      if (this.aR) {
         this.aR = false;
      }

      int var1;
      if (this.aS) {
         this.aS = false;
         var1 = this.AppSettings < 0 ? -1 : this.saveSlots[this.AppSettings].getIndex();
         this.saveSlots = (SaveSlot[])Arrays.asList(this.saveLocation.bU()).stream().filter((var1x) -> {
            return var1x.getIndex() == var1 || !var1x.isEmpty();
         }).toArray((var0) -> {
            return new SaveSlot[var0];
         });
         this.AppSettings = -1;

         for(int var2 = 0; var2 < this.saveSlots.length; ++var2) {
            if (this.saveSlots[var2].getIndex() == var1) {
               this.AppSettings = var2;
               break;
            }
         }

         if (var1 >= 0 && this.AppSettings < 0) {
            Logger.warn("Slot " + (var1 + 1) + " was not reloaded!");
            this.saveFiles = new SaveFile[0];
            this.ExosuitPanel = -1;
         }

         this.slotComboBox.updateUI();
      }

      this.aT &= this.AppSettings >= 0;
      if (this.aT) {
         this.aT = false;
         String var7 = this.ExosuitPanel < 0 ? null : this.saveFiles[this.ExosuitPanel].K();
         long var8 = this.ExosuitPanel < 0 ? Long.MIN_VALUE : this.saveFiles[this.ExosuitPanel].lastModified();
         GameMode var4 = this.ExosuitPanel < 0 ? null : this.saveFiles[this.ExosuitPanel].instance();
         this.saveFiles = this.saveSlots[this.AppSettings].bX();
         this.ExosuitPanel = -1;

         int var5;
         for(var5 = 0; var5 < this.saveFiles.length; ++var5) {
            if (this.saveFiles[var5].K().equals(var7)) {
               this.ExosuitPanel = var5;
               break;
            }
         }

         if (var7 != null && this.ExosuitPanel < 0) {
            this.aU = false;
            var5 = JOptionPane.showConfirmDialog(this.mainWindow, "Save file has been deleted externally. Would you like to reload?\nNOTE: All changes made in the editor will be lost.", "Reload File", 0);
            if (var5 == 0) {
               this.ExosuitPanel = 0;
               this.loadSave();
            } else {
               SaveFile[] var6 = new SaveFile[this.saveFiles.length + 1];
               var6[0] = new InMemorySaveFile(this, var7, var8, var4, this.currentSave);
               System.arraycopy(this.saveFiles, 0, var6, 1, this.saveFiles.length);
               this.saveFiles = var6;
               this.ExosuitPanel = 0;
            }
         }

         this.fileComboBox.updateUI();
      }

      this.aU &= this.ExosuitPanel >= 0;
      if (this.aU) {
         this.aU = false;
         var1 = JOptionPane.showConfirmDialog(this.mainWindow, "Save file has been modified externally. Would you like to reload?\nNOTE: All changes made in the editor will be lost.", "Reload File", 0);
         if (var1 == 0) {
            this.loadSave();
         } else {
            this.saveModified = true;
         }
      }

   }

   private Application(boolean var1) {
      this.aQ = false;
      this.aR = false;
      this.aS = false;
      this.aT = false;
      this.aU = false;
      this.accountChangeListener = (var1x, var2x, var3x) -> {
         this.accountModified = true;
         this.aP = true;
         if (var3x == null) {
            Logger.info("Removing " + var1x);
         } else {
            String var4;
            if (var3x instanceof JsonObject) {
               var4 = "[OBJECT]";
            } else if (var3x instanceof JsonArray) {
               var4 = "[ARRAY]";
            } else {
               var4 = var3x.toString();
            }

            Logger.info("Setting " + var1x + ": " + var4);
         }
      };
      this.saveChangeListener = (var1x, var2x, var3x) -> {
         this.saveModified = true;
         if (var1x.startsWith("PlayerStateData.Multitools")) {
            int var4 = this.currentSave.J("PlayerStateData.ActiveMultioolIndex");
            if (var1x.startsWith("PlayerStateData.Multitools[" + var4 + "].Store.")) {
               JsonObject var5 = this.currentSave.H("PlayerStateData.Multitools[" + var4 + "].Store");
               this.currentSave.AboutDialogCloseListener("PlayerStateData.WeaponInventory", (Object)var5.MilestonesPanel());
            } else if (var1x.equals("PlayerStateData.Multitools[" + var4 + "].Seed[1]")) {
               this.currentSave.AboutDialogCloseListener("PlayerStateData.CurrentWeapon.GenerationSeed[1]", var3x);
            } else if (var1x.equals("PlayerStateData.Multitools[" + var4 + "].Resource.Filename")) {
               this.currentSave.AboutDialogCloseListener("PlayerStateData.CurrentWeapon.Filename", var3x);
            }
         }

         if (var3x == null) {
            Logger.info("Removing " + var1x);
         } else {
            String var6;
            if (var3x instanceof JsonObject) {
               var6 = "OBJECT";
            } else if (var3x instanceof JsonArray) {
               var6 = "ARRAY[" + ((JsonArray)var3x).size() + "]";
            } else {
               var6 = JsonParser.AboutDialogCloseListener(var3x, false);
            }

            Logger.info("Setting " + var1x + ": " + var6);
         }
      };
      this.fileChangeHandler = new exportJson(this);
      String var2 = nomanssave.AppSettings.getProperty("GameStorage");
      String var3 = nomanssave.AppSettings.getProperty("GameSaveDir");
      this.saveLocation = var3 == null ? null : SaveLocation.createSaveLocation(var2, new File(var3), this.fileChangeHandler);
      if (this.saveLocation == null) {
         this.saveSlots = new SaveSlot[0];
         this.AppSettings = -1;
         this.saveFiles = new SaveFile[0];
         this.ExosuitPanel = -1;
         this.accountData = null;
         this.accountJson = null;
      } else {
         this.saveSlots = this.saveLocation.bV();
         this.AppSettings = -1;
         this.saveFiles = new SaveFile[0];
         this.ExosuitPanel = -1;
         if (var2 == null) {
            var2 = SaveLocation.getStorageName(this.saveLocation);
            nomanssave.AppSettings.setProperty("GameStorage", var2);
         }

         Logger.debug("Storage: " + var2);
         Logger.debug("Save Path: " + this.saveLocation.InventorySlotPanel().getAbsolutePath());
         this.accountData = null;
         this.accountJson = null;

         try {
            Logger.info("Reading account data...");
            this.accountData = this.saveLocation.bT();
            this.accountJson = this.accountData == null ? null : this.accountData.iconCache();
            if (this.accountJson != null) {
               this.accountJson.AboutDialog(this.accountChangeListener);
            }
         } catch (IOException var5) {
            Logger.error("Error reading account data", var5);
         }
      }

      this.initialize();
      (new UpdateCheckThread(this, var1)).start();
   }

   public JFrame getMainWindow() {
      return this.mainWindow;
   }

   public void exportStarship(Starship var1) {
      File var2 = nomanssave.AppSettings.cF;
      if (!var2.exists() && !var2.mkdir()) {
         var2 = nomanssave.AppSettings.cD;
      }

      cT var3 = cT.discoveryPanel();
      String var4 = sanitizeFileName(var1.getName(), "Ship");
      var3.setCurrentDirectory(var2);
      var3.setSelectedFile(new File(var2, var4));
      if (var3.showSaveDialog(this.mainWindow) == 0) {
         try {
            File var5 = var3.getSelectedFile();
            if (!var5.getName().endsWith(".sh0")) {
               var5 = new File(var5.getParentFile(), var5.getName() + ".sh0");
            }

            var1.AboutDialog(var5, var3.freighterPanel());
         } catch (RuntimeException var6) {
            Logger.error("Ship export error", var6);
            this.showWarning("An error occured during export.");
         } catch (IOException var7) {
            Logger.error("Ship export error", var7);
            this.showWarning("An error occured during export.");
         }
      }

   }

   public void exportMultitool(Multitool var1) {
      File var2 = nomanssave.AppSettings.cF;
      if (!var2.exists() && !var2.mkdir()) {
         var2 = nomanssave.AppSettings.cD;
      }

      cv var3 = cv.frigatesPanel();
      String var4 = sanitizeFileName(var1.getName(), "Weapon");
      var3.setCurrentDirectory(var2);
      var3.setSelectedFile(new File(var2, var4));
      if (var3.showSaveDialog(this.mainWindow) == 0) {
         try {
            File var5 = var3.getSelectedFile();
            if (!var5.getName().endsWith(".wp0")) {
               var5 = new File(var5.getParentFile(), var5.getName() + ".wp0");
            }

            var1.isFrigateOnMission(var5);
         } catch (RuntimeException var6) {
            Logger.error("Weapon export error", var6);
            this.showWarning("An error occured during export.");
         } catch (IOException var7) {
            Logger.error("Weapon export error", var7);
            this.showWarning("An error occured during export.");
         }
      }

   }

   public void exportCompanion(Companion var1) {
      File var2 = nomanssave.AppSettings.cF;
      if (!var2.exists() && !var2.mkdir()) {
         var2 = nomanssave.AppSettings.cD;
      }

      String var3 = "." + var1.cL().name().toLowerCase();
      cp var4 = cp.multitoolPanel();
      String var5 = sanitizeFileName(var1.getName(), var1.cL().name());
      var4.setCurrentDirectory(var2);
      var4.setSelectedFile(new File(var2, var5));
      if (var4.showSaveDialog(this.mainWindow) == 0) {
         try {
            File var6 = var4.getSelectedFile();
            if (!var6.getName().endsWith(var3)) {
               var6 = new File(var6.getParentFile(), var6.getName() + var3);
            }

            var1.isFrigateOnMission(var6);
         } catch (RuntimeException var7) {
            Logger.error("Companion export error", var7);
            this.showWarning("An error occured during export.");
         } catch (IOException var8) {
            Logger.error("Companion export error", var8);
            this.showWarning("An error occured during export.");
         }
      }

   }

   public Starship deleteMultitool() {
      JsonObject var1;
      if (this.currentSave != null && (var1 = this.currentSave.H("PlayerStateData")) != null) {
         File var2 = nomanssave.AppSettings.cF.exists() ? nomanssave.AppSettings.cF : nomanssave.AppSettings.cD;
         cT var3 = cT.discoveryPanel();
         var3.setCurrentDirectory(var2);
         if (var3.showOpenDialog(this.mainWindow) == 0) {
            try {
               File var4 = var3.getSelectedFile();
               Starship var5 = Starship.AccountPanel(var1, var4);
               this.saveModified = true;
               return var5;
            } catch (RuntimeException var6) {
               Logger.error("Ship import error", var6);
               this.showWarning("An error occured during import.");
            } catch (IOException var7) {
               Logger.error("Ship import error", var7);
               this.showWarning("An error occured during import.");
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public Multitool deleteShip() {
      JsonObject var1;
      if (this.currentSave != null && (var1 = this.currentSave.H("PlayerStateData")) != null) {
         File var2 = nomanssave.AppSettings.cF.exists() ? nomanssave.AppSettings.cF : nomanssave.AppSettings.cD;
         cv var3 = cv.frigatesPanel();
         var3.setCurrentDirectory(var2);
         if (var3.showOpenDialog(this.mainWindow) == 0) {
            try {
               File var4 = var3.getSelectedFile();
               Multitool var5 = Multitool.AboutDialogCloseListener(var1, var4);
               this.saveModified = true;
               return var5;
            } catch (RuntimeException var6) {
               Logger.error("Weapon import error", var6);
               this.showWarning("An error occured during import.");
            } catch (IOException var7) {
               Logger.error("Weapon import error", var7);
               this.showWarning("An error occured during import.");
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public Companion isFrigateOnMission() {
      JsonObject var1;
      if (this.currentSave != null && (var1 = this.currentSave.H("PlayerStateData")) != null) {
         File var2 = nomanssave.AppSettings.cF.exists() ? nomanssave.AppSettings.cF : nomanssave.AppSettings.cD;
         cp var3 = cp.multitoolPanel();
         var3.setCurrentDirectory(var2);
         if (var3.showOpenDialog(this.mainWindow) == 0) {
            try {
               File var4 = var3.getSelectedFile();
               Companion var5 = Companion.AboutDialog(var1, var4);
               this.saveModified = true;
               return var5;
            } catch (RuntimeException var6) {
               Logger.error("Companion import error", var6);
               this.showWarning("An error occured during import.");
            } catch (IOException var7) {
               Logger.error("Companion import error", var7);
               this.showWarning("An error occured during import.");
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public void backupBase(Base var1) {
      File var2 = nomanssave.AppSettings.cE;
      if (!var2.exists() && !var2.mkdir()) {
         var2 = nomanssave.AppSettings.cD;
      }

      cl var3 = cl.ar();
      String var4 = sanitizeFileName(var1.getName(), "Base");
      var3.setCurrentDirectory(var2);
      var3.setSelectedFile(new File(var2, var4));
      if (var3.showSaveDialog(this.mainWindow) == 0) {
         try {
            File var5 = var3.getSelectedFile();
            if (!var5.getName().endsWith(".pb3")) {
               var5 = new File(var5.getParentFile(), var5.getName() + ".pb3");
            }

            if (var5.exists() && JOptionPane.showConfirmDialog(this.mainWindow, "Are you sure you want to overwrite this existing backup file?", "Confirm", 2) != 0) {
               return;
            }

            BackupUtil.d(var1.cH(), var5);
         } catch (RuntimeException var6) {
            Logger.error("Base backup error", var6);
            this.showWarning("An error occured during backup.");
         } catch (IOException var7) {
            Logger.error("Base backup error", var7);
            this.showWarning("An error occured during backup.");
         } catch (GeneralSecurityException var8) {
            Logger.error("Base backup error", var8);
            this.showWarning("An error occured during backup.");
         }
      }

   }

   public boolean restoreBase(Base var1) {
      File var2 = nomanssave.AppSettings.cE.exists() ? nomanssave.AppSettings.cE : nomanssave.AppSettings.cD;
      cl var3 = cl.ar();
      var3.setCurrentDirectory(var2);
      if (var3.showOpenDialog(this.mainWindow) == 0) {
         try {
            if (JOptionPane.showConfirmDialog(this.mainWindow, "Are you sure you want to overwrite your existing base?", "Confirm", 2) != 0) {
               return false;
            }

            File var4 = var3.getSelectedFile();
            BackupUtil.e(var1.cH(), var4);
            this.saveModified = true;
            return true;
         } catch (IOException var5) {
            Logger.error("Base restore error", var5);
            this.showWarning("An error occured during backup.");
         } catch (GeneralSecurityException var6) {
            Logger.error("Base restore error", var6);
            this.showWarning("An error occured during backup.");
         }
      }

      return false;
   }

   public void backupFreighter(Freighter var1) {
      FreighterBase var2 = var1.cZ();
      if (var2 != null) {
         File var3 = nomanssave.AppSettings.cE;
         if (!var3.exists() && !var3.mkdir()) {
            var3 = nomanssave.AppSettings.cD;
         }

         cs var4 = cs.squadronPanel();
         String var5 = sanitizeFileName(var2.getName(), "Freighter");
         var4.setCurrentDirectory(var3);
         var4.setSelectedFile(new File(var3, var5));
         if (var4.showSaveDialog(this.mainWindow) == 0) {
            try {
               File var6 = var4.getSelectedFile();
               if (!var6.getName().endsWith(".fb3")) {
                  var6 = new File(var6.getParentFile(), var6.getName() + ".fb3");
               }

               if (var6.exists() && JOptionPane.showConfirmDialog(this.mainWindow, "Are you sure you want to overwrite this existing backup file?", "Confirm", 2) != 0) {
                  return;
               }

               HashMap var7 = new HashMap();
               var7.put("HomeSeed", var1.cU());
               var7.put("ResourceSeed", var1.cV());
               var7.put("Name", var1.getName());
               var7.put("TypeClass", var1.LineNumberPanel());
               var7.put("Resource", var1.cT());
               var7.put("FleetCoordination", var1.cY());
               var7.put("Hyperdrive", var1.cX());
               JsonObject var8 = this.currentSave.H("PlayerStateData");
               JsonObject var9 = var8.H("FreighterInventory").MilestonesPanel();
               JsonObject var10 = var8.H("FreighterInventory_TechOnly").MilestonesPanel();
               JsonObject var11 = var8.H("FreighterInventory_Cargo").MilestonesPanel();
               if (!var4.freighterPanel()) {
                  JsonArray var12 = var9.d("Slots");

                  int var13;
                  JsonObject var14;
                  for(var13 = 0; var13 < var12.size(); ++var13) {
                     var14 = var12.descriptionLabel(var13);
                     if (!var14.getValueAsString("Type.InventoryType").equals("Technology")) {
                        var12.editMenuItems(var13--);
                     }
                  }

                  var12 = var11.d("Slots");

                  for(var13 = 0; var13 < var12.size(); ++var13) {
                     var14 = var12.descriptionLabel(var13);
                     if (!var14.getValueAsString("Type.InventoryType").equals("Technology")) {
                        var12.editMenuItems(var13--);
                     }
                  }
               }

               var7.put("Inventory", var9);
               var7.put("InventoryTech", var10);
               var7.put("InventoryCargo", var11);
               BackupUtil.AboutDialog(var2.cH(), (Map)var7, (File)var6);
            } catch (RuntimeException var15) {
               Logger.error("Freighter backup error", var15);
               this.showWarning("An error occured during backup.");
            } catch (IOException var16) {
               Logger.error("Freighter backup error", var16);
               this.showWarning("An error occured during backup.");
            } catch (GeneralSecurityException var17) {
               Logger.error("Freighter backup error", var17);
               this.showWarning("An error occured during backup.");
            }
         }

      }
   }

   public boolean restoreFreighter(Freighter var1) {
      FreighterBase var2 = var1.cZ();
      if (var2 == null) {
         return false;
      } else {
         File var3 = nomanssave.AppSettings.cE.exists() ? nomanssave.AppSettings.cE : nomanssave.AppSettings.cD;
         cs var4 = cs.squadronPanel();
         var4.setCurrentDirectory(var3);
         if (var4.showOpenDialog(this.mainWindow) == 0) {
            try {
               if (JOptionPane.showConfirmDialog(this.mainWindow, "Are you sure you want to overwrite your existing freighter?", "Confirm", 2) != 0) {
                  return false;
               }

               File var5 = var4.getSelectedFile();
               HashMap var6 = new HashMap();
               BackupUtil.AboutDialogCloseListener(var2.cH(), var6, var5);
               JsonObject var7 = this.currentSave.H("PlayerStateData");
               boolean var8 = false;
               Iterator var10 = var6.entrySet().iterator();

               while(var10.hasNext()) {
                  Entry var9 = (Entry)var10.next();
                  if (((String)var9.getKey()).equals("HomeSeed")) {
                     var1.ah((String)var9.getValue());
                  }

                  if (((String)var9.getKey()).equals("ResourceSeed")) {
                     var1.ai((String)var9.getValue());
                  }

                  if (((String)var9.getKey()).equals("Name")) {
                     var1.setName((String)var9.getValue());
                  }

                  if (((String)var9.getKey()).equals("TypeClass")) {
                     var1.aj((String)var9.getValue());
                  }

                  if (((String)var9.getKey()).equals("Type")) {
                     var1.ag(FreighterType.valueOf((String)var9.getValue()).K());
                  }

                  if (((String)var9.getKey()).equals("Resource")) {
                     var1.ag((String)var9.getValue());
                  }

                  if (((String)var9.getKey()).equals("FleetCoordination")) {
                     var1.AboutDialogCloseListener(((Number)var9.getValue()).doubleValue());
                  }

                  if (((String)var9.getKey()).equals("Hyperdrive")) {
                     var1.AboutDialog(((Number)var9.getValue()).doubleValue());
                  }

                  if (((String)var9.getKey()).equals("Inventory")) {
                     var7.AboutDialogCloseListener("FreighterInventory", (Object)((JsonObject)var9.getValue()));
                     var8 = true;
                  }

                  if (((String)var9.getKey()).equals("InventoryTech")) {
                     var7.AboutDialogCloseListener("FreighterInventory_TechOnly", (Object)((JsonObject)var9.getValue()));
                     var8 = true;
                  }

                  if (((String)var9.getKey()).equals("InventoryCargo")) {
                     var7.AboutDialogCloseListener("FreighterInventory_Cargo", (Object)((JsonObject)var9.getValue()));
                     var8 = true;
                  }
               }

               if (var8) {
                  var1 = Freighter.showCoordinateViewer(var7);
               }

               this.freighterPanel.AccountPanel(var1);
               this.saveModified = true;
               return true;
            } catch (IOException var11) {
               Logger.error("Freighter restore error", var11);
               this.showWarning("An error occured during restore.");
            } catch (GeneralSecurityException var12) {
               Logger.error("Freighter restore error", var12);
               this.showWarning("An error occured during restore.");
            }
         }

         return false;
      }
   }

   private void openFile() {
      File var1 = ej.createFileChooser(this.saveLocation == null ? null : this.saveLocation.InventorySlotPanel());
      if (var1 != null) {
         String var2;
         File var3;
         if (var1.isDirectory()) {
            var3 = var1;
            var2 = null;
         } else {
            var3 = var1.getParentFile();
            var2 = var1.getName();
         }

         if (this.saveLocation != null) {
            if (this.saveLocation.InventorySlotPanel().isDirectory() && !this.saveLocation.InventorySlotPanel().equals(var3)) {
               this.saveLocation = null;
            } else if (this.saveLocation.InventorySlotPanel().isFile() && !this.saveLocation.InventorySlotPanel().equals(var1)) {
               this.saveLocation = null;
            }
         }

         if (this.saveLocation == null) {
            Logger.info("Loading storage: " + var3.getAbsolutePath());
            this.saveLocation = SaveLocation.detectSaveLocation(var3, this.fileChangeHandler);
         }

         if (this.saveLocation == null) {
            this.saveSlots = new SaveSlot[0];
            this.AppSettings = -1;
            this.saveFiles = new SaveFile[0];
            this.ExosuitPanel = -1;
            this.currentSave = null;
            this.accountData = null;
            this.accountJson = null;
            this.editAccountJsonMenuItem.setEnabled(false);
            this.tabbedPane.setEnabledAt(13, false);
            this.accountPanel.AboutDialog((JsonObject)null);
            this.accountModified = false;
            this.storageLabel.setText("(none)");
            this.savePathLabel.setText("(none)");
         } else {
            String var4 = SaveLocation.getStorageName(this.saveLocation);
            nomanssave.AppSettings.setProperty("GameStorage", var4);
            nomanssave.AppSettings.setProperty("GameSaveDir", this.saveLocation.InventorySlotPanel().getAbsolutePath());
            Logger.debug("Storage: " + var4);
            Logger.debug("Save Path: " + this.saveLocation.InventorySlotPanel().getAbsolutePath());
            this.saveSlots = this.saveLocation.bV();
            this.AppSettings = -1;
            this.saveFiles = new SaveFile[0];
            this.ExosuitPanel = -1;
            if (var2 != null) {
               label85:
               for(int var5 = 0; var5 < this.saveSlots.length; ++var5) {
                  if (this.saveLocation.reloadButton(var2) == this.saveSlots[var5].getIndex()) {
                     this.AppSettings = var5;
                     this.saveFiles = this.saveSlots[var5].bX();
                     int var6 = 0;

                     while(true) {
                        if (var6 >= this.saveFiles.length) {
                           break label85;
                        }

                        if (var2.equals(this.saveFiles[var6].K())) {
                           this.ExosuitPanel = var6;
                           break label85;
                        }

                        ++var6;
                     }
                  }
               }
            }

            this.accountData = null;
            this.accountJson = null;

            try {
               this.accountData = this.saveLocation.bT();
               this.accountJson = this.accountData == null ? null : this.accountData.iconCache();
               if (this.accountJson != null) {
                  this.accountJson.AboutDialog(this.accountChangeListener);
               }
            } catch (IOException var7) {
               Logger.error("Error reading account data", var7);
            }

            this.editAccountJsonMenuItem.setEnabled(this.accountJson != null);
            this.tabbedPane.setEnabledAt(13, this.accountJson != null);
            this.accountPanel.AboutDialog(this.accountJson);
            this.accountModified = false;
            this.storageLabel.setText(var4);
            this.savePathLabel.setText(this.saveLocation.InventorySlotPanel().getAbsolutePath());
         }

         this.slotComboBox.setEnabled(true);
         this.fileComboBox.setEnabled(true);
         if (this.ExosuitPanel > 0) {
            this.showWarning("The save file you have selected is not the most recent.");
         }

         this.loadSave();
      }

   }

   private void selectSlot(int var1) {
      this.AppSettings = var1;
      if (this.AppSettings < 0) {
         this.saveFiles = new SaveFile[0];
         this.ExosuitPanel = -1;
      } else {
         this.saveFiles = this.saveSlots[this.AppSettings].bX();
         this.ExosuitPanel = this.saveFiles.length > 0 ? 0 : -1;
      }

      this.loadSave();
   }

   private void selectFile(int var1) {
      this.ExosuitPanel = var1;
      this.loadSave();
   }

   public void showError(String var1) {
      EventQueue.invokeLater(new ShowErrorRunnable(this, var1));
   }

   public void showWarning(String var1) {
      EventQueue.invokeLater(new ShowWarningRunnable(this, var1));
   }

   private void loadSave() {
      this.slotComboBox.updateUI();
      this.fileComboBox.updateUI();
      this.saveModified = false;
      this.currentSave = null;
      if (this.ExosuitPanel < 0) {
         this.modifiedLabel.setText("(no file selected)");
         this.saveNameLabel.setText("(no file selected)");
         this.descriptionLabel.setText("(no file selected)");
         if (this.AppSettings >= 0) {
            Logger.info("No current save file found for " + this.saveSlots[this.AppSettings]);
            this.showError("Save file not found for " + this.saveSlots[this.AppSettings]);
         }
      } else {
         try {
            this.modifiedLabel.setText(formatDateTime(this.saveFiles[this.ExosuitPanel].lastModified()));
            this.saveNameLabel.setText(e(this.saveFiles[this.ExosuitPanel].getName()));
            this.descriptionLabel.setText(e(this.saveFiles[this.ExosuitPanel].getDescription()));
            Logger.info("Reading save file...");
            Logger.info("  Slot: " + this.saveSlots[this.AppSettings]);
            Logger.info("  Filename: " + this.saveFiles[this.ExosuitPanel].K());

            try {
               this.currentSave = this.saveFiles[this.ExosuitPanel].iconCache();
               this.currentSave.AboutDialog(this.saveChangeListener);
            } catch (JsonParseException var18) {
               Logger.info("  Error parsing JSON: " + var18.getMessage());
            }

            Logger.info("Finished.");
            this.saveModified = this.saveFiles[this.ExosuitPanel] instanceof InMemorySaveFile;
         } catch (IOException var19) {
            Logger.error("Could not load save file: " + this.saveFiles[this.ExosuitPanel].K(), var19);
            this.currentSave = null;
         }
      }

      this.tabbedPane.setSelectedIndex(0);
      JsonObject var1;
      if (this.currentSave != null && (var1 = this.currentSave.H("PlayerStateData")) != null) {
         boolean var20 = this.saveLocation.bW();
         Exosuit var21 = Exosuit.fromPlayerData(var1);
         Multitool[] var4 = Multitool.fromPlayerData(var1);
         MultitoolSettings var5 = MultitoolSettings.fromPlayerData(var1);
         Starship[] var6 = Starship.fromPlayerData(var1);
         ShipSettings var7 = ShipSettings.fromPlayerData(var1);
         SquadronPilot[] var8 = SquadronPilot.fromPlayerData(var1);
         Freighter var9 = Freighter.showCoordinateViewer(var1);
         Frigate[] var10 = Frigate.editRawJson(var1);
         Vehicle[] var11 = Vehicle.fromPlayerData(var1);
         SettlementState[] var12 = SettlementState.fromPlayerData(var1);
         boolean var13 = Companion.saveFile(var1);
         Companion[] var14 = Companion.saveFileAs(var1);
         Settlement var15 = Settlement.saveAccountData(var1);
         this.tabbedPane.setEnabledAt(1, var21 != null);
         this.exosuitPanel.AboutDialog(var21);
         this.tabbedPane.setEnabledAt(2, var4.length > 0);
         this.multitoolPanel.AboutDialog(var4, var5);
         this.tabbedPane.setEnabledAt(3, var6.length > 0);
         this.shipsPanel.AboutDialog(var6, var7);
         this.tabbedPane.setEnabledAt(4, var8.length > 0);
         this.squadronPanel.AboutDialog(var8);
         this.tabbedPane.setEnabledAt(5, var9 != null);
         this.freighterPanel.AccountPanel(var9);
         this.tabbedPane.setEnabledAt(6, var9 != null);
         this.frigatesPanel.AboutDialog(var10);
         this.tabbedPane.setEnabledAt(7, var11.length > 0);
         this.vehiclesPanel.AboutDialog(var11);
         this.tabbedPane.setEnabledAt(8, var13);
         this.companionsPanel.AboutDialog(var14);
         this.tabbedPane.setEnabledAt(9, var15 != null);
         this.basesStoragePanel.AboutDialog(var15);
         this.tabbedPane.setEnabledAt(10, var12.length > 0);
         this.settlementsPanel.AboutDialog(var12);
         this.tabbedPane.setEnabledAt(11, var21 != null);
         this.discoveryPanel.AboutDialog(var21);
         this.tabbedPane.setEnabledAt(12, var21 != null);
         this.milestonesPanel.updateMilestones(var21);
         this.reloadButton.setEnabled(!(this.saveFiles[this.ExosuitPanel] instanceof InMemorySaveFile));
         this.CompanionsPanel.setEnabled(true);
         this.saveAsButton.setEnabled(var20);
         this.reloadMenuItem.setEnabled(true);
         this.saveMenuItem.setEnabled(true);
         this.saveAsMenuItem.setEnabled(var20);
         Iterator var17 = this.editMenuItems.iterator();

         while(var17.hasNext()) {
            JMenuItem var16 = (JMenuItem)var17.next();
            var16.setEnabled(true);
         }
      } else {
         this.reloadButton.setEnabled(false);
         this.CompanionsPanel.setEnabled(false);
         this.saveAsButton.setEnabled(false);
         this.reloadMenuItem.setEnabled(false);
         this.saveMenuItem.setEnabled(false);
         this.saveAsMenuItem.setEnabled(false);
         Iterator var3 = this.editMenuItems.iterator();

         while(var3.hasNext()) {
            JMenuItem var2 = (JMenuItem)var3.next();
            var2.setEnabled(false);
         }

         this.exosuitPanel.AboutDialog((Exosuit)null);
         this.multitoolPanel.AboutDialog((Multitool[])(new Multitool[0]), (MultitoolSettings)null);
         this.shipsPanel.AboutDialog((Starship[])(new Starship[0]), (ShipSettings)null);
         this.squadronPanel.AboutDialog(new SquadronPilot[0]);
         this.freighterPanel.AccountPanel((Freighter)null);
         this.frigatesPanel.AboutDialog(new Frigate[0]);
         this.vehiclesPanel.AboutDialog(new Vehicle[0]);
         this.companionsPanel.AboutDialog(new Companion[0]);
         this.basesStoragePanel.AboutDialog((Settlement)null);
         this.settlementsPanel.AboutDialog(new SettlementState[0]);
         this.discoveryPanel.AboutDialog((Exosuit)null);
         this.milestonesPanel.updateMilestones((Exosuit)null);
         this.tabbedPane.setEnabledAt(1, false);
         this.tabbedPane.setEnabledAt(2, false);
         this.tabbedPane.setEnabledAt(3, false);
         this.tabbedPane.setEnabledAt(4, false);
         this.tabbedPane.setEnabledAt(5, false);
         this.tabbedPane.setEnabledAt(6, false);
         this.tabbedPane.setEnabledAt(7, false);
         this.tabbedPane.setEnabledAt(8, false);
         this.tabbedPane.setEnabledAt(9, false);
         this.tabbedPane.setEnabledAt(11, false);
         this.tabbedPane.setEnabledAt(12, false);
         if (this.ExosuitPanel >= 0) {
            if (this.currentSave == null) {
               this.showError("There was an error loading the file.");
            } else {
               this.showError("Save file corrupted");
            }
         }
      }

   }

   private void saveAccountData() {
      try {
         this.accountData.k(this.accountJson);
         this.accountModified = false;
      } catch (Exception var2) {
         Logger.error("Error saving account data", var2);
         this.showWarning("An error occured saving the account data.");
      }

   }

   private void saveFile() {
      if (this.ExosuitPanel < 0) {
         this.showError("No save file selected.");
      } else {
         try {
            Logger.info("Formatting JSON...");
            String var1 = this.saveFiles[this.ExosuitPanel].writeToFile(this.currentSave);
            this.saveFiles = this.saveSlots[this.AppSettings].bX();
            this.ExosuitPanel = -1;

            for(int var2 = 0; var2 < this.saveFiles.length; ++var2) {
               if (var1.equals(this.saveFiles[var2].K())) {
                  this.ExosuitPanel = var2;
                  break;
               }
            }

            this.saveModified = false;
            this.slotComboBox.updateUI();
            this.fileComboBox.updateUI();
            if (this.ExosuitPanel < 0) {
               this.modifiedLabel.setText("(no file selected)");
               this.saveNameLabel.setText("(no file selected)");
               this.descriptionLabel.setText("(no file selected)");
            } else {
               this.modifiedLabel.setText(formatDateTime(this.saveFiles[this.ExosuitPanel].lastModified()));
               this.saveNameLabel.setText(e(this.saveFiles[this.ExosuitPanel].getName()));
               this.descriptionLabel.setText(e(this.saveFiles[this.ExosuitPanel].getDescription()));
            }

            Logger.info("Finished.");
         } catch (IOException var3) {
            Logger.error("Could not write save file: " + this.saveFiles[this.ExosuitPanel].K(), var3);
            this.showError("There was an error saving the file.");
         }

      }
   }

   private void saveFileAs() {
      int var1 = this.saveSlots[this.AppSettings].getIndex();
      int var2 = dz.show(this.mainWindow, this.saveLocation.bU(), var1);
      if (var2 >= 0 && var2 != var1) {
         try {
            Logger.info("Formatting JSON...");
            Logger.info("Creating game slot...");
            String var3 = this.saveLocation.AboutDialog(var2, this.currentSave);
            this.saveSlots = this.saveLocation.bV();
            this.AppSettings = -1;
            this.saveFiles = new SaveFile[0];
            this.ExosuitPanel = -1;

            label38:
            for(int var4 = 0; var4 < this.saveSlots.length; ++var4) {
               if (this.saveLocation.reloadButton(var3) == this.saveSlots[var4].getIndex()) {
                  this.AppSettings = var4;
                  this.saveFiles = this.saveSlots[var4].bX();
                  int var5 = 0;

                  while(true) {
                     if (var5 >= this.saveFiles.length) {
                        break label38;
                     }

                     if (var3.equals(this.saveFiles[var5].K())) {
                        this.ExosuitPanel = var5;
                        break label38;
                     }

                     ++var5;
                  }
               }
            }

            this.saveModified = false;
            this.slotComboBox.updateUI();
            this.fileComboBox.updateUI();
            if (this.ExosuitPanel < 0) {
               this.modifiedLabel.setText("(no file selected)");
               this.saveNameLabel.setText("(no file selected)");
               this.descriptionLabel.setText("(no file selected)");
            } else {
               this.modifiedLabel.setText(formatDateTime(this.saveFiles[this.ExosuitPanel].lastModified()));
               this.saveNameLabel.setText(e(this.saveFiles[this.ExosuitPanel].getName()));
               this.descriptionLabel.setText(e(this.saveFiles[this.ExosuitPanel].getDescription()));
            }

            Logger.info("Finished.");
         } catch (IOException var6) {
            Logger.error("Could not write save file", var6);
            this.showError("There was an error saving the file.");
            return;
         }
      }

   }

   public List getInventoriesWithType(int var1) {
      ArrayList var2 = new ArrayList();
      Exosuit var4 = this.exosuitPanel.CompanionsPanel();
      if (var4 != null) {
         var2.addAll((Collection)var4.cC().stream().filter((var1x) -> {
            return var1x.vehiclesPanel(var1);
         }).collect(Collectors.toList()));
      }

      Multitool[] var5 = this.multitoolPanel.currentSave();

      for(int var6 = 0; var6 < var5.length; ++var6) {
         Inventory var3;
         if ((var3 = var5[var6].SettlementsPanel()) != null && var3.vehiclesPanel(var1)) {
            var2.add(var3);
         }
      }

      Starship[] var10 = this.shipsPanel.accountModified();

      for(int var7 = 0; var7 < var10.length; ++var7) {
         var2.addAll((Collection)var10[var7].cC().stream().filter((var1x) -> {
            return var1x.vehiclesPanel(var1);
         }).collect(Collectors.toList()));
      }

      Freighter var11 = this.freighterPanel.reloadMenuItem();
      if (var11 != null) {
         var2.addAll((Collection)var11.cC().stream().filter((var1x) -> {
            return var1x.vehiclesPanel(var1);
         }).collect(Collectors.toList()));
      }

      Vehicle[] var8 = this.vehiclesPanel.aT();

      for(int var9 = 0; var9 < var8.length; ++var9) {
         var2.addAll((Collection)var8[var9].cC().stream().filter((var1x) -> {
            return var1x.vehiclesPanel(var1);
         }).collect(Collectors.toList()));
      }

      Settlement var12 = this.basesStoragePanel.tabbedPane();
      if (var12 != null) {
         var2.addAll((Collection)var12.cC().stream().filter((var1x) -> {
            return var1x.vehiclesPanel(var1);
         }).collect(Collectors.toList()));
      }

      return var2;
   }

   private void showCoordinateViewer() {
      JsonObject var1 = this.currentSave.H("PlayerStateData.UniverseAddress");
      GalacticAddress var2 = GalacticAddress.saveFile(var1);
      if ((var2 = nomanssave.aj.AboutDialog((Container)this.mainWindow, var2)) != null) {
         var2.saveModified(0);
         this.currentSave.AboutDialogCloseListener("PlayerStateData.UniverseAddress", (Object)var2.ew());
         this.currentSave.AboutDialogCloseListener("PlayerStateData.PreviousUniverseAddress", (Object)var1);
         this.currentSave.AboutDialogCloseListener("SpawnStateData.LastKnownPlayerState", (Object)"InShip");
         this.saveModified = true;
      }

   }

   private void editRawJson() {
      Logger.info("Starting JSON Editor...");
      if (JsonEditorDialog.AboutDialog(this, this.saveFiles[this.ExosuitPanel].K(), this.currentSave)) {
         this.refreshPanels();
      }

   }

   private void editAccountJson() {
      Logger.info("Starting JSON Editor...");
      if (JsonEditorDialog.AboutDialog(this, this.accountData.K(), this.accountJson)) {
         try {
            this.accountData.k(this.accountJson);
         } catch (IOException var2) {
            Logger.error("JSON Save error", var2);
            this.showWarning("An error occured saving the account data.");
         }
      }

   }

   private static void updateComponentTreeUI(Window var0) {
      SwingUtilities.updateComponentTreeUI(var0);
      Window[] var4;
      int var3 = (var4 = var0.getOwnedWindows()).length;

      for(int var2 = 0; var2 < var3; ++var2) {
         Window var1 = var4[var2];
         updateComponentTreeUI(var1);
      }

   }

   private void changeTheme() {
      if (nomanssave.milestonesPanel.d(this.mainWindow)) {
         nomanssave.AppSettings.descriptionLabel();
         updateComponentTreeUI((Window)this.mainWindow);
      }

   }

   private void refreshPanels() {
      this.saveModified = true;
      JsonObject var1 = this.currentSave.H("PlayerStateData");
      Exosuit var2 = Exosuit.fromPlayerData(var1);
      Multitool[] var3 = Multitool.fromPlayerData(var1);
      MultitoolSettings var4 = MultitoolSettings.fromPlayerData(var1);
      Starship[] var5 = Starship.fromPlayerData(var1);
      SquadronPilot[] var6 = SquadronPilot.fromPlayerData(var1);
      ShipSettings var7 = ShipSettings.fromPlayerData(var1);
      Freighter var8 = Freighter.showCoordinateViewer(var1);
      Frigate[] var9 = Frigate.editRawJson(var1);
      Vehicle[] var10 = Vehicle.fromPlayerData(var1);
      SettlementState[] var11 = SettlementState.fromPlayerData(var1);
      boolean var12 = Companion.saveFile(var1);
      Companion[] var13 = Companion.saveFileAs(var1);
      Settlement var14 = Settlement.saveAccountData(var1);
      this.tabbedPane.setEnabledAt(1, var2 != null);
      this.exosuitPanel.AboutDialog(var2);
      this.tabbedPane.setEnabledAt(2, var3.length > 0);
      this.multitoolPanel.AboutDialog(var3, var4);
      this.tabbedPane.setEnabledAt(3, var5.length > 0);
      this.shipsPanel.AboutDialog(var5, var7);
      this.tabbedPane.setEnabledAt(4, var6.length > 0);
      this.squadronPanel.AboutDialog(var6);
      this.tabbedPane.setEnabledAt(5, var8 != null);
      this.freighterPanel.AccountPanel(var8);
      this.tabbedPane.setEnabledAt(6, var8 != null);
      this.frigatesPanel.AboutDialog(var9);
      this.tabbedPane.setEnabledAt(7, var10.length > 0);
      this.vehiclesPanel.AboutDialog(var10);
      this.tabbedPane.setEnabledAt(8, var12);
      this.companionsPanel.AboutDialog(var13);
      this.tabbedPane.setEnabledAt(9, var14 != null);
      this.basesStoragePanel.AboutDialog(var14);
      this.tabbedPane.setEnabledAt(10, var11.length > 0);
      this.settlementsPanel.AboutDialog(var11);
      this.tabbedPane.setEnabledAt(11, var2 != null);
      this.discoveryPanel.AboutDialog(var2);
      this.tabbedPane.setEnabledAt(12, var2 != null);
      this.milestonesPanel.updateMilestones(var2);
   }

   private void exportJson() {
      Logger.info("Exporting JSON...");
      cK var1 = cK.basesStoragePanel();
      String var2 = this.saveFiles[this.ExosuitPanel].K() + ".json";
      var1.setCurrentDirectory(nomanssave.AppSettings.cF);
      var1.setSelectedFile(new File(nomanssave.AppSettings.cF, var2));
      if (var1.showSaveDialog(this.mainWindow) == 0) {
         try {
            File var3 = var1.getSelectedFile();
            if (!var3.getName().endsWith(".json")) {
               var3 = new File(var3.getParentFile(), var3.getName() + ".json");
            }

            if (var3.exists() && JOptionPane.showConfirmDialog(this.mainWindow, "Are you sure you want to overwrite this existing JSON file?", "Confirm", 2) != 0) {
               return;
            }

            this.currentSave.AccountPanel(var3);
         } catch (IOException var4) {
            Logger.error("JSON Export error", var4);
            this.showWarning("An error occured exporting the save data.");
         }
      }

   }

   private void importJson() {
      Logger.info("Importing JSON...");
      cK var1 = cK.basesStoragePanel();
      var1.setCurrentDirectory(nomanssave.AppSettings.cF);
      if (var1.showOpenDialog(this.mainWindow) == 0) {
         try {
            if (JOptionPane.showConfirmDialog(this.mainWindow, "Are you sure you want to update your current save data?", "Confirm", 2) != 0) {
               return;
            }

            File var2 = var1.getSelectedFile();
            this.currentSave.d(var2);
            this.refreshPanels();
         } catch (IOException var3) {
            Logger.error("JSON Import error", var3);
            this.showWarning("An error occured importing the save data.");
         }
      }

   }

   private void rechargeAllTechnology() {
      this.exosuitPanel.rechargeAllTechnology();
      this.multitoolPanel.rechargeAllTechnology();
      this.shipsPanel.rechargeAllTechnology();
      this.freighterPanel.rechargeAllTechnology();
      this.vehiclesPanel.rechargeAllTechnology();
      this.basesStoragePanel.rechargeAllTechnology();
   }

   private void refillAllStacks() {
      this.exosuitPanel.refillAllStacks();
      this.multitoolPanel.refillAllStacks();
      this.shipsPanel.refillAllStacks();
      this.freighterPanel.refillAllStacks();
      this.vehiclesPanel.refillAllStacks();
      this.basesStoragePanel.refillAllStacks();
   }

   private void enableAllSlots() {
      this.exosuitPanel.enableAllSlots();
      this.multitoolPanel.enableAllSlots();
      this.shipsPanel.enableAllSlots();
      this.freighterPanel.enableAllSlots();
      this.vehiclesPanel.enableAllSlots();
      this.basesStoragePanel.enableAllSlots();
   }

   private void repairAllSlots() {
      this.multitoolPanel.repairAllSlots();
      this.shipsPanel.repairAllSlots();
   }

   private void expandAllInventories() {
      this.exosuitPanel.expandAllInventories();
      this.multitoolPanel.expandAllInventories();
      this.shipsPanel.expandAllInventories();
      this.freighterPanel.expandAllInventories();
      this.vehiclesPanel.expandAllInventories();
      this.basesStoragePanel.expandAllInventories();
   }

   public void updateInventory(Inventory var1) {
      this.exosuitPanel.AboutDialog(var1);
      this.multitoolPanel.AboutDialog(var1);
      this.shipsPanel.AboutDialog(var1);
      this.freighterPanel.AboutDialog(var1);
      this.vehiclesPanel.AboutDialog(var1);
      this.basesStoragePanel.AboutDialog(var1);
   }

   public void WindowCloseListener() {
      this.milestonesPanel.WindowCloseListener();
   }

   public void C() {
      this.milestonesPanel.C();
   }

   public JsonArray d(String var1) {
      return this.currentSave.d(var1);
   }

   public boolean hasNewSaveFormat() {
      return this.currentSave.getValue("PlayerStateData.DifficultyState") != null;
   }

   public String getStackLimitsDifficulty() {
      return this.currentSave.getValueAsString("PlayerStateData.DifficultyState.Settings.InventoryStackLimits.InventoryStackLimitsDifficulty");
   }

   public GameMode getGameMode() {
      String var1 = this.currentSave.getValueAsString("PlayerStateData.DifficultyState.Preset.DifficultyPresetType");
      GameMode var2;
      if (var1 != null) {
         GameMode[] var5;
         int var4 = (var5 = GameMode.values()).length;

         for(int var3 = 0; var3 < var4; ++var3) {
            var2 = var5[var3];
            if (var1.equalsIgnoreCase(var2.name())) {
               return var2;
            }
         }
      }

      var2 = this.saveFiles[this.ExosuitPanel].instance();
      if (var2 == GameMode.lr) {
         String var6 = this.currentSave.getValueAsString("PlayerStateData.SeasonData.GameMode.PresetGameMode");
         if ("Normal".equals(var6)) {
            var2 = GameMode.lm;
         }

         if ("Creative".equals(var6)) {
            var2 = GameMode.lo;
         }

         if ("Survival".equals(var6)) {
            var2 = GameMode.ln;
         }

         if ("Ambient".equals(var6)) {
            var2 = GameMode.lp;
         }

         if ("Permadeath".equals(var6)) {
            var2 = GameMode.lq;
         }
      }

      return var2;
   }

   public void deleteMultitool(int var1) {
      JsonObject var2 = this.currentSave.H("PlayerStateData");
      JsonArray var3 = var2.d("Multitools");
      if (var3 != null && var3.size() != 0) {
         JsonObject var4 = TemplateLoader.loadTemplate("multitool");
         if (var1 >= 0 && var1 < var3.size() && var4 != null) {
            var3.remove(var1);
            var3.add(var4);
            MultitoolSettings var5 = MultitoolSettings.fromPlayerData(var2);
            int var6 = var5.dU();
            if (var6 > 0 && var6 >= var1) {
               --var6;
               var5.saveLocation(var6);
            }

            this.multitoolPanel.AboutDialog(Multitool.fromPlayerData(var2), var5);
         }
      }
   }

   public void deleteShip(int var1) {
      JsonObject var2 = this.currentSave.H("PlayerStateData");
      JsonArray var3 = var2.d("ShipOwnership");
      if (var3 != null && var3.size() != 0) {
         JsonObject var4 = TemplateLoader.loadTemplate("ship");
         if (var1 >= 0 && var1 < var3.size() && var4 != null) {
            var3.remove(var1);
            var3.add(var4);
            ShipSettings var5 = ShipSettings.fromPlayerData(var2);
            int var6 = var5.dV();
            if (var6 > 0 && var6 >= var1) {
               --var6;
               var5.saveSlots(var6);
            }

            this.shipsPanel.AboutDialog(Starship.fromPlayerData(var2), var5);
         }
      }
   }

   public void deleteCompanion(gl var1, int var2) {
      JsonObject var3 = this.currentSave.H("PlayerStateData");
      JsonArray var4;
      switch(BasesStoragePanel()[var1.ordinal()]) {
      case 1:
         var4 = var3.d("Pets");
         break;
      case 2:
         var4 = var3.d("Eggs");
         break;
      default:
         return;
      }

      if (var4 != null && var4.size() != 0) {
         JsonObject var5 = TemplateLoader.loadTemplate("companion");
         if (var2 >= 0 && var2 < var4.size() && var5 != null) {
            var4.remove(var2);
            var4.add(var5);
            this.companionsPanel.AboutDialog(Companion.saveFileAs(var3));
         }
      }
   }

   public boolean isFrigateOnMission(int var1) {
      JsonArray var2 = this.currentSave.d("PlayerStateData.FleetExpeditions");

      for(int var3 = 0; var3 < var2.size(); ++var3) {
         JsonArray var4 = var2.descriptionLabel(var3).d("AllFrigateIndices");
         if (var4.hasValue(new Integer(var1))) {
            return true;
         }
      }

      return false;
   }

   public Frigate[] deleteFrigate(int var1) {
      JsonArray var2 = this.currentSave.d("PlayerStateData.FleetFrigates");
      JsonArray var3 = this.currentSave.d("PlayerStateData.FleetExpeditions");

      int var4;
      for(var4 = 0; var4 < var3.size(); ++var4) {
         JsonArray var5 = var3.descriptionLabel(var4).d("AllFrigateIndices");
         if (var5.hasValue(new Integer(var1))) {
            this.showWarning("This frigate is currently on a mission and cannot be deleted!");
            return Frigate.d(var2);
         }
      }

      if (var2 != null && var1 < var2.size()) {
         var2.editMenuItems(var1);

         for(int var9 = 0; var9 < var3.size(); ++var9) {
            JsonObject var12 = var3.descriptionLabel(var9);
            JsonArray var7 = var12.d("ActiveFrigateIndices");

            int var10;
            for(var10 = 0; var10 < var7.size(); ++var10) {
               if ((var4 = var7.saveAsButton(var10)) > var1) {
                  var7.AboutDialog(var10, var4 - 1);
               }
            }

            var7 = var12.d("DamagedFrigateIndices");

            for(var10 = 0; var10 < var7.size(); ++var10) {
               if ((var4 = var7.saveAsButton(var10)) > var1) {
                  var7.AboutDialog(var10, var4 - 1);
               }
            }

            var7 = var12.d("DestroyedFrigateIndices");

            for(var10 = 0; var10 < var7.size(); ++var10) {
               if ((var4 = var7.saveAsButton(var10)) > var1) {
                  var7.AboutDialog(var10, var4 - 1);
               }
            }

            var7 = var12.d("AllFrigateIndices");

            for(var10 = 0; var10 < var7.size(); ++var10) {
               if ((var4 = var7.saveAsButton(var10)) > var1) {
                  var7.AboutDialog(var10, var4 - 1);
               }
            }

            JsonArray var8 = var12.d("Events");

            for(var10 = 0; var10 < var7.size(); ++var10) {
               JsonObject var6 = var8.descriptionLabel(var10);
               var7 = var6.d("AffectedFrigateIndices");

               int var11;
               for(var11 = 0; var11 < var7.size(); ++var11) {
                  if ((var4 = var7.saveAsButton(var11)) > var1) {
                     var7.AboutDialog(var11, var4 - 1);
                  }
               }

               var7 = var6.d("RepairingFrigateIndices");

               for(var11 = 0; var11 < var7.size(); ++var11) {
                  if ((var4 = var7.saveAsButton(var11)) > var1) {
                     var7.AboutDialog(var11, var4 - 1);
                  }
               }

               var7 = var6.d("AffectedFrigateResponses");

               for(var11 = 0; var11 < var7.size(); ++var11) {
                  if ((var4 = var7.saveAsButton(var11)) > var1) {
                     var7.AboutDialog(var11, var4 - 1);
                  }
               }
            }
         }

         this.saveModified = true;
      }

      return Frigate.d(var2);
   }

   public Frigate[] renameFrigate(int var1, String var2) {
      JsonArray var3 = this.currentSave.d("PlayerStateData.FleetFrigates");
      if (var3 != null && var1 < var3.size()) {
         JsonObject var4 = var3.descriptionLabel(var1).MilestonesPanel();
         var4.d("ResourceSeed").AboutDialog(1, var2);
         var4.AboutDialogCloseListener("CustomName", (Object)"");
         var3.selectFile(var4);
         this.saveModified = true;
      }

      return Frigate.d(var3);
   }

   private void rechargeBasePlanters() {
      int var1 = this.currentSave.J("PlayerStateData.TotalPlayTime");
      int var2 = 0;
      JsonArray var3 = this.currentSave.d("PlayerStateData.PersistentPlayerBases");

      int var4;
      JsonArray var5;
      int var6;
      for(var4 = 0; var4 < var3.size(); ++var4) {
         var5 = var3.descriptionLabel(var4).d("Objects");

         for(var6 = 0; var6 < var5.size(); ++var6) {
            String var7 = var5.descriptionLabel(var6).getValueAsString("ObjectID");
            if ("^PLANTER".equals(var7)) {
               ++var2;
            } else if ("^PLANTERMEGA".equals(var7)) {
               ++var2;
            }
         }
      }

      var5 = this.currentSave.d("PlayerStateData.MaintenanceInteractions");

      for(var6 = 0; var6 < var5.size(); ++var6) {
         JsonObject var11 = var5.descriptionLabel(var6);
         JsonArray var8 = var11.d("InventoryContainer.Slots");

         for(int var9 = 0; var9 < var8.size(); ++var9) {
            JsonObject var10 = var8.descriptionLabel(var9);
            if ("^MAINT_FARM5".equals(var10.getValueAsString("Id"))) {
               if ((var4 = var10.J("MaxAmount")) > 0 && var10.J("Amount") < var4) {
                  var10.AboutDialogCloseListener("Amount", (Object)(new Integer(var4)));
               }

               var11.AboutDialogCloseListener("LastUpdateTimestamp", (Object)(new Integer(var1)));
               this.saveModified = true;
               --var2;
            }
         }
      }

   }

   private void initialize() {
      this.mainWindow = new JFrame();
      ImageIcon var1 = AboutDialog("UI-FILEICON.PNG");
      if (var1 != null) {
         this.mainWindow.setIconImage(var1.getImage());
      }

      this.mainWindow.setTitle("No Man's Sky Save Editor - 1.19.14 (BREACH)");
      Rectangle var2 = new Rectangle(100, 100, 1100, 720);
      var2.UpdateCheckThread = nomanssave.AppSettings.AboutDialog("MainFrame.X", 100);
      var2.UpdateDownloadRunnable = nomanssave.AppSettings.AboutDialog("MainFrame.Y", 100);
      var2.width = nomanssave.AppSettings.AboutDialog("MainFrame.Width", 1000);
      var2.height = nomanssave.AppSettings.AboutDialog("MainFrame.Height", 700);
      this.mainWindow.setBounds(var2);
      this.mainWindow.setDefaultCloseOperation(3);
      this.mainWindow.addWindowListener(new WindowCloseListener(this));
      this.mainWindow.addComponentListener(new C(this));
      this.tabbedPane = new JTabbedPane(1);
      this.mainWindow.getContentPane().add(this.tabbedPane, "Center");
      FormPanel var3 = new FormPanel(new int[]{nomanssave.AppSettings.cH, nomanssave.AppSettings.cI, 0});
      this.tabbedPane.addTab("Main", (Icon)null, var3, (String)null);
      var3.k("File Details");
      this.storageLabel = new JLabel();
      this.storageLabel.setText(this.saveLocation == null ? "" : SaveLocation.getStorageName(this.saveLocation));
      var3.AboutDialog("Storage", this.storageLabel, 2);
      this.savePathLabel = new JLabel();
      this.savePathLabel.setText(this.saveLocation == null ? "(no path selected)" : this.saveLocation.InventorySlotPanel().getAbsolutePath());
      var3.AboutDialog("Save Path", this.savePathLabel, 2);
      this.slotComboBox = new JComboBox();
      this.slotComboBox.setModel(new SlotComboBoxModel(this));
      this.slotComboBox.setEnabled(this.saveLocation != null);
      var3.AboutDialog("Game Slot", (JComponent)this.slotComboBox);
      this.fileComboBox = new JComboBox();
      this.fileComboBox.setEditable(false);
      this.fileComboBox.setModel(new FileComboBoxModel(this));
      this.fileComboBox.setEnabled(this.saveLocation != null);
      var3.AboutDialog("Save File", (JComponent)this.fileComboBox);
      this.modifiedLabel = new JLabel();
      this.modifiedLabel.setText("(no file selected)");
      var3.AboutDialog("Modified", this.modifiedLabel, 2);
      this.saveNameLabel = new JLabel();
      this.saveNameLabel.setText("(no file selected)");
      var3.AboutDialog("Save Name", this.saveNameLabel, 2);
      this.descriptionLabel = new JLabel();
      this.descriptionLabel.setText("(no file selected)");
      var3.AboutDialog("Description", this.descriptionLabel, 2);
      var3.saveAsButton();
      JPanel var4 = new JPanel();
      var4.setLayout(new FlowLayout(0, 0, 0));
      this.reloadButton = new JButton("Reload");
      this.reloadButton.setEnabled(false);
      this.reloadButton.addActionListener((var1x) -> {
         this.loadSave();
      });
      var4.add(this.reloadButton);
      this.CompanionsPanel = new JButton("Save Changes");
      this.CompanionsPanel.setEnabled(false);
      this.CompanionsPanel.addActionListener((var1x) -> {
         this.saveFile();
      });
      var4.add(this.CompanionsPanel);
      this.saveAsButton = new JButton("Save As");
      this.saveAsButton.setEnabled(false);
      this.saveAsButton.addActionListener((var1x) -> {
         this.saveFileAs();
      });
      var4.add(this.saveAsButton);
      var3.AboutDialog((String)null, var4, 2);
      this.exosuitPanel = new ExosuitPanel(this);
      this.tabbedPane.addTab("Exosuit", (Icon)null, this.exosuitPanel, (String)null);
      this.tabbedPane.setEnabledAt(1, false);
      this.multitoolPanel = new MultitoolPanel(this);
      this.tabbedPane.addTab("Multitool", (Icon)null, this.multitoolPanel, (String)null);
      this.tabbedPane.setEnabledAt(2, false);
      this.shipsPanel = new ShipsPanel(this);
      this.tabbedPane.addTab("Ships", (Icon)null, this.shipsPanel, (String)null);
      this.tabbedPane.setEnabledAt(3, false);
      this.squadronPanel = new SquadronPanel(this);
      this.tabbedPane.addTab("Squadron", (Icon)null, this.squadronPanel, (String)null);
      this.tabbedPane.setEnabledAt(4, false);
      this.freighterPanel = new FreighterPanel(this);
      this.tabbedPane.addTab("Freighter", (Icon)null, this.freighterPanel, (String)null);
      this.tabbedPane.setEnabledAt(5, false);
      this.frigatesPanel = new FrigatesPanel(this);
      this.tabbedPane.addTab("Frigates", (Icon)null, this.frigatesPanel, (String)null);
      this.tabbedPane.setEnabledAt(6, false);
      this.vehiclesPanel = new VehiclesPanel(this);
      this.tabbedPane.addTab("Vehicles", (Icon)null, this.vehiclesPanel, (String)null);
      this.tabbedPane.setEnabledAt(7, false);
      this.companionsPanel = new CompanionsPanel(this);
      this.tabbedPane.addTab("Companions", (Icon)null, this.companionsPanel, (String)null);
      this.tabbedPane.setEnabledAt(8, false);
      this.basesStoragePanel = new BasesStoragePanel(this);
      this.tabbedPane.addTab("Bases & Storage", (Icon)null, this.basesStoragePanel, (String)null);
      this.tabbedPane.setEnabledAt(9, false);
      this.settlementsPanel = new SettlementsPanel(this);
      this.tabbedPane.addTab("Settlements", (Icon)null, this.settlementsPanel, (String)null);
      this.tabbedPane.setEnabledAt(10, false);
      this.discoveryPanel = new DiscoveryPanel(this);
      this.tabbedPane.addTab("Discovery", (Icon)null, this.discoveryPanel, (String)null);
      this.tabbedPane.setEnabledAt(11, false);
      this.milestonesPanel = new MilestonesPanel(this);
      this.tabbedPane.addTab("Milestones / Reputation", (Icon)null, this.milestonesPanel, (String)null);
      this.tabbedPane.setEnabledAt(12, false);
      this.accountPanel = new AccountPanel(this);
      this.tabbedPane.addTab("Account", (Icon)null, this.accountPanel, (String)null);
      this.tabbedPane.setEnabledAt(13, false);
      this.tabbedPane.addChangeListener((var1x) -> {
         if (this.tabbedPane.getSelectedIndex() == 12) {
            this.milestonesPanel.saveMenuItem();
         }

         if (this.saveLocation != null && this.accountModified && this.aP) {
            int var2 = JOptionPane.showConfirmDialog(this.mainWindow, "Save account data?", "Save", 0);
            this.aP = var2 == 0;
            if (this.aP) {
               this.saveAccountData();
            }
         }

      });
      JMenuBar var5 = new JMenuBar();
      this.mainWindow.setJMenuBar(var5);
      JMenu var6 = new JMenu("File");
      var5.add(var6);
      JMenuItem var7 = new JMenuItem("Open File/Path");
      var7.setAccelerator(KeyStroke.getKeyStroke(79, 2));
      var7.addActionListener((var1x) -> {
         this.openFile();
      });
      var6.add(var7);
      this.reloadMenuItem = new JMenuItem("Reload File");
      this.reloadMenuItem.setEnabled(false);
      this.reloadMenuItem.setAccelerator(KeyStroke.getKeyStroke(82, 2));
      this.reloadMenuItem.addActionListener((var1x) -> {
         this.loadSave();
      });
      var6.add(this.reloadMenuItem);
      this.saveMenuItem = new JMenuItem("Save File");
      this.saveMenuItem.setEnabled(false);
      this.saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(83, 2));
      this.saveMenuItem.addActionListener((var1x) -> {
         Component var2 = this.mainWindow.getFocusOwner();
         if (var2 instanceof ValidatedTextField) {
            ((ValidatedTextField)var2).mainWindow();
         }

         this.saveFile();
      });
      var6.add(this.saveMenuItem);
      this.saveAsMenuItem = new JMenuItem("Save File As");
      this.saveAsMenuItem.setEnabled(false);
      this.saveAsMenuItem.addActionListener((var1x) -> {
         Component var2 = this.mainWindow.getFocusOwner();
         if (var2 instanceof ValidatedTextField) {
            ((ValidatedTextField)var2).mainWindow();
         }

         this.saveFileAs();
      });
      var6.add(this.saveAsMenuItem);
      var6.addSeparator();
      JMenuItem var8 = new JMenuItem("Exit");
      var8.addActionListener((var1x) -> {
         if (this.saveModified || this.accountModified) {
            int var2 = JOptionPane.showConfirmDialog(this.mainWindow, "Save data before closing?", "Save", 0);
            if (var2 == 0) {
               if (this.saveModified) {
                  this.saveFile();
               }

               if (this.accountModified) {
                  this.saveAccountData();
               }
            }
         }

         this.mainWindow.dispose();
      });
      var6.add(var8);
      JMenu var9 = new JMenu("Edit");
      var5.add(var9);
      this.editMenuItems = new ArrayList();
      JMenuItem var10 = new JMenuItem("Edit Raw JSON");
      var10.addActionListener((var1x) -> {
         this.editRawJson();
      });
      var9.add(var10);
      this.editMenuItems.add(var10);
      JMenuItem var11 = new JMenuItem("Export JSON");
      var11.addActionListener((var1x) -> {
         this.exportJson();
      });
      var9.add(var11);
      this.editMenuItems.add(var11);
      JMenuItem var12 = new JMenuItem("Import JSON");
      var12.addActionListener((var1x) -> {
         this.importJson();
      });
      var9.add(var12);
      this.editMenuItems.add(var12);
      JMenuItem var13 = new JMenuItem("Coordinate Viewer");
      var13.addActionListener((var1x) -> {
         this.showCoordinateViewer();
      });
      var9.add(var13);
      this.editMenuItems.add(var13);
      JCheckBoxMenuItem var14 = new JCheckBoxMenuItem("Test Mode");
      var14.setSelected(en.aS());
      var14.addActionListener((var2x) -> {
         boolean var3 = var14.isSelected();
         if (var3) {
            int var4 = JOptionPane.showConfirmDialog(this.mainWindow, "This mode removes any restrictions imposed by the editor.\nUSE WITH CAUTION: Changes made in test mode may not work in game.", "Test Mode", 2);
            if (var4 == 2) {
               var14.setSelected(false);
               return;
            }
         }

         en.setEnabled(var3);
      });
      var9.add(var14);
      var9.addSeparator();
      JMenuItem var15 = new JMenuItem("Recharge All Technology");
      var15.addActionListener((var1x) -> {
         this.rechargeAllTechnology();
      });
      var9.add(var15);
      this.editMenuItems.add(var15);
      JMenuItem var16 = new JMenuItem("Refill All Stacks");
      var16.addActionListener((var1x) -> {
         this.refillAllStacks();
      });
      var9.add(var16);
      this.editMenuItems.add(var16);
      JMenuItem var17 = new JMenuItem("Recharge Base Planters");
      var17.addActionListener((var1x) -> {
         this.rechargeBasePlanters();
      });
      var9.add(var17);
      this.editMenuItems.add(var17);
      JMenuItem var18 = new JMenuItem("Expand All Inventories");
      var18.addActionListener((var1x) -> {
         this.expandAllInventories();
      });
      var9.add(var18);
      this.editMenuItems.add(var18);
      JMenuItem var19 = new JMenuItem("Enable All Slots");
      var19.addActionListener((var1x) -> {
         this.enableAllSlots();
      });
      var9.add(var19);
      this.editMenuItems.add(var19);
      JMenuItem var20 = new JMenuItem("Repair All Slots / Technology");
      var20.addActionListener((var1x) -> {
         this.repairAllSlots();
      });
      var9.add(var20);
      this.editMenuItems.add(var20);
      var9.addSeparator();
      this.editAccountJsonMenuItem = new JMenuItem("Edit Account JSON");
      this.editAccountJsonMenuItem.addActionListener((var1x) -> {
         this.editAccountJson();
      });
      var9.add(this.editAccountJsonMenuItem);
      Iterator var22 = this.editMenuItems.iterator();

      while(var22.hasNext()) {
         JMenuItem var21 = (JMenuItem)var22.next();
         var21.setEnabled(false);
      }

      this.editAccountJsonMenuItem.setEnabled(false);
      JMenu var25 = new JMenu("View");
      var5.add(var25);
      JMenuItem var26 = new JMenuItem("Settings");
      var26.addActionListener((var1x) -> {
         this.changeTheme();
      });
      var25.add(var26);
      var5.add(Box.createHorizontalGlue());
      JMenu var23 = new JMenu("Help");
      var5.add(var23);
      JMenuItem var24 = new JMenuItem("About");
      var24.addActionListener((var1x) -> {
         AboutDialog.AboutDialog(this.mainWindow);
      });
      var23.add(var24);
      if (this.saveLocation == null) {
         EventQueue.invokeLater(new RefreshRunnable(this));
      } else if (this.accountJson != null) {
         this.editAccountJsonMenuItem.setEnabled(true);
         this.tabbedPane.setEnabledAt(13, true);
         this.accountPanel.AboutDialog(this.accountJson);
         this.accountModified = false;
      }

      this.mainWindow.pack();
   }

   private static String e(String var0) {
      return var0 == null ? "(unknown)" : var0;
   }

   // $FF: synthetic method
   static boolean access$isFileLoading(Application var0) {
      return var0.aQ;
   }

   // $FF: synthetic method
   static SaveLocation access$getSaveLocation(Application var0) {
      return var0.saveLocation;
   }

   // $FF: synthetic method
   static void access$setSlotChanged(Application var0, boolean var1) {
      var0.aR = var1;
   }

   // $FF: synthetic method
   static void access$setFileChanged(Application var0, boolean var1) {
      var0.aS = var1;
   }

   // $FF: synthetic method
   static int access$getSlotIndex(Application var0) {
      return var0.AppSettings;
   }

   // $FF: synthetic method
   static SaveSlot[] d(Application var0) {
      return var0.saveSlots;
   }

   // $FF: synthetic method
   static void access$setAccountPanelChanged(Application var0, boolean var1) {
      var0.aT = var1;
   }

   // $FF: synthetic method
   static int e(Application var0) {
      return var0.ExosuitPanel;
   }

   // $FF: synthetic method
   static SaveFile[] f(Application var0) {
      return var0.saveFiles;
   }

   // $FF: synthetic method
   static void d(Application var0, boolean var1) {
      var0.aU = var1;
   }

   // $FF: synthetic method
   Application(boolean var1, Application var2) {
      this(var1);
   }

   // $FF: synthetic method
   static void g(Application var0) {
      instance = var0;
   }

   // $FF: synthetic method
   static Application H() {
      return instance;
   }

   // $FF: synthetic method
   static JFrame h(Application var0) {
      return var0.mainWindow;
   }

   // $FF: synthetic method
   static int[] BasesStoragePanel() {
      int[] var10000 = aY;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[gl.values().length];

         try {
            var0[gl.oG.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[gl.oF.ordinal()] = 1;
         } catch (NoSuchFieldError var1) {
         }

         aY = var0;
         return var0;
      }
   }

   // $FF: synthetic method
   static boolean i(Application var0) {
      return var0.saveModified;
   }

   // $FF: synthetic method
   static boolean j(Application var0) {
      return var0.accountModified;
   }

   // $FF: synthetic method
   static void k(Application var0) {
      var0.saveFile();
   }

   // $FF: synthetic method
   static void loadSave(Application var0) {
      var0.saveAccountData();
   }

   // $FF: synthetic method
   static void e(Application var0, boolean var1) {
      var0.aQ = var1;
   }

   // $FF: synthetic method
   static void saveAccountData(Application var0) {
      var0.checkExternalChanges();
   }

   // $FF: synthetic method
   static JComboBox saveFile(Application var0) {
      return var0.slotComboBox;
   }

   // $FF: synthetic method
   static void f(Application var0, boolean var1) {
      var0.saveModified = var1;
   }

   // $FF: synthetic method
   static void access$selectSlot(Application var0, int var1) {
      var0.e(var1);
   }

   // $FF: synthetic method
   static JComboBox saveFileAs(Application var0) {
      return var0.fileComboBox;
   }

   // $FF: synthetic method
   static void access$setSaveFiles(Application var0, SaveFile[] var1) {
      var0.saveFiles = var1;
   }

   // $FF: synthetic method
   static void access$selectFile(Application var0, int var1) {
      var0.selectFile(var1);
   }

   // $FF: synthetic method
   static void showCoordinateViewer(Application var0) {
      var0.openFile();
   }
}
