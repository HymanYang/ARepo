package arepo.yunji.com.myapplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.Reader;
import java.lang.reflect.Type;

/**
 * Gson工具类
 * Created by wxx on 2015/11/5.
 */
public class GsonUtils {

    private GsonUtils() {
    }

    private static Gson gson;

    public static void setGson(Gson gson) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }
        GsonUtils.gson = gson;
    }

    public static Gson getInstance() {
        return getGson();
    }


    /**
     * DES:
     * AUTHOR: yangZhou
     * TIME: 2019/5/21 11:38
     *
     * @return com.google.gson.Gson
     * ====================================
     * @UpdateUser: 添加Type适配器
     * @UpdateDate: 2019/5/21 11:38
     * @UpdateRemark:
     */
    public static Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
//                    .serializeNulls()
                    .registerTypeAdapter(Integer.class, new IntegerTypeAdapter())
                    .registerTypeAdapter(int.class, new IntegerTypeAdapter())
                    .registerTypeAdapter(Double.class, new DoubleTypeAdapter())
                    .registerTypeAdapter(double.class, new DoubleTypeAdapter())
                    .registerTypeAdapter(Float.class, new FloatTypeAdapter())
                    .registerTypeAdapter(float.class, new FloatTypeAdapter())
                    .registerTypeAdapter(Long.class, new LongTypeAdapter())
                    .registerTypeAdapter(long.class, new LongTypeAdapter())
                    .registerTypeAdapter(String.class, new StringTypeAdapter())
                    .disableHtmlEscaping()
                    .create();
        }
        return gson;
    }

    public static String toJson(Object obj) {
        return getGson().toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return getGson().fromJson(json, clazz);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return getGson().fromJson(json, typeOfT);
    }

    public static <T> T fromJson(Reader reader, Type typeOfT) {
        return getGson().fromJson(reader, typeOfT);
    }

    /**
     * 根据key获取某个值
     *
     * @param json
     * @param key
     * @return
     */
    public static final String getValue(String json, String key) {
        try {
            JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
            return obj.get(key).getAsString();
        } catch (Exception e) {
            return null;
        }
    }
}
