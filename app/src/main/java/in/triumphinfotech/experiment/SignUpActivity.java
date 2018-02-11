package in.triumphinfotech.experiment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        // Left arrow takes from signup to connectup
        Button signUpToConnectUp = (Button)findViewById(R.id.btnLftArrowSignUp);
        signUpToConnectUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpToConnectUpIntent = new Intent(SignUpActivity.this, ConnectUpActivity.class);
                startActivity(signUpToConnectUpIntent);
            }
        });

    }
    public void callsignupApi(View v)
    {
        EditText firstname  = (EditText)findViewById(R.id.firstname);
        EditText lastname = (EditText)findViewById(R.id.lastname);
        EditText emailId = (EditText)findViewById(R.id.emailid);
        EditText phonenumber = (EditText)findViewById(R.id.phonenumber);
        EditText Password = (EditText)findViewById(R.id.password);
        EditText Country = (EditText) findViewById(R.id.country);

        String username = (firstname.getText() + " "+lastname.getText());
        String emailid = emailId.getText()+"";
        String phone_number = phonenumber.getText()+"";
        String password = Password.getText()+"";
        String country = Country.getText()+ "";

        if(username == null || emailid == null || password == null || country == null)
        {
            Toast.makeText(getApplicationContext(),"Please enter all the details ",Toast.LENGTH_LONG).show();
        }
        else
        {
            try {
                RequestQueue requestQueue = Volley.newRequestQueue(this);
                String URL = "http://192.168.0.101:1000/api/v1/users";
                JSONObject jsonBody = new JSONObject();
                jsonBody.put("username",username);
                jsonBody.put("password", password);
                jsonBody.put("country", country);
                jsonBody.put("phone_number", phone_number);
                jsonBody.put("email", emailid);

                final String mRequestBody = jsonBody.toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(),"connection error",Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("LOG_VOLLEY", error.toString());
                    }
                }) {
                    @Override
                    public String getBodyContentType() {
                        return "application/json; charset=utf-8";
                    }

                    @Override
                    public byte[] getBody() throws AuthFailureError {
                        try {
                            return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                        } catch (UnsupportedEncodingException uee) {
                            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
                            return null;
                        }
                    }

                    @Override
                    protected Response<String> parseNetworkResponse(NetworkResponse response) {
                        String responseString = "";
                        if (response != null) {

                            responseString = String.valueOf(response.statusCode);

                        }
                        return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                    }
                };

                requestQueue.add(stringRequest);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }
}
