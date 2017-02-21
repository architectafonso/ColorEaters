package com.empire_of_science.joao.coloreaters2;

/**
 * Class that represents a level package with 20 levels.
 * Created by João on 15/12/2015.
 */
class Levels_3 {
    /**
     * Returns the level.
     * @param level The level to be returned.
     * @return String[] with a string for each line and characters for each piece, plus the number of moves.
     */
    public static String[] getLevel(int level){
        switch(level){
            case 1:
                return new String[]{
                        "gbbbbb",
                        "BGRggg",
                        "rrwrrr",
                        "wwgWbw",
                        "yyyywy",
                        "bbbbYB",
                        "5"
                };
            case 2:
                return new String[]{
                        "wwwwww",
                        "w w w ",
                        " WBWR ",
                        " GWYW ",
                        " byby ",
                        " ggrr ",
                        "5"
                };
            case 3:
                return new String[]{
                        "      ",
                        "      ",
                        " rbyg ",
                        " ggby ",
                        " RBYG ",
                        "      ",
                        "5"
                };
            case 4:
                return new String[]{
                        "      ",
                        "      ",
                        " yrgb ",
                        " rgby ",
                        " GBYR ",
                        "      ",
                        "6"
                };
            case 5:
                return new String[]{
                        "  RY  ",
                        " RyrY ",
                        "RywbrY",
                        "WbrywB",
                        " WbwB ",
                        "  WB  ",
                        "6"
                };
            case 6:
                return new String[]{
                        " W    ",
                        " W   W",
                        "   w  ",
                        "W    w",
                        " w  W ",
                        "w  w w",
                        "4"
                };
            case 7:
                return new String[]{
                        "      ",
                        "      ",
                        " gbyg ",
                        " rgby ",
                        " GBYR ",
                        "      ",
                        "5"
                };
            case 8:
                return new String[]{
                        "  b   ",
                        "  g   ",
                        "  B   ",
                        " b g  ",
                        "  G   ",
                        "  b   ",
                        "5"
                };
            case 9:
                return new String[]{
                        "rbrbrb",
                        "brbrbr",
                        "GY  GY",
                        "  BR  ",
                        "ygygyg",
                        "gygygy",
                        "12"
                };
            case 10:
                return new String[]{
                        "Gbbbbb",
                        "b    g",
                        "b    g",
                        "b    g",
                        "b    g",
                        "gggggB",
                        "11"
                };
            case 11:
                return new String[]{
                        "yyRyyy",
                        "ywwwwy",
                        "ywrrwy",
                        "ywYrwy",
                        "ywwwwy",
                        "Wyyyyy",
                        "4",
                };
            case 12:
                return new String[]{
                        "rryyyr",
                        "yrryyy",
                        "rrryrr",
                        "yyrryy",
                        "ryryry",
                        "YRYRYR",
                        "7"
                };
            case 13:
                return new String[]{
                        "      ",
                        "ryryry",
                        "  YR  ",
                        "  RY  ",
                        "yryryr",
                        "      ",
                        "10"
                };
            case 14:
                return new String[]{
                        "bgbgbg",
                        "G  BG ",
                        "bgbgbg",
                        "G   G ",
                        "bgbgbg",
                        " B B  ",
                        "8"
                };
            case 15:
                return new String[]{
                        "YryryR",
                        "ryryry",
                        "yrYRyr",
                        "ryRYry",
                        "yryryr",
                        "RyryrY",
                        "8"
                };
            case 16:
                return new String[]{
                        "w w W ",
                        " W w w",
                        "W w w ",
                        " w W w",
                        "w W w ",
                        " w w W",
                        "6"
                };
            case 17:
                return new String[]{
                        "W    Y",
                        "W yw Y",
                        "Wy  wY",
                        "Wy  wY",
                        "W yw Y",
                        "W    Y",
                        "9"
                };
            case 18:
                return new String[]{
                        "gYWrWb",
                        "gYWWYb",
                        "gWRGRb",
                        "gRRYWb",
                        "gYwBYb",
                        "gYYYRb",
                        "5"
                };
            case 19:
                return new String[]{
                        "      ",
                        "  y   ",
                        " rgy  ",
                        "YG  BR",
                        " bgb  ",
                        "      ",
                        "7"
                };
            case 20:
                return new String[]{
                        "      ",
                        "      ",
                        "  yBg ",
                        "  R Y ",
                        "  bGr ",
                        "      ",
                        "4"
                };
            default:
                return new String[]{};
        }
    }
}
