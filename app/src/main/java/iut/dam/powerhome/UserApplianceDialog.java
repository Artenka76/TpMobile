package iut.dam.powerhome;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import iut.dam.powerhome.classe.User;

public class UserApplianceDialog extends Dialog {
    public UserApplianceDialog(Context context, User user){
        super(context);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_user_layout);

        }
}
