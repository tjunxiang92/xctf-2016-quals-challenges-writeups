package xctf.nus.xverifier;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0165R.layout.activity_main);
    }

    public void btnOnClick(View v) {
        switch (v.getId()) {
            case C0165R.id.btnVerify /*2131492949*/:
                setResultMsg(BuildConfig.FLAVOR);
                String name = BuildConfig.FLAVOR;
                String key = BuildConfig.FLAVOR;
                name = ((EditText) findViewById(C0165R.id.txtName)).getText().toString();
                key = ((EditText) findViewById(C0165R.id.txtKey)).getText().toString();
                if (name.isEmpty() || key.isEmpty()) {
                    setResultMsg("Please enter name and key before verifying");
                    return;
                }
                try {
                    Integer.parseInt(key);
                    if (verify(name, key)) {
                        setResultMsg("Yay the flag is '" + retrieveX() + "'");
                        return;
                    }
                    setResultMsg("Oops, That is incorrect...");
                } catch (Exception e) {
                    setResultMsg("Key must be numeric!!");
                }
            default:
        }
    }

    private boolean verify(String name, String key) {
        int i;
        int[] arr = new int[name.length()];
        for (i = 0; i < arr.length; i++) {
            arr[i] = name.charAt(i);
        }
        int shifter = 3;
        int val = 0;
        for (i = 0; i < arr.length; i++) {
            if (val == 0) {
                val = arr[i];
            }
            if (i % 2 == 0) {
                val <<= shifter;
            } else {
                val >>= shifter;
            }
            val += 3;
            shifter = val % 8;
        }
        return val == Integer.parseInt(key) ? false : false;
    }

    private String retrieveX() {
        String oops = (getResources().getString(C0165R.string.poseidon) + getResources().getString(C0165R.string.zeus)) + getResources().getString(C0165R.string.hades);
        byte[] arr = new byte[(oops.length() / 2)];
        int count = 0;
        int i = 0;
        while (i < oops.length()) {
            int count2 = count + 1;
            arr[count] = (byte) Integer.parseInt(oops.substring(i, i + 2), 16);
            i += 2;
            count = count2;
        }
        byte[] res = new byte[arr.length];
        byte xorer = (byte) 0;
        for (i = arr.length - 1; i >= 0; i--) {
            res[i] = (byte) ((arr[i] - 7) ^ xorer);
            xorer = res[i];
        }
        String out = BuildConfig.FLAVOR;
        for (byte toChars : res) {
            out = out + Character.toChars(toChars)[0];
        }
        return out;
    }

    private void setResultMsg(String msg) {
        ((TextView) findViewById(C0165R.id.txtResults)).setText(msg);
    }
}
