package com.fajarnandagusti.cataloguemoviefinal.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by Gustiawan on 11/17/2018.
 */

public class StackWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new StackRemoteViewFactory(this.getApplicationContext(), intent);
    }
}
