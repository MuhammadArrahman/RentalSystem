package com.example.rentalsystem;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.midtrans.sdk.corekit.callback.TransactionFinishedCallback;
import com.midtrans.sdk.corekit.core.MidtransSDK;
import com.midtrans.sdk.corekit.models.snap.TransactionResult;
import com.midtrans.sdk.uikit.SdkUIFlowBuilder;

public class MidtransPaymentActivity extends AppCompatActivity
        implements TransactionFinishedCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_midtrans_payment);

        initMidtrans();
        startPayment();
    }

    private void initMidtrans() {
        SdkUIFlowBuilder.init()
                .setClientKey("ISI_CLIENT_KEY_SANDBOX")
                .setContext(this)
                .setTransactionFinishedCallback(this)
                .setMerchantBaseUrl("https://your-backend-url.com/")
                .enableLog(true)
                .buildSDK();
    }

    private void startPayment() {
        MidtransSDK.getInstance().startPaymentUiFlow(this);
    }

    @Override
    public void onTransactionFinished(TransactionResult result) {

        if (result.getResponse() != null) {
            switch (result.getStatus()) {
                case TransactionResult.STATUS_SUCCESS:
                    Toast.makeText(this,
                            "Pembayaran Berhasil, Booking Sukses!",
                            Toast.LENGTH_LONG).show();
                    finish();
                    break;

                case TransactionResult.STATUS_PENDING:
                    Toast.makeText(this,
                            "Menunggu pembayaran",
                            Toast.LENGTH_LONG).show();
                    break;

                case TransactionResult.STATUS_FAILED:
                    Toast.makeText(this,
                            "Pembayaran Gagal",
                            Toast.LENGTH_LONG).show();
                    break;
            }
        } else if (result.isTransactionCanceled()) {
            Toast.makeText(this,
                    "Pembayaran dibatalkan",
                    Toast.LENGTH_LONG).show();
        }
    }
}
