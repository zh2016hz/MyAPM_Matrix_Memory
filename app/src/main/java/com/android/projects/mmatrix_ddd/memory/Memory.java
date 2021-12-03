package com.android.projects.mmatrix_ddd.memory;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import com.android.projects.mmatrix_ddd.MyFrameDecorator;
import com.android.projects.mmatrix_ddd.memory.MemoryUtil;
public class Memory {
    private static Handler mainHandler = new Handler(Looper.getMainLooper());
    Runnable runnable = new Runnable() {

        private boolean flag;

        @Override
        public void run() {

            KLPAMemoryInfo memoryInfoInDebug = getMemoryInfoInDebug();
//            RabbitStorage.save(memInfo)
//            val eventType = RabbitUiEvent.MSG_UPDATE_MEMORY_VALUE
            String memoryStr= MemoryUtil.INSTANCE.formatFileSize(memoryInfoInDebug.totalSize);
            if(memoryInfoInDebug.totalSize >57123840*6){
                flag = true;
            }
            Log.e("内存", "FPS当前内存：" + memoryStr);
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    MyFrameDecorator.getInstance(mContext).getView().momoryView.setText(memoryStr);
                    MyFrameDecorator.getInstance(mContext).getView().momoryView.setTextColor(flag?MyFrameDecorator.getInstance(mContext).highColor:
                            MyFrameDecorator.getInstance(mContext).bestColor);
                }
            });

            handler.postDelayed(this, 2000L);
        }
    };
    private Handler handler;
    private Context mContext;

    public void open(Context context) {
        mContext = context;
        if (context == null) return;
        ActivityManager systemService = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        HandlerThread klpa_thread = new HandlerThread("klpa_thread");
        klpa_thread.start();
        handler = new Handler(klpa_thread.getLooper());
        handler.postDelayed(runnable, 2000L);
    }

    /**
     * 只能用在debug model,
     */
    private KLPAMemoryInfo getMemoryInfoInDebug() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);

        KLPAMemoryInfo memInfo = new KLPAMemoryInfo();
        memInfo.totalSize = (memoryInfo.getTotalPss()) * 1024; // 这个值比profiler中的total大一些
        memInfo.vmSize = (memoryInfo.dalvikPss) * 1024;   // 这个值比profiler中的 java 内存值小一些, Doesn't include other Dalvik overhead
        memInfo.nativeSize = memoryInfo.nativePss * 1024;
        memInfo.othersSize = memoryInfo.otherPss * 1024 + memoryInfo.getTotalSwappablePss() * 1024;
        memInfo.time = System.currentTimeMillis();
//        memInfo.pageName = RabbitMonitor.getCurrentPage();

        return memInfo;
    }
}
