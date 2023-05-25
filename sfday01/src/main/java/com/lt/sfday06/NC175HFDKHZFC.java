package com.lt.sfday06;

//NC175 --合法的括号字符串

/*
给定一个字符串s，字符串s只包含以下三种字符: (，*，)，请你判断 s是不是一个合法的括号字符串。合法括号字符串有如下规则:
1.左括号'('必须有对应的右括号')'
2.右括号')'必须有对应的左括号'('
3.左括号必须在对应的右括号前面
4.*可以视为单个左括号，也可以视为单个右括号，或者视为一个空字符
5.空字符串也视为合法的括号字符串

 思路：  碰到左括号 最大嘴皮匹配次数都加1
        碰到右括号都减1(如果最小匹配次数大于0才减1  如果最大匹配次数为0直接返回false)
        碰到* 最大匹配次数+1 最小匹配次数-1(只有最小匹配次数大于0才减1)
        最后判断最小匹配次数是否为0 为0说明可以匹配完

 */
public class NC175HFDKHZFC {
    public static void main(String[] args) {
        System.out.println(isValidString("()()"));
    }

    //判断左括号是否能全部消除
    //min 代表 未匹配的左括号数    [将*全看作右括号(或空) 去匹配左括号(或跳过当前*号)]
    //max 代表 将*全看作左括号 期待右括号来匹配

    public static boolean isValidString (String s) { // 贪心算法
        //判断左括号是否能全部消除
        int minMatch = 0; //最小次数  最小是0 不能为负数
        int maxMatch = 0; //最大次数
        if(s.length() == 0) return true; //长度为0直接返回

        for(Character ch : s.toCharArray()){
            if(ch == '(') {//为左括号 min \ max 均加1
                minMatch ++;
                maxMatch ++;
            }

            else if(ch == ')'){//为右括号 min \ max 均减1
                if(minMatch > 0)  minMatch --; // min 代表 未匹配的左括号数
                if(maxMatch == 0) return false; //左右括号抵消完第一个字符就是右括号  直接返回false
                maxMatch --;
            }

            else if(ch == '*'){ //为*号 min-1  max+1
                if(minMatch >0){ //未匹配的左括号数大于0时碰到*号-1，未匹配的左括号数=0跳过*号
                    minMatch --;
                }
                maxMatch ++;
            }

        }

        //字符串全部过了一遍，左括号都+1 右括号都-1  *号min-1 max+1  min=0刚好全部匹配
        // 减1时会有特殊情况 max=0 和min=0都说明前面左右括号和*号可以全部抵消
        // (max=0 再想-1) (max=0  *号当作左括号)，当前字符为右括号 直接返回false
        // (min=0 再想-1) (min=0 *号当作右括号或者空) 匹配抵消之后，前面可能余有*号
        return minMatch == 0;
    }
}
