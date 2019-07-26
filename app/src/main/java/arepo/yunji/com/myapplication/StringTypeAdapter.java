package arepo.yunji.com.myapplication;

import android.text.TextUtils;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * @Description: String数字类型转换
 * @Author: yangZhou
 * @Copyright: 浙江集商优选电子商务有限公司
 * @CreateDate: 2019/5/21 10:00
 * @Version: 1.0.0
 */
public class StringTypeAdapter extends TypeAdapter<String> {
    @Override
    public void write(JsonWriter out, String value) throws IOException {

        if (TextUtils.isEmpty(value)) {
            out.value("");
            return;
        }

        out.value(String.valueOf(value));
    }

    @Override
    public String read(JsonReader in) throws IOException {

        String result = "";
        try {

            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                result = "";
            } else if (in.peek() == JsonToken.BOOLEAN) {
                result = in.nextBoolean() ? "true" : "false";
            } else {
                result = in.nextString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }
}
