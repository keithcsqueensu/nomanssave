package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;

class co extends FileFilter {
   // $FF: synthetic field
   final cl SaveFileMetadata;

   co(cl var1) {
      this.SaveFileMetadata = var1;
   }

   public String getDescription() {
      return "All Base Backup Files";
   }

   public boolean accept(File var1) {
      if (var1.isDirectory()) {
         return !var1.isHidden();
      } else {
         String var2 = var1.getName();
         return var2.endsWith(".pb3") || var2.endsWith(".pb0");
      }
   }
}
