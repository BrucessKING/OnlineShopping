package top.bigking.entity;

import java.util.Map;

/**
 * @Author ABKing
 * @since 2020/4/20 下午5:38
 * 统一返回结果
 **/
public class ResponseData<T, E> {
    private Map<T, E> data;
    private Map<T, E> meta;

    public ResponseData(Map<T, E> data, Map<T, E> meta) {
        this.data = data;
        this.meta = meta;
    }

    public Map<T, E> getData() {
        return data;
    }

    public void setData(Map<T, E> data) {
        this.data = data;
    }

    public Map<T, E> getMeta() {
        return meta;
    }

    public void setMeta(Map<T, E> meta) {
        this.meta = meta;
    }
}
