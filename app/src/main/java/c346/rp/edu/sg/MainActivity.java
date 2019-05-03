package c346.rp.edu.sg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
TextView tvDisplay;
TextView paidperperson;
TextView Totalamount;
TextView Bill;
TextView People;
ToggleButton GST;
ToggleButton ServiceCharge;
EditText Cost;
EditText Amount;
Button Calculated;
NumberFormat number;
Button Reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bill = findViewById(R.id.Bill);
        People = findViewById(R.id.People);
        findViewById(R.id.Paymentaddition);

        Cost = findViewById(R.id.Cost);
        Amount = findViewById(R.id.amount);

        GST = findViewById(R.id.GST);
        ServiceCharge = findViewById(R.id.ServiceCharge);

        paidperperson = findViewById(R.id.paidperperson);
        Totalamount = findViewById(R.id.Totalamount);

        Calculated = findViewById(R.id.Calculated);
        Reset = findViewById(R.id.reset);

        Calculated.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String total = Cost.getText().toString();
                String pax = Amount.getText().toString();
                double totalResult = Double.parseDouble(total);
                double totalpax = Double.parseDouble(pax);
                if(GST.isChecked()&& ServiceCharge.isChecked()){
                    totalResult = totalResult*1.17;
                    String var = total + "";

                }if(GST.isChecked()){
                    totalResult = totalResult *1.07;

                }if(ServiceCharge.isChecked()){
                    totalResult=totalResult*1.1;
                }
                
                totalResult = totalResult / totalpax;
                String totalresult = totalResult + "";
                String formattedtotal = String.format("$%.2f,",totalResult);

                Totalamount.setText(formattedtotal);
            }
        });
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cost.setText("");
                Amount.setText("");
                Totalamount.setText("");
                GST.setChecked(false);
                ServiceCharge.setChecked(false);
            }
        });
}
}

