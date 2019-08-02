package com.example.luckywheel.apiManager;

import android.content.Context;



import java.io.IOException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.luckywheel.BuildConfig.DEBUG;

public class RetrofitClint {
    private static final String BASE_URL = "http://192.168.0.102:3000/";


    private static OkHttpClient provideClient(final Context context) {


        HttpLoggingInterceptor mLoggingInterceptor = new HttpLoggingInterceptor();
        mLoggingInterceptor.setLevel(DEBUG ? HttpLoggingInterceptor.Level.BODY :
                HttpLoggingInterceptor.Level.NONE);
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        if (getSSLClint(client)!=null) {
            client = getSSLClint(client);
        }

        return  client
                .addInterceptor(mLoggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();
    }

    private static Retrofit provideRetrofit(Context context) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(provideClient(context))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    private static Retrofit provideRetrofitWithoutHeader() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        if (DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            client.connectTimeout(100, TimeUnit.SECONDS);
            client.addInterceptor(interceptor);
           /* if (getSSLClint(client)!=null) {
                client = getSSLClint(client);
            }*/
        }
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
    }





    public static ApiService getApiService(Context context) {
        return provideRetrofit(context).create(ApiService.class);
    }



    public static ApiService getApiServiceWithoutHeader() {
        return provideRetrofitWithoutHeader().create(ApiService.class);
    }



    public static OkHttpClient.Builder getSSLClint(OkHttpClient.Builder client) {
        final TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {

                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new java.security.cert.X509Certificate[]{};
                    }
                }
        };

        try {

            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);

            SSLContext sslContext = SSLContext.getInstance("TLS");

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, "keystore_pass".toCharArray());
            sslContext.init(null, trustAllCerts, new SecureRandom());
            X509TrustManager trustManager = (X509TrustManager) trustAllCerts[0];
            client.sslSocketFactory(sslContext.getSocketFactory(),trustManager).hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            /*client.sslSocketFactory(sslContext.getSocketFactory())
                    .hostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname, SSLSession session) {
                            return true;
                        }
                    });*/
            return client;
        }catch (Exception w) {
            w.getMessage();
            return null;
        }

    }
}

