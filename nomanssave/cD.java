package nomanssave;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class cD implements PropertyChangeListener {
   // $FF: synthetic field
   final JsonEditorDialog gg;

   cD(JsonEditorDialog var1) {
      this.gg = var1;
   }

   public void propertyChange(PropertyChangeEvent var1) {
      AppSettings.setValueByPath("JSONEditor.Divider", (Integer)var1.getNewValue());
   }
}
