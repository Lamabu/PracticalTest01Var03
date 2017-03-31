package practicaltest01var03.eim.systems.cs.pub.ro.practicaltest01var03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var03SecondaryActivity extends AppCompatActivity {


    private TextView name_text_view = null;

    private Button okButton = null;
    private Button cancelButton = null;
    private TextView name = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.ok_button:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.cancel_button:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_secondary);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.);
        // setSupportActionBar(toolbar);

      // name = (TextView) findViewById(R.id.name);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("name")) {
            String name = intent.getStringExtra("name");

            name_text_view = (TextView)findViewById(R.id.name_text_view);
            name_text_view.setText(String.valueOf(name));
        }

        okButton = (Button) findViewById(R.id.ok_button);
        okButton.setOnClickListener(buttonClickListener);
        cancelButton = (Button) findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(buttonClickListener);
    }

}
