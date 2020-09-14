package test.project.firestore_minimal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ro.alexmamo.firestore_document.FirestoreDocument;
import test.project.firestore_minimal.models.FireStoreOrder;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;

public class MainActivity extends AppCompatActivity {

    private TextView testOrderStatus, zyaOrderStatus, arqOrderStatus;
    private ListenerRegistration testOrderListener, zyaOrderListener, arqOrderListener;
    private FirestoreDocument firestoreDocument = FirestoreDocument.getInstance();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseFirestore.setLoggingEnabled(true);

        testOrderStatus = findViewById(R.id.testOrderStatus);
        zyaOrderStatus = findViewById(R.id.zyaOrderStatus);
        arqOrderStatus = findViewById(R.id.arqOrderStatus);

        //init test order click listeners
        //-----------------------------------------------------------------------------------------
        findViewById(R.id.startOrderQuery1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (testOrderListener != null) {
                    testOrderListener.remove();
                }

                testOrderListener = FirebaseFirestore.getInstance()
                        .collection("orders")
                        .document("test_order")
                        .addSnapshotListener(new EventListener<DocumentSnapshot>() {
                            @Override
                            public void onEvent(@Nullable DocumentSnapshot value,
                                                @Nullable FirebaseFirestoreException error) {
                                if (error != null) {
                                    Log.i("testing", "test error : "+ error.getMessage());
                                    return;
                                }

                                Log.d("testing", "testOrder onEvent triggered");
                                int documentSize = firestoreDocument.getSize(value);
                                Log.d("testing", "document size : "+documentSize);
                                if (value.exists()) {
                                    FireStoreOrder fireStoreOrder = value.toObject(FireStoreOrder.class);
                                    if (fireStoreOrder != null && fireStoreOrder.getStatus() != null) {
                                        testOrderStatus.setText(getString(R.string.concat_status, fireStoreOrder.getStatus()));
                                    }
                                }
                            }
                        });
            }
        });

        findViewById(R.id.stopOrderQuery1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (testOrderListener != null) {
                    testOrderListener.remove();
                }
                testOrderStatus.setText(getString(R.string.concat_status, "-"));
            }
        });
        //-----------------------------------------------------------------------------------------

        //init test order click listeners
        //-----------------------------------------------------------------------------------------
        findViewById(R.id.startOrderQuery2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (zyaOrderListener != null) {
                    zyaOrderListener.remove();
                }

                zyaOrderListener = FirebaseFirestore.getInstance()
                        .collection("orders")
                        .document("ZYaJKmQF9n1RknziD1tj")
                        .addSnapshotListener(new EventListener<DocumentSnapshot>() {
                            @Override
                            public void onEvent(@Nullable DocumentSnapshot value,
                                                @Nullable FirebaseFirestoreException error) {
                                if (error != null) {
                                    Log.i("testing", "zya error : "+ error.getMessage());
                                    return;
                                }

                                Log.d("testing", "zyaOrder onEvent triggered");
                                int documentSize = firestoreDocument.getSize(value);
                                Log.d("testing", "document size : "+documentSize);
                                if (value.exists()) {
                                    FireStoreOrder fireStoreOrder = value.toObject(FireStoreOrder.class);
                                    if (fireStoreOrder != null && fireStoreOrder.getStatus() != null) {
                                        zyaOrderStatus.setText(getString(R.string.concat_status, fireStoreOrder.getStatus()));
                                    }
                                }
                            }
                        });
            }
        });

        findViewById(R.id.stopOrderQuery2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (zyaOrderListener != null) {
                    zyaOrderListener.remove();
                }
                zyaOrderStatus.setText(getString(R.string.concat_status, "-"));
            }
        });
        //-----------------------------------------------------------------------------------------

        //init test order click listeners
        //-----------------------------------------------------------------------------------------
        findViewById(R.id.startOrderQuery3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arqOrderListener != null) {
                    arqOrderListener.remove();
                }

                arqOrderListener = FirebaseFirestore.getInstance()
                        .collection("orders")
                        .document("arqHFzuojhY4MsqxRQcl")
                        .addSnapshotListener(new EventListener<DocumentSnapshot>() {
                            @Override
                            public void onEvent(@Nullable DocumentSnapshot value,
                                                @Nullable FirebaseFirestoreException error) {
                                if (error != null) {
                                    Log.i("testing", "arq error : "+ error.getMessage());
                                    return;
                                }

                                Log.d("testing", "arqOrder onEvent triggered");
                                int documentSize = firestoreDocument.getSize(value);
                                Log.d("testing", "document size : "+documentSize);
                                if (value.exists()) {
                                    FireStoreOrder fireStoreOrder = value.toObject(FireStoreOrder.class);
                                    if (fireStoreOrder != null && fireStoreOrder.getStatus() != null) {
                                        arqOrderStatus.setText(getString(R.string.concat_status, fireStoreOrder.getStatus()));
                                    }
                                }
                            }
                        });
            }
        });

        findViewById(R.id.stopOrderQuery3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (arqOrderListener != null) {
                    arqOrderListener.remove();
                }
                arqOrderStatus.setText(getString(R.string.concat_status, "-"));
            }
        });
        //-----------------------------------------------------------------------------------------
    }
}