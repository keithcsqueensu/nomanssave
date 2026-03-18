package nomanssave;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class cp extends JFileChooser {
   private static cp SteamSaveLocation = null;
   private static final String name = "Companion Export File";
   private static final ImageIcon fK = Application.loadScaledIcon("UI-PET.PNG", 16, 16);
   private static final ImageIcon fL = Application.loadScaledIcon("UI-EGG.PNG", 16, 16);

   public static cp at() {
      if (SteamSaveLocation == null) {
         SteamSaveLocation = new cp();
      }

      return SteamSaveLocation;
   }

   private cp() {
      this.setFileSelectionMode(0);
      this.setAcceptAllFileFilterUsed(false);
      this.setFileView(new cq(this));
      this.setFileFilter(new cr(this));
      this.setDialogTitle("Choose Companion Export File");
      UIManager.addPropertyChangeListener((var1) -> {
         if ("lookAndFeel".equals(var1.getPropertyName())) {
            SwingUtilities.updateComponentTreeUI(this);
         }

      });
   }

   // $FF: synthetic method
   static ImageIcon as() {
      return fK;
   }

   // $FF: synthetic method
   static ImageIcon au() {
      return fL;
   }
}
