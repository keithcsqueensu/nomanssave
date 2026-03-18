package nomanssave;

class RefreshRunnable implements Runnable {
   // $FF: synthetic field
   final Application aZ;

   RefreshRunnable(Application var1) {
      this.aZ = var1;
   }

   public void run() {
      Application.showCoordinateViewer(this.aZ);
   }
}
