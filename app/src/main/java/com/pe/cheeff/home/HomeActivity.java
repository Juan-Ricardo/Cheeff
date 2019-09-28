package com.pe.cheeff.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.pe.cheeff.R;
import com.pe.cheeff.apirest.ApiClient;
import com.pe.cheeff.apirest.ApiService;
import com.pe.cheeff.home.adapter.ChildData;
import com.pe.cheeff.home.adapter.ParentData;
import com.pe.cheeff.home.adapter.PurchaseOrderRecycler;
import com.pe.cheeff.home.model.DataOrderResponse;
import com.pe.cheeff.home.model.DetailResponse;
import com.pe.cheeff.home.model.PurchaseOrderResponse;
import com.pe.cheeff.socket.SocketManager;
import com.pe.cheeff.socket.SocketUtils;
import com.pe.cheeff.utilities.Utilities;

import java.util.LinkedList;
import java.util.List;

import io.socket.emitter.Emitter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView purchaseOrderRecyclerView;
    private PurchaseOrderRecycler adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        finds();
    }

    private void finds() {
        purchaseOrderRecyclerView = findViewById(R.id.purchase_order_recycler_view);
    }

    private void loadPurchaseOrders() {
        Call<PurchaseOrderResponse> purchaseOrderResponse = ApiClient.getInstance(getBaseContext())
                .createService(ApiService.class)
                .getPurchaseOrderResponse();
        purchaseOrderResponse.enqueue(new Callback<PurchaseOrderResponse>() {
            @Override
            public void onResponse(Call<PurchaseOrderResponse> call, Response<PurchaseOrderResponse> response) {
                List<DataOrderResponse> dataOrderResponses = response.body().getData();
                showPurchaseOrder(dataOrderResponses);
            }

            @Override
            public void onFailure(Call<PurchaseOrderResponse> call, Throwable t) {

            }
        });
    }

    private void showPurchaseOrder(List<DataOrderResponse> dataOrderResponses) {
        List<ParentData> parentDataList = new LinkedList<>();
        for (DataOrderResponse row : dataOrderResponses) {

            String string = row.getCliente_id().getNombres() + "-" + row.getTotal() +
                    "-" + row.getFechaRegistro();
            List<DetailResponse> detalle = row.getDetalle();
            List<ChildData> childDataList = new LinkedList<>();
            for (DetailResponse detailResponse : detalle) {
                ChildData childData = new ChildData();
                childData.set_id(detailResponse.get_id());
                childData.setNombre(detailResponse.getNombre() + " - S/. " + detailResponse.getPrecio());
                childData.setPrecio(detailResponse.getPrecio());
                childDataList.add(childData);
            }

            ParentData parentData = new ParentData(string, childDataList);
            parentDataList.add(parentData);
        }
        adapter = new PurchaseOrderRecycler(this, parentDataList);
        purchaseOrderRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        purchaseOrderRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        purchaseOrderRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupSocket();
        nuevaOrdenDeCompra();
        loadPurchaseOrders();
    }

    private void setupSocket() {
        SocketManager.getInstance(this).connect();
    }

    private void nuevaOrdenDeCompra() {
        SocketManager.getInstance(this).on(SocketUtils.ON_ORDER, new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Object arg = args[0];
                        Utilities.createNotification(getApplicationContext());
                        loadPurchaseOrders();
                        //Toast.makeText(getBaseContext(), "" + arg, Toast.LENGTH_LONG).show();
                        //Log.v("ordendecompra: ", "" + arg);
                    }
                });

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SocketManager.getInstance(this).disconnect();
    }
}
