package practicaltest01var03.eim.systems.cs.pub.ro.practicaltest01var03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class PracticalTest01Var03MainActivity extends AppCompatActivity {

    private EditText name, grupa, eticheta ;
    private Button display;
    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String name1 = name.getText().toString();
            switch (view.getId()) {
                case R.id.navigate_to_secondary_activity_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var03SecondaryActivity.class);
                    intent.putExtra("name", name1);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
                case R.id.display:

                    eticheta.setText(name.getText().toString().concat(grupa.getText().toString()));
                    break;
            }

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var03_main);

        name = (EditText)findViewById(R.id.name);
        grupa =(EditText)findViewById(R.id.grupa);

        eticheta = (EditText)findViewById(R.id.eticheta);
      //  eticheta.setText(String.valueOf(""));
        display = (Button)findViewById(R.id.display);
        display.setOnClickListener(buttonClickListener);


    }
}
