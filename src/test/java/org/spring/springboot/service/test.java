package org.spring.springboot.service;

import java.math.BigDecimal;

/**
 * @author ZhangDaPang 285296372@qq.com
 * @date 2018/6/29 16:19
 */
public class test {
    public static void main(String[] args) {
        String str = "11881191.0534 4776900.6166, 11881109.3749 4776864.5703, 11881024.2157 4776802.6473, 11880917.1411 4776726.228, 11880816.5172 4776670.4385, 11880791.3459 4776608.0106, 11880856.8461 4776519.8446, 11880881.8437 4776446.0772, 11880867.4074 4776319.8866, 11880812.4281 4776265.1677, 11880796.177 4776170.7925, 11880850.9643 4776084.1332, 11880866.9393 4776015.7304, 11880905.1696 4776038.9914, 11880924.5563 4776069.0998, 11880949.2011 4776108.1869, 11880982.3027 4776141.923, 11881032.3921 4776168.847, 11881077.4025 4776200.4084, 11881098.4851 4776230.4844, 11881134.8974 4776255.7256, 11881179.7477 4776278.8588, 11881221.0844 4776295.5739, 11881245.2976 4776311.9702, 11881280.2137 4776347.6166, 11881299.6393 4776379.6702, 11881332.6067 4776406.2745, 11881355.3119 4776415.5655, 11881191.0534 4776900.6166";

        System.out.println(getFourPos(str));
        BigDecimal decimal = new BigDecimal("11882013.026999999");
        System.out.println(decimal);
        System.out.println();
    }

    public static String getFourPos(String str){
        BigDecimal maxX = new BigDecimal(Double.MIN_VALUE);
        BigDecimal maxY = new BigDecimal(Double.MIN_VALUE);
        BigDecimal minX = new BigDecimal(Double.MAX_VALUE);
        BigDecimal minY = new BigDecimal(Double.MAX_VALUE);
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String tempStr = split[i];
            String[] tempSplit = tempStr.split(" ");
            String[] finalSplit = new String[2];
            if("".equals(tempSplit[0]))
                System.arraycopy(tempSplit, 1, finalSplit, 0, 2);
            else
                finalSplit = tempSplit;


            for (int j = 0; j < finalSplit.length; j++) {
                BigDecimal temp = new BigDecimal(finalSplit[j]);
                if(0 == j){//x
                    maxX = maxX.max(temp);
                    minX = minX.min(temp);
                }else {//y
                    maxY = maxY.max(temp);
                    minY = minY.min(temp);
                }
            }
        }

        return maxY.toString() + "," + maxX.toString() + "," + minY.toString() + "," + minX.toString();
    }
}
