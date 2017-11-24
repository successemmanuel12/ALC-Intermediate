package com.successemmanuel.cryptocurrencyconverter;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by SuccessEmmanuel on 11/20/2017.
 */

public class CoinsAdapter extends ArrayAdapter<Coins> implements AdapterView.OnItemSelectedListener {

    TextView tvRate;
    Coins currentCoin;

    public CoinsAdapter(Context context, ArrayList<Coins> coins) {
        super(context, 0, coins);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being resused, otherwise inflate the view

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_model, parent, false);
        }

        // Ge the {@link Coins} object located at this position in the list
        currentCoin = getItem(position);

        // Find the coinImage imageView
        ImageView coinImage = (ImageView) listItemView.findViewById(R.id.coin_image);
        // Set the Image for the current coin
        coinImage.setImageResource(currentCoin.getFromCoinImageID());

        // Find the converting from coin textView
        TextView tvFromCoin = (TextView) listItemView.findViewById(R.id.text_name);
        // Set the Text for the current coin
        tvFromCoin.setText(currentCoin.getFromCoinName());

        // Find the rate TextView
        tvRate = (TextView) listItemView.findViewById(R.id.text_rate);
        // Set the text for the rate
        tvRate.setText(currentCoin.getRate());

        // Find the spinner
        Spinner spinner = (Spinner) listItemView.findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
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


        // Create an array adapter for the spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_spinner_dropdown_item, currencies);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


        // Return the ListView layout
        return listItemView;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();

        // query string
        String queryURL = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=";

        OkHttpHandler okHttpHandler = new OkHttpHandler();

        // TODO: Query the CryptoCompare api here and return the data for each currency
        switch (item) {
            case "NGN - Nigerian Naira":
                okHttpHandler.execute(queryURL + "NGN");
                break;
            case "USD - US Dollars":
                okHttpHandler.execute(queryURL + "USD");
                break;
            case "EUR - Euros":
                okHttpHandler.execute(queryURL + "EUR");
                break;
            case "JPY  - Japanese Yen":
                okHttpHandler.execute(queryURL + "JPY");
                break;
            case "GBP - British Pound":
                okHttpHandler.execute(queryURL + "GBP");
                break;
            case "CHF - Swiss Franc":
                okHttpHandler.execute(queryURL + "CHF");
                break;
            case "CAD - Canadian Dollar":
                okHttpHandler.execute(queryURL + "CAD");
                break;
            case "MXN - Mexican Peso":
                okHttpHandler.execute(queryURL + "MXN");
                break;
            case "AUD - Australian Dollar":
                okHttpHandler.execute(queryURL + "AUD");
                break;
            case "HKD - Hong Kong Dollar":
                okHttpHandler.execute(queryURL + "HKD");
                break;
            case "BRL - Brazilian Real":
                okHttpHandler.execute(queryURL + "BRL");
                break;
            case "INR - Indian Rupee":
                okHttpHandler.execute(queryURL + "INR");
                break;
            case "KRW - Korean Won":
                okHttpHandler.execute(queryURL + "KRW");
                break;
            case "ILS - Israeli New Shekel":
                okHttpHandler.execute(queryURL + "ILS");
                break;
            case "RUB - Russian Ruble":
                okHttpHandler.execute(queryURL + "RUB");
                break;

            case "ZAR - South African Rand":
                okHttpHandler.execute(queryURL + "ZAR");
                break;
            case "SEK - Swedish Krona":
                okHttpHandler.execute(queryURL + "SEK");
                break;
            case "PHP - Philippine Peso":
                okHttpHandler.execute(queryURL + "PHP");
                break;
            case "CNY - Chinese Yuan Renminbi":
                okHttpHandler.execute(queryURL + "CNY");
                break;
            case "TRY - Turkish Lira":
                okHttpHandler.execute(queryURL + "TRY");
                break;
        }

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO: set default behaviour if nothing is selected
    }

    private class OkHttpHandler extends AsyncTask<String, Void, String> {
        OkHttpClient client = new OkHttpClient();

        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... url) {
            okhttp3.Request.Builder builder = new Request.Builder();
            builder.url(url[0]);
            Request request = builder.build();

            try {
                Response response = client.newCall(request).execute();
                return response.body().string();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //initialized progressDialog
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setTitle("Converting");
            progressDialog.setMessage("Getting conversion rate please wait ....");
            //start progressDialog
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(String data) {
            progressDialog.dismiss();
            super.onPostExecute(data);

            try {
                JSONObject coinDataObject = new JSONObject(data);

                if (coinDataObject.has("NGN")) {
                    String btcConvert = coinDataObject.getString("NGN");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " NGN");
                } else if (coinDataObject.has("USD")) {
                    String btcConvert = coinDataObject.getString("USD");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " USD");
                } else if (coinDataObject.has("EUR")) {
                    String btcConvert = coinDataObject.getString("EUR");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " EUR");
                } else if (coinDataObject.has("JPY")) {
                    String btcConvert = coinDataObject.getString("JPY");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " JPY");
                } else if (coinDataObject.has("GBP")) {
                    String btcConvert = coinDataObject.getString("GBP");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " GBP");
                } else if (coinDataObject.has("CHF")) {
                    String btcConvert = coinDataObject.getString("CHF");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " CHF");
                } else if (coinDataObject.has("CAD")) {
                    String btcConvert = coinDataObject.getString("CAD");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " CAD");
                }

                else if (coinDataObject.has("MXN")) {
                    String btcConvert = coinDataObject.getString("MXN");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " MXN");
                } else if (coinDataObject.has("AUD")) {
                    String btcConvert = coinDataObject.getString("AUD");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " AUD");
                } else if (coinDataObject.has("HKD")) {
                    String btcConvert = coinDataObject.getString("HKD");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " HKD");
                } else if (coinDataObject.has("BRL")) {
                    String btcConvert = coinDataObject.getString("BRL");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " BRL");
                } else if (coinDataObject.has("INR")) {
                    String btcConvert = coinDataObject.getString("INR");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " INR");
                } else if (coinDataObject.has("KRW")) {
                    String btcConvert = coinDataObject.getString("KRW");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " KRW");
                }else if (coinDataObject.has("ILS")) {
                    String btcConvert = coinDataObject.getString("ILS");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " ILS");
                } else if (coinDataObject.has("RUB")) {
                    String btcConvert = coinDataObject.getString("RUB");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " RUB");
                }


                else if (coinDataObject.has("ZAR")) {
                    String btcConvert = coinDataObject.getString("ZAR");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " ZAR");
                } else if (coinDataObject.has("SEK")) {
                    String btcConvert = coinDataObject.getString("SEK");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " SEK");
                } else if (coinDataObject.has("PHP")) {
                    String btcConvert = coinDataObject.getString("PHP");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " PHP");
                }else if (coinDataObject.has("CNY")) {
                    String btcConvert = coinDataObject.getString("CNY");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " CNY");
                } else if (coinDataObject.has("TRY")) {
                    String btcConvert = coinDataObject.getString("TRY");
                    // Update the textView of the list.
                    tvRate.setText(btcConvert + " TRY");
                }

                else {
                    tvRate.setText("No Data");
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
