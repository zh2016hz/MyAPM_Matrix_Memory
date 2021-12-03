package com.android.projects.mmatrix_ddd.memory;



/**
 *  at 2021-12-03
 */
public class KLPAMemoryInfo {

    public Long id;

    public Long time;

    public int totalSize;

    public int vmSize;

    public int nativeSize;

    public int othersSize;

    public String pageName;

    public KLPAMemoryInfo(Long id, Long time, int totalSize, int vmSize,
                          int nativeSize, int othersSize, String pageName) {
        this.id = id;
        this.time = time;
        this.totalSize = totalSize;
        this.vmSize = vmSize;
        this.nativeSize = nativeSize;
        this.othersSize = othersSize;
        this.pageName = pageName;
    }

    public KLPAMemoryInfo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTime() {
        return this.time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getVmSize() {
        return this.vmSize;
    }

    public void setVmSize(int vmSize) {
        this.vmSize = vmSize;
    }

    public int getNativeSize() {
        return this.nativeSize;
    }

    public void setNativeSize(int nativeSize) {
        this.nativeSize = nativeSize;
    }

    public int getOthersSize() {
        return this.othersSize;
    }

    public void setOthersSize(int othersSize) {
        this.othersSize = othersSize;
    }

    public String getPageName() {
        return this.pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public void setTime(Long time) {
        this.time = time;
    }


}
