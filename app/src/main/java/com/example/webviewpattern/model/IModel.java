package com.example.webviewpattern.model;


/**
 * Created by Дом on 31.01.2018.
 */

public interface IModel {
    String SERVER_RESPONSE_POSITIVE = "1";
    String SERVER_RESPONSE_NEGATIVE = "0";

    String getUrl();

    boolean isConnected();

    boolean getServerResponse();

    String getServerLink();
}
