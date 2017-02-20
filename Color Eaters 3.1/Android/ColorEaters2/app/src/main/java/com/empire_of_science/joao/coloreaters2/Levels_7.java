package com.empire_of_science.joao.coloreaters2;

/**
 * Class that represents a level package with 20 levels.
 * Created by João on 30/09/2016.
 */
class Levels_7 {
    /**
     * Returns the level.
     * @param level The level to be returned.
     * @return String[] with a string for each line and characters for each piece, plus the number of moves.
     */
    public static String[] getLevel(int level) {
        switch (level) {
            case 1:
                return new String[] {
                        "      ",
                        "      ",
                        "  bXB ",
                        "      ",
                        "      ",
                        "      ",
                        "3"
                };
            case 2:
                return new String[] {
                        "      ",
                        "BrW   ",
                        "gXG   ",
                        "wRb   ",
                        "      ",
                        "      ",
                        "6"
                };
            case 3:
                return new String[] {
                        "ggggXX",
                        "YXXXyX",
                        "  XXyB",
                        "X XXX ",
                        "XbbbX ",
                        "YbXbGR",
                        "22"
                };
            case 4:
                return new String[] {
                        "WBWYWY",
                        "YXGBXG",
                        "GXBWXB",
                        "BXGrXY",
                        "GXXXXW",
                        "WGYRBY",
                        "11"
                };
            case 5:
                return new String[] {
                        "w    w",
                        "  w   ",
                        "wX  X ",
                        " X wXw",
                        "XX  XX",
                        "WWWWWW",
                        "10"
                };
            case 6:
                return new String[] {
                        " XyX X",
                        "y    y",
                        "X X X ",
                        "  y y ",
                        " X X X",
                        "Y Y Y ",
                        "9"
                };
            case 7:
                return new String[] {
                        "   XXX",
                        " X X w",
                        "RXYXrG",
                        "WXBrBw",
                        " XGXwY",
                        "   XXX",
                        "17"
                };
            case 8:
                return new String[] {
                        "XwyrbX",
                        "WX  XB",
                        "Y    R",
                        "R    Y",
                        "BX  XW",
                        "XbrywX",
                        "28"
                };
            case 9:
                return new String[] {
                        " R  R ",
                        "yX    ",
                        "yyy Xy",
                        "yXyyyy",
                        "XyrrXy",
                        "XXXYrr",
                        "6"
                };
            case 10:
                return new String[] {
                        "gggggX",
                        "rrXggg",
                        "XrrXbb",
                        "WXrgXb",
                        "WWXBRX",
                        "rbrGbg",
                        "24"
                };
            case 11:
                return new String[] {
                        "      ",
                        " X GXB",
                        " XXXXX",
                        "   gbr",
                        " XXXXX",
                        "     R",
                        "30"
                };
            case 12:
                return new String[] {
                        "      ",
                        " XBRX ",
                        "rgXXby",
                        "byXXrg",
                        " XGYX ",
                        "      ",
                        "36"
                };
            case 13:
                return new String[] {
                        "WgbwBG",
                        "gBYrgX",
                        "BgXXgw",
                        "wyXXRb",
                        "XXrBGW",
                        "XXgWRb",
                        "17"
                };
            case 14:
                return new String[] {
                        "r   bR",
                        "r   Xb",
                        "yyyX  ",
                        " BXy  ",
                        "rXB   ",
                        "Yr    ",
                        "21"
                };
            case 15:
                return new String[] {
                        "X  Y g",
                        "gY   X",
                        "X  G b",
                        "b    X",
                        "X  B y",
                        "yG   X",
                        "16"
                };
            case 16:
                return new String[] {
                        "Byyyyy",
                        "rXXXXR",
                        "rbGRXR",
                        "rXXbRY",
                        "rXXXXg",
                        "gggggg",
                        "10"
                };
            case 17:
                return new String[] {
                        "rYryRy",
                        "yryryr",
                        "XXRXXX",
                        "yryrYr",
                        "ryryry",
                        "yRyrYr",
                        "9"
                };
            case 18:
                return new String[] {
                        "yrgXyr",
                        "GYRXry",
                        "XXXXyr",
                        "gRbXRY",
                        "bGrXyr",
                        "rBgXRy",
                        "9"
                };
            case 19:
                return new String[] {
                        "  wXy ",
                        "  wyr ",
                        "  YRW ",
                        "  wyr ",
                        "  rXw ",
                        "  wry ",
                        "9"
                };
            case 20:
                return new String[] {
                        "  gB  ",
                        " BXXg ",
                        "gXXXXb",
                        "bXXXXg",
                        " GXXb ",
                        " bGbG ",
                        "19"
                };

            default:
                return new String[0];

        }
    }
}
