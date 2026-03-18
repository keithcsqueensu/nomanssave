package nomanssave;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class fV implements SaveFile {
   final fW mO;
   final int mb;
   final File mc;
   final String mP;
   final fS mQ;
   final String mR;
   final String mS;
   final GameMode be;
   // $FF: synthetic field
   final XboxSaveLocation mN;

   fV(XboxSaveLocation var1, String var2, int var3) {
      this.mN = var1;
      this.mb = var3;
      this.mc = new File(AppSettings.cG, var2);
      ZipFile var4 = new ZipFile(this.mc);

      try {
         ZipEntry var5 = var4.getEntry("saveinfo.txt");
         if (var5 == null) {
            throw new IOException("Invalid backup file");
         }

         Properties var6 = new Properties();
         var6.load(var4.getInputStream(var5));
         this.mP = var6.getProperty("MetaFile");
         this.mR = var6.getProperty("DataFile");
         this.mS = var6.getProperty("ContainerFile");
         String var7 = var6.getProperty("IndexData");
         if (this.mP == null || this.mR == null || this.mS == null || var7 == null) {
            throw new IOException("Invalid backup file");
         }

         String var8 = var6.getProperty("GameMode");
         this.be = var8 == null ? null : GameMode.valueOf(var8);
         this.mO = new fW(var1, var7);
         var5 = var4.getEntry(this.mP);
         if (var5 == null) {
            throw new IOException("Invalid backup file");
         }

         this.mQ = new fS((File)null);
         this.mQ.read(var4.getInputStream(var5));
      } catch (NumberFormatException var12) {
         throw new IOException("Invalid backup file");
      } finally {
         var4.close();
      }

   }

   void AboutDialog(FileOutputStream var1) {
      ZipFile var2 = new ZipFile(this.mc);

      try {
         ZipEntry var3 = var2.getEntry(this.mS);
         if (var3 == null) {
            throw new IOException("Invalid backup file");
         }

         InputStream var4 = var2.getInputStream(var3);

         try {
            byte[] var5 = new byte[1024];

            int var6;
            while((var6 = var4.read(var5)) > 0) {
               var1.write(var5, 0, var6);
            }
         } finally {
            var4.close();
         }
      } finally {
         var2.close();
      }

   }

   public String K() {
      return this.mO.filename;
   }

   public GameMode L() {
      return this.be;
   }

   public JsonObject M() {
      // $FF: Couldn't be decompiled
   }

   public String AboutDialogCloseListener(JsonObject var1) {
      Logger.info("Writing new save file...");
      String var2;
      if (XboxSaveLocation.AboutDialogCloseListener(this.mN)[this.mb] != null) {
         XboxSaveLocation.AboutDialogCloseListener(this.mN)[this.mb].mZ.AboutDialog(this.mQ);
         var2 = XboxSaveLocation.AboutDialogCloseListener(this.mN)[this.mb].AboutDialogCloseListener(var1);
      } else {
         XboxSaveLocation.AboutDialogCloseListener(this.mN)[this.mb] = new fY(this.mN, this, var1);
         var2 = XboxSaveLocation.AboutDialogCloseListener(this.mN)[this.mb].K();
      }

      Logger.info("Finished.");
      return var2;
   }

   public long lastModified() {
      return this.mO.timestamp;
   }

   public String toString() {
      return this.mc.getName();
   }

   public String getName() {
      return this.mQ.getName();
   }

   public String getDescription() {
      return this.mQ.getDescription();
   }
}
