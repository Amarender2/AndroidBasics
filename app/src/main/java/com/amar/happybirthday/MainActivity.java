package com.amar.happybirthday;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */

    private final int price = 5;

    public void submitOrder(View view) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int quantity = Integer.parseInt(quantityTextView.getText().toString());
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whippedCream);
        boolean hasWhippedCream = whippedCream.isChecked();
        CheckBox chocolate = (CheckBox) findViewById(R.id.choclate);
        boolean hasChocolate = chocolate.isChecked();
        EditText nameField = (EditText) findViewById(R.id.nameField);
        String name = nameField.getText().toString();

        if(quantity > 0) {
            priceTextView.setText(" Thank You " + name + " !! Order Received of worth "
                    + NumberFormat.getCurrencyInstance().format(calculatePrice(quantity, hasWhippedCream, hasChocolate))+
                    "\n Need WhippedCream ? " + hasWhippedCream + "\n Need Chocolate ? " + hasChocolate);
        } else {
            priceTextView.setText("Please add some coffee to your order !!! " + getString(R.string.toppings));
        }

//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("geo: 47.6, -122.3"));
//        if(intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }

        Intent intent = new Intent(Intent.ACTION_SEND);
         intent.setType("*/*");
//        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "amarender.mekala@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Sample Email from android app");
        intent.putExtra(Intent.EXTRA_TEXT, priceTextView.getText().toString());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public int calculatePrice(int quantity, boolean hasWhippedCream, boolean hasChocolate) {
        int extraPrice = 0;
        if(hasWhippedCream) {
            extraPrice += 1;
        }
        if(hasChocolate) {
            extraPrice += 2;
        }
        return (price + extraPrice) * quantity;
    }

    public void displayPrice(int quantity) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(quantity * price));
    }

    public void increaseQuantity(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int quantity = Integer.parseInt(quantityTextView.getText().toString());
        displayQuantity(++quantity);
        displayPrice(quantity);
        if (quantity > 0) {
            Button minusButton = (Button) findViewById(R.id.minus_button);
            minusButton.setEnabled(true);
        }
    }

    public void decreaseQuantity(View view) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int quantity = Integer.parseInt(quantityTextView.getText().toString());
        displayQuantity(--quantity);
        displayPrice(quantity);

        if (quantity < 1) {
            Button minusButton = (Button) findViewById(R.id.minus_button);
            minusButton.setEnabled(false);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
}