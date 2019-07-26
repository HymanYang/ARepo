package arepo.yunji.com.myapplication;

/**
 * @Description:
 * @Author: yangZhou
 * @Copyright: 浙江集商优选电子商务有限公司
 * @CreateDate: 2019/5/21 14:05
 * @Version: 1.0.0
 */
public class GsonParseInfo {

    private int intStr;
    private long longStr;
    private double doubleStr;
    private float floadStr;
    private String strStr;
    private boolean booleanStr;


    public GsonParseInfo(int intStr, long longStr, double doubleStr, float floadStr, String strStr, boolean booleanStr) {
        this.intStr = intStr;
        this.longStr = longStr;
        this.doubleStr = doubleStr;
        this.floadStr = floadStr;
        this.strStr = strStr;
        this.booleanStr = booleanStr;
    }

    @Override
    public String toString() {
        return "GsonParseInfo{" +
                "intStr=" + intStr +
                ", longStr=" + longStr +
                ", doubleStr=" + doubleStr +
                ", floadStr=" + floadStr +
                ", strStr='" + strStr + '\'' +
                ", booleanStr=" + booleanStr +
                '}';
    }
}
