package com.color.eaters;

/**
 * Class that represents a level package with 20 levels.
 * Created by João on 15/12/2015.
 */
class Levels_5 {
    /**
     * Returns the level.
     * @param level The level to be returned.
     * @return String[] with a string for each line and characters for each piece, plus the number of moves.
     */
    static String[] getLevel(int level){
        switch(level){
            case 18:
                return new String[]{
                        "yr rrr",
                        "Bryb  ",
                        "Rybwbw",
                        "wy bbb",
                        "  w wb",
                        " Y Wb ",
                        "14"
                };
            case 19: //
                return new String[]{
                        "W    W",
                        "g    g",
                        "yrYYrw",
                        "gwRRgw",
                        "w    y",
                        "G    G",
                        "14"
                };
            case 8:
                return new String[]{
                        "gygygy",
                        "rbrbrb",
                        "gygygy",
                        "rbrbrb",
                        "GYGYGY",
                        "RBRBRB",
                        "23"
                };
            case 17:
                return new String[]{
                        " grgR ",
                        "grGrgr",
                        "RgrgrG",
                        "grgrgr",
                        "rGrgRg",
                        " rgrg ",
                        "8"
                };
            case 1:
                return new String[]{
                        " BG W ",
                        " y  g ",
                        " g  r ",
                        " b  g ",
                        " g  w ",
                        "  RGY ",
                        "18"
                };
            case 2: //
                return new String[]{
                        "  rg  ",
                        " rgRg ",
                        "rGrgrg",
                        "grgRgr",
                        " GrgR ",
                        "  gr  ",
                        "7"
                };
            case 20:
                return new String[]{
                        "brbrbr",
                        "rGrbYb",
                        "brbrbr",
                        "gygyRy",
                        "Bgygyg",
                        "gygygy",
                        "18"
                };
            case 16:
                return new String[]{
                        "yrgbw ",
                        "rrgbwY",
                        "gggbwR",
                        "bbbbwG",
                        "wwwwwB",
                        " BGRYW",
                        "13"
                };
            case 3:
                return new String[]{
                        "      ",
                        "   wr ",
                        "by   g",
                        "RGBYW ",
                        "      ",
                        "      ",
                        "10"
                };
            case 9:
                return new String[]{
                        "Y     ",
                        "By  y ",
                        "Rby   ",
                        " rby  ",
                        "  rb  ",
                        "r  r  ",
                        "12"
                };
            case 10:
                return new String[]{
                        "RYBG R",
                        "  gr B",
                        "G rb Y",
                        "B gr G",
                        "Y rbg ",
                        "R GYBR",
                        "7"
                };
            case 11:
                return new String[]{
                        " YYYY ",
                        " bbbb ",
                        " GGGG ",
                        " yyyy ",
                        " gggg ",
                        " BBBB ",
                        "6"
                };
            case 13:
                return new String[]{
                        "   w  ",
                        "  YgB ",
                        " WGby ",
                        "   wr ",
                        "  R W ",
                        "      ",
                        "6"
                };
            case 14:
                return new String[]{
                        "      ",
                        "ry G  ",
                        "Wrbrw ",
                        "b g Y ",
                        "R w B ",
                        "g     ",
                        "18"
                };
            case 6:
                return new String[]{
                        "Bwbwbw",
                        "wbWbwb",
                        "bwbwBw",
                        "wBwbwb",
                        "bwbWbw",
                        "wbwbwB",
                        "8"
                };
            case 15:
                return new String[]{
                        "rYryry",
                        "yRyryR",
                        "ry  ry",
                        "yr  yr",
                        "rYryrY",
                        "yryRyr",
                        "8"
                };
            case 12:
                return new String[]{
                        "ryryry",
                        "YryryR",
                        "YrryyR",
                        "YryRRY",
                        "ryryyr",
                        "yryryr",
                        "7"
                };
            case 5:
                return new String[]{
                        "grGRGr",
                        "rgrgrg",
                        "GrgrGr",
                        "RgrgRg",
                        "grgrgr",
                        "rgrGRg",
                        "8"
                };
            case 7:
                return new String[]{
                        "ryryrG",
                        "yRyrYr",
                        "Ryryry",
                        "yrYryr",
                        "ryryry",
                        "ygyryr",
                        "18"
                };
            case 4:
                return new String[]{
                        "rYryry",
                        "Yryryr",
                        "rYryry",
                        "yRyryr",
                        "Ryryry",
                        "yRyryr",
                        "12",
                };
            default:
                return new String[0];
        }
    }

}