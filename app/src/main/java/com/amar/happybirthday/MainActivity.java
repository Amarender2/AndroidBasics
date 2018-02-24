package com.amar.happybirthday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
        if(quantity > 0) {
            priceTextView.setText(" Thank You!! Order Received of worth "
                    + NumberFormat.getCurrencyInstance().format(price * quantity));
        } else {
            priceTextView.setText("Please add some coffee to your order !!!");
        }
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