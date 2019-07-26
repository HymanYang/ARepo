package arepo.yunji.com.myapplication;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * @Description: Double数字类型转换
 * @Author: yangZhou
 * @Copyright: 浙江集商优选电子商务有限公司
 * @CreateDate: 2019/5/21 9:33
 * @Version: 1.0.0
 */
public class DoubleTypeAdapter extends TypeAdapter<Double> {

    @Override
    public void write(JsonWriter out, Double value) throws IOException {

        if (value == null) {
            out.value("0");
            return;
        }

        out.value(String.valueOf(value));
    }

    @Override
    public Double read(JsonReader in) throws IOException {
        try {

            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return 0d;
            } else {
                String s = in.nextString();
                return Double.valueOf(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0d;
        }
    }
}
