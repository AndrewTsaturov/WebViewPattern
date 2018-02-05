package com.example.webviewpattern.view;


import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.example.webviewpattern.R;
import com.example.webviewpattern.presenter.IAppPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.DaggerActivity;


public class MainActivity extends DaggerActivity implements IView{

    @BindView(R.id.loading_screen_img_view) ImageView loadingImgView;
    @BindView(R.id.game_web_view) WebView gameWebView;

    AlertDialog networkWarningDialog;

    private int progressBarHeight;

    LinearLayout.LayoutParams params;

    @Inject
    IAppPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        ButterKnife.bind(this);

        params = (LinearLayout.LayoutParams) loadingImgView.getLayoutParams();
        progressBarHeight = params.height;

        gameWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                presenter.gameIsLoaded();

                super.onPageFinished(view, url);
            }
        });
        gameWebView.setWebChromeClient(new WebChromeClient());

        presenter.onViewInit();

        if(networkWarningDialog == null) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            dialogBuilder.setTitle(R.string.warning_gialog_title);
            dialogBuilder.setMessage(R.string.warning_dialog_msg);
            dialogBuilder.setPositiveButton(R.string.warning_dialog_pos_button,
                    (dialogInterface, i) -> presenter.onPositiveWarningClick());
            dialogBuilder.setNegativeButton(R.string.warnin_dialog_neg_button, (dialogInterface, i) ->
                    presenter.onNegativeWarningClick());
            networkWarningDialog = dialogBuilder.create();

        }

        networkWarningDialog.dismiss();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(presenter.isSettingsChanged()) presenter.onViewInit();
    }

    @Override
    protected void onDestroy() {
        stopView();

        super.onDestroy();

        stopView();
    }

    @Override
    public void showLoading() {
        params.height = progressBarHeight;

        loadingImgView.setLayoutParams(params);
        loadingImgView.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideLoading() {
        params.height = 0;

        loadingImgView.setLayoutParams(params);
        loadingImgView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showGame(String gameUrl) {
        gameWebView.loadUrl(gameUrl);
    }

    @Override
    public void showLackOfNewtworkWarning() {
        networkWarningDialog.show();
    }

    @Override
    public void showNetworkSettings() {
        startActivityForResult(new Intent(Settings.ACTION_SETTINGS), 0);
    }

    @Override
    public void stopView() {
        presenter.setSettingChanged(true);
        this.finish();
    }
}
