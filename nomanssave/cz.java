package nomanssave;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

class cz extends ComponentAdapter {
   // $FF: synthetic field
   final JsonEditorDialog gg;

   cz(JsonEditorDialog var1) {
      this.gg = var1;
   }

   public void componentMoved(ComponentEvent var1) {
      Point var2 = this.gg.getBounds().getLocation();
      AppSettings.setValueByPath("JSONEditor.X", var2.UpdateCheckThread);
      AppSettings.setValueByPath("JSONEditor.Y", var2.UpdateDownloadRunnable);
   }

   public void componentResized(ComponentEvent var1) {
      Dimension var2 = this.gg.getBounds().getSize();
      AppSettings.setValueByPath("JSONEditor.Width", var2.width);
      AppSettings.setValueByPath("JSONEditor.Height", var2.height);
   }
}
