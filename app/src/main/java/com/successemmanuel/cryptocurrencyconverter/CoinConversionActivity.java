package com.successemmanuel.cryptocurrencyconverter;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CoinConversionActivity extends AppCompatActivity {

    // the from sym an to sym
    String fromSym, toSym, abr = "&tsyms=";

    // the textView
    TextView textView_convert;

    // The editTextView
    EditText userInput;

    DecimalFormat decimalFormat = new DecimalFormat("####0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);

        // Find the convert from (coin) spinner
        final Spinner coinSpinner = (Spinner) findViewById(R.id.coin_spinner);

        // Find the Conversion textView
        textView_convert = (TextView) findViewById(R.id.convert_TextView);

        // Find the input EditText View
        userInput = (EditText) findViewById(R.id.from_EditText);

        // Find the convert to (Currencies) spinner
        final Spinner currencySpinner = (Spinner) findViewById(R.id.currency_spinner);

        // Find the image view
        final ImageView coinImage = (ImageView) findViewById(R.id.iv_btc);

        // Spinner drop down elements for the coins
        List<String> coins = new ArrayList<String>();
        coins.add("BTC - Bitcoin");
        coins.add("ETH - Ethereum");

        // Spinner Drop down elements for currencies
        List<String> currencies = new ArrayList<String>();
        currencies.add("USD - US Dollars");
        currencies.add("EUR - Euros");
        currencies.add("NGN - Nigerian Naira");
        currencies.add("JPY  - Japanese Yen");
        currencies.add("GBP - British Pound");
        currencies.add("CHF - Swiss Franc");
        currencies.add("CAD - Canadian Dollar");
        currencies.add("MXN - Mexican Peso");
        currencies.add("AUD - Australian Dollar");
        currencies.add("HKD - Hong Kong Dollar");
        currencies.add("BRL - Brazilian Real");
        currencies.add("INR - Indian Rupee");
        currencies.add("KRW - Korean Won");
        currencies.add("CHF - Swiss Franc");
        currencies.add("ILS - Israeli New Shekel");
        currencies.add("RUB - Russian Ruble");
        currencies.add("ZAR - South African Rand");
        currencies.add("SEK - Swedish Krona");
        currencies.add("PHP - Philippine Peso");
        currencies.add("CNY - Chinese Yuan Renminbi");
        currencies.add("TRY - Turkish Lira");

        // Create an array adapter for the currency spinner
        ArrayAdapter<String> currencyDataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, currencies);

        // attaching data adapter to spinner
        currencySpinner.setAdapter(currencyDataAdapter);


        // Create an array adapter for the spinner
        ArrayAdapter<String> coinDataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, coins);

        // attaching data adapter to spinner
        coinSpinner.setAdapter(coinDataAdapter);

        coinSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int coin = coinSpinner.getSelectedItemPosition();
                if (coin == 0) {
                    coinImage.setImageResource(R.drawable.bitcoin1);
                    //TODO get the value of BtC here
                    fromSym = "BTC";

                }

                if (coin == 1) {
                    coinImage.setImageResource(R.drawable.eth);
                    //TODO get the value of ETH here
                    fromSym = "ETH";

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        currencySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String currency = currencySpinner.getSelectedItem().toString();

                // The url to query
                String queryURL = "https://min-api.cryptocompare.com/data/price?fsym=";

                OkHttpHandler okHttpHandler = new OkHttpHandler();

                switch (currency) {
                    case "NGN - Nigerian Naira":
                        // get the coin and multiply by the value given by the use
                        // the update the To textView with value
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        toSym = "NGN";
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "USD - US Dollars":
                        toSym = "USD";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "EUR - Euros":
                        toSym = "EUR";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "JPY  - Japanese Yen":
                        toSym = "JPY";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "GBP - British Pound":
                        toSym = "GBP";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "CHF - Swiss Franc":
                        toSym = "CHF";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "CAD - Canadian Dollar":
                        toSym = "CAD";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;

                    case "MXN - Mexican Peso":
                        toSym = "MXN";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "AUD - Australian Dollar":
                        toSym = "AUD";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "HKD - Hong Kong Dollar":
                        toSym = "HKD";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "BRL - Brazilian Real":
                        toSym = "BRL";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "INR - Indian Rupee":
                        toSym = "INR";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "KRW - Korean Won":
                        toSym = "KRW";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "ILS - Israeli New Shekel":
                        toSym = "ILS";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "RUB - Russian Ruble":
                        toSym = "RUB";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;

                    case "ZAR - South African Rand":
                        toSym = "ZAR";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "SEK - Swedish Krona":
                        toSym = "SEK";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "PHP - Philippine Peso":
                        toSym = "PHP";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "CNY - Chinese Yuan Renminbi":
                        toSym = "CNY";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                    case "TRY - Turkish Lira":
                        toSym = "TRY";
                        Toast.makeText(getApplicationContext(), fromSym + " to " + toSym, Toast.LENGTH_LONG).show();
                        okHttpHandler.execute(queryURL + fromSym + abr + toSym);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    // Add menu item to the BTC Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_menu_items, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Handles on clicking menu option
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btc_view:
                launchBTC();
                return true;
            case R.id.convert:
                Toast.makeText(this, "Already on Convert", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Launch the Covert Activity
    private void launchBTC() {
        startActivity(new Intent(this, BtcActivity.class));
    }

    private class OkHttpHandler extends AsyncTask<String, Void, String> {

        OkHttpClient client = new OkHttpClient();

        @Override
        protected String doInBackground(String... url) {

            Request.Builder builder = new Request.Builder();
            builder.url(url[0]);
            Request request = builder.build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            String con;

            try {
                JSONObject coinDataObject = new JSONObject(s);

                if (coinDataObject.has("NGN")) {
                    con = coinDataObject.getString("NGN");

                    // Convert con string to integer and multiply by
                    // provided text in the editText view;
                    Double rate = Double.parseDouble(con);
                    // Make sure the user enter a number
                    // Get the user input and convert to double
                    if (userInput.length() != 0){
                        Double input = Double.parseDouble(userInput.getText().toString());
                        Double result = rate * input;
                        // update the coversion text view
                        textView_convert.setText(decimalFormat.format(result) + " NGN");
                    }else{
                        Toast.makeText(getApplicationContext(),"Enter number to convert", Toast.LENGTH_SHORT).show();
                    }


                } else if (coinDataObject.has("USD")) {
                    con = coinDataObject.getString("USD");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " USD");

                }else if (coinDataObject.has("EUR")) {
                    con = coinDataObject.getString("EUR");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " EUR");

                }else if (coinDataObject.has("JPY")) {
                    con = coinDataObject.getString("JPY");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " JPY");

                }else if (coinDataObject.has("GBP")) {
                    con = coinDataObject.getString("GBP");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " GBP");

                }
                else if (coinDataObject.has("CHF")) {
                    con = coinDataObject.getString("CHF");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " CHF");

                }else if (coinDataObject.has("CAD")) {
                    con = coinDataObject.getString("CAD");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " CAD");

                }else if (coinDataObject.has("MXN")) {
                    con = coinDataObject.getString("MXN");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " MXN");

                }else if (coinDataObject.has("AUD")) {
                    con = coinDataObject.getString("AUD");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " AUD");

                }


                else if (coinDataObject.has("HKD")) {
                    con = coinDataObject.getString("HKD");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " HKD");

                }else if (coinDataObject.has("BRL")) {
                    con = coinDataObject.getString("BRL");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " BRL");

                }else if (coinDataObject.has("INR")) {
                    con = coinDataObject.getString("INR");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " INR");

                }else if (coinDataObject.has("KRW")) {
                    con = coinDataObject.getString("KRW");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " KRW");

                }

                else if (coinDataObject.has("ILS")) {
                    con = coinDataObject.getString("ILS");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " ILS");

                }else if (coinDataObject.has("RUB")) {
                    con = coinDataObject.getString("RUB");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " RUB");

                }else if (coinDataObject.has("ZAR")) {
                    con = coinDataObject.getString("ZAR");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " ZAR");

                }else if (coinDataObject.has("SEK")) {
                    con = coinDataObject.getString("SEK");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " SEK");

                }

                else if (coinDataObject.has("PHP")) {
                    con = coinDataObject.getString("PHP");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " PHP");

                }else if (coinDataObject.has("CNY")) {
                    con = coinDataObject.getString("CNY");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " CNY");

                }else if (coinDataObject.has("TRY")) {
                    con = coinDataObject.getString("TRY");

                    Double rate = Double.parseDouble(con);
                    Double input = Double.parseDouble(userInput.getText().toString());
                    Double result = rate * input;
                    textView_convert.setText(decimalFormat.format(result) + " TRY");

                }

                else {
                    textView_convert.setText("err");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
