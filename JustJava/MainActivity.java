package com.example.android.justjava;

/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int numberOfCoffee = 2;

    /**
     * This method is called when the order button is clicked.
     */
    public void mailOrder(View view) {
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.notify_me_checkbox);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_chockolate);
        boolean check1, check2;
        if (checkBox1.isChecked()) check1 = true;
        else check1 = false;
        if (checkBox2.isChecked()) check2 = true;
        else check2 = false;
        int price = calculatePrice(numberOfCoffee, check1, check2);
        EditText edit = (EditText)findViewById(R.id.album_description_view);
        String name = edit.getText().toString();
        String priceMessage = createPriceMessage(name, price, check1, check2);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.JJOrder, name));
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void increment(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                getString(R.string.too_many_coffee), Toast.LENGTH_SHORT);
        if (numberOfCoffee < 100) numberOfCoffee++;
        else {
            toast.show();
            return;
        }
        display(numberOfCoffee);
    }

    public void decrement(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                getString(R.string.you_dont), Toast.LENGTH_SHORT);
        if (numberOfCoffee > 0) numberOfCoffee--;
        else {
            toast.show();
            return;
        }
        display(numberOfCoffee);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     */
    private int calculatePrice(int quantity, boolean check1, boolean check2) {
        int oneCup = 5;
        if (check1 == true) oneCup++;
        if (check2 == true) oneCup+=2;
        int price = quantity * oneCup;
        return price;
    }
    private String createPriceMessage(String name, int price, boolean check1, boolean check2) {
        String priceMessage =  getString(R.string.add_whapped_cream) + "? " + check1;
        priceMessage += "\n" + getString(R.string.chocolate) + "? " + check2;
        priceMessage += "\n" + getString(R.string.quantity) + ": " + numberOfCoffee;
        priceMessage += "\n" + getString(R.string.total_price) + " " + price;
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;
    }
}